package org.openapitools.service;

import org.openapitools.model.Album;
import org.openapitools.model.CreateAlbumRequest;
import org.openapitools.persistence.entities.AlbumEntity;
import org.openapitools.persistence.entities.ArtistEntity;
import org.openapitools.persistence.repositories.AlbumRepository;
import org.openapitools.persistence.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ArtistRepository artistRepository;

    public List<Album> findAll() {
        List<AlbumEntity> entities = albumRepository.findAll();
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Optional<Album> findById(String id) {
        return albumRepository.findById(id).map(this::toDto);
    }

public Album createAlbum(String artistId, CreateAlbumRequest request) {
        // 1. Buscar al artista
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

        // 3. Crear la entidad (si pasa las validaciones)
        AlbumEntity entity = new AlbumEntity();
        entity.setId("alb_" + UUID.randomUUID().toString());
        entity.setTitle(request.getTitle());
        entity.setReleaseDate(request.getReleaseDate());
        entity.setCoverUrl(request.getCoverUrl());
        entity.setArtist(artist);

        // 4. Guardar
        AlbumEntity saved = albumRepository.save(entity);
        return toDto(saved);
    }
    
    public List<Album> findByArtistId(String artistId) {
        // Filtramos los álbumes que pertenezcan a este ID de artista
        return albumRepository.findAll().stream()
                .filter(album -> album.getArtist().getId().equals(artistId))
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    // --- Conversor a DTO ---
    private Album toDto(AlbumEntity entity) {
        Album dto = new Album();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setReleaseDate(entity.getReleaseDate());
        dto.setCoverUrl(entity.getCoverUrl());
        
        if (entity.getArtist() != null) {
            dto.setArtistId(entity.getArtist().getId());
        }
        return dto;
    }
}