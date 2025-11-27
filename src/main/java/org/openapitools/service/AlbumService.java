package org.openapitools.service;

import org.openapitools.model.Album;
import org.openapitools.model.CreateAlbumRequest;
import org.openapitools.persistence.entities.AlbumEntity;
import org.openapitools.persistence.entities.ArtistEntity;
import org.openapitools.persistence.repositories.AlbumRepository;
import org.openapitools.persistence.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ArtistRepository artistRepository;

    // --- GET ALL (Sin paginar, por si acaso) ---
    public List<Album> findAll() {
        List<AlbumEntity> entities = albumRepository.findAll();
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    // --- GET BY ID (Adaptado a Long) ---
    public Optional<Album> findById(String idStr) {
        try {
            Long id = Long.parseLong(idStr);
            return albumRepository.findById(id).map(this::toDto);
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    // --- CREATE ALBUM (Adaptado a Long y sin UUID) ---
    public Album createAlbum(String artistIdStr, CreateAlbumRequest request) {
        // 1. Buscar al artista (Parseando ID)
        Long artistId;
        try {
            artistId = Long.parseLong(artistIdStr);
        } catch (NumberFormatException e) {
            throw new RuntimeException("ID de artista inválido");
        }

        ArtistEntity artist = artistRepository.findById(artistId)
                .orElseThrow(() -> new RuntimeException("Artista no encontrado"));

        // --- VALIDACIÓN 1: DUPLICADOS ---
        if (albumRepository.existsByTitleAndArtist(request.getTitle(), artist)) {
            throw new IllegalArgumentException("Error: El artista ya tiene un álbum llamado '" + request.getTitle() + "'");
        }

        // --- VALIDACIÓN 2: FORMATO IMAGEN ---
        String url = request.getCoverUrl().toLowerCase();
        if (!url.endsWith(".jpg") && !url.endsWith(".jpeg") && !url.endsWith(".png") && !url.endsWith(".webp")) {
             throw new IllegalArgumentException("Error: La portada debe ser una imagen URL (.jpg, .png, .webp)");
        }

        // 3. Crear la entidad
        AlbumEntity entity = new AlbumEntity();
        // NO GENERAMOS ID (La BD lo hace con SERIAL)
        
        entity.setTitle(request.getTitle());
        entity.setReleaseDate(request.getReleaseDate());
        entity.setCoverUrl(request.getCoverUrl());
        entity.setArtist(artist);

        // 4. Guardar
        AlbumEntity saved = albumRepository.save(entity);
        return toDto(saved);
    }
    
    // --- FIND BY ARTIST (Adaptado a Long) ---
    public List<Album> findByArtistId(String artistIdStr) {
        try {
            Long artistId = Long.parseLong(artistIdStr);
            // Filtramos en memoria (o mejor, usa un método de repo findByArtistId si lo creaste)
            return albumRepository.findAll().stream()
                    .filter(album -> album.getArtist().getId().equals(artistId))
                    .map(this::toDto)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            return List.of();
        }
    }

/**
     * HU6: Búsqueda por Tipo (Album, Artista) + Filtro Género
     */
    public List<Album> findAlbums(Integer page, Integer size, String search, String searchType, String genre) {
        int pageNumber = (page != null) ? page : 0;
        int pageSize = (size != null) ? size : 10;
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("title").ascending());

        if (genre != null && (genre.trim().isEmpty() || "Todas".equalsIgnoreCase(genre))) genre = null;
        if (search != null && search.trim().isEmpty()) search = null;
        if (searchType == null) searchType = "album";

        Page<AlbumEntity> pageResult;

        System.out.println("🔍 BUSCANDO: Tipo='" + searchType + "', Query='" + search + "', Genre='" + genre + "'");

        if (search == null) {
            // Sin texto de búsqueda
            if (genre != null) pageResult = albumRepository.findByArtist_GenreContainingIgnoreCase(genre, pageable);
            else pageResult = albumRepository.findAll(pageable);
        } else {
            // Con texto de búsqueda
            switch (searchType.toLowerCase()) {
                case "artist":
                    // Buscar por Artista
                    pageResult = albumRepository.findByArtist_NameContainingIgnoreCase(search, pageable);
                    break;
                    
                // case "track": ELIMINADO PORQUE NO LO QUIERES
                    
                case "album":
                default:
                    // Buscar por Título del Álbum
                    pageResult = albumRepository.findByTitleContainingIgnoreCase(search, pageable);
                    break;
            }
        }

        return pageResult.stream().map(this::toDto).collect(Collectors.toList());
    }

    // --- Conversor a DTO (Adaptado a toString) ---
    private Album toDto(AlbumEntity entity) {
        Album dto = new Album();
        // Convertimos Long a String para la API
        dto.setId(entity.getId().toString()); 
        
        dto.setTitle(entity.getTitle());
        dto.setReleaseDate(entity.getReleaseDate());
        dto.setCoverUrl(entity.getCoverUrl());
        
        if (entity.getArtist() != null) {
            // Convertimos Long a String aquí también
            dto.setArtistId(entity.getArtist().getId().toString());
        }
        return dto;
    }
}