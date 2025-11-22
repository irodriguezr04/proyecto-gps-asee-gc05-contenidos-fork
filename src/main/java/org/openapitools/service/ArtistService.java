package org.openapitools.service;

import org.openapitools.model.Artist;
import org.openapitools.persistence.entities.ArtistEntity;
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
public class ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    /**
     * Tarea: Crear endpoint REST (GET /artists)
     * Busca todos los artistas en la base de datos.
     */
    public List<Artist> findAll() {
        List<ArtistEntity> entities = artistRepository.findAll();
        // Convierte la lista de Entidades (BD) a una lista de DTOs (API)
        return entities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Tarea: Crear endpoint REST (GET /artists/{id})
     * Busca un artista por su ID.
     */
    public Optional<Artist> findById(String idStr) {
        try {
            // CORRECCIÓN: Parsear String a Long
            Long id = Long.parseLong(idStr);
            return artistRepository.findById(id).map(this::toDto);
        } catch (NumberFormatException e) {
            // Si el ID no es un número, devolvemos vacío (404)
            return Optional.empty();
        }
    }

    /**
     * HU6: Listado de artistas con Paginación y Filtros.
     */
    public List<Artist> findArtists(Integer page, Integer size, String name, String genre) {
        
        // 1. Configuración de Paginación (Default: pág 0, 10 elementos, orden alfabético)
        int pageNumber = (page != null) ? page : 0;
        int pageSize = (size != null) ? size : 10;
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("name").ascending());

        Page<ArtistEntity> pageResult;

        boolean hasName = (name != null && !name.isEmpty());
        boolean hasGenre = (genre != null && !genre.isEmpty());

        // 2. Selección de Estrategia de Búsqueda
        if (hasName && hasGenre) {
            // Filtrar por Nombre Y Género
            pageResult = artistRepository.findByNameContainingIgnoreCaseAndGenreContainingIgnoreCase(name, genre, pageable);
        } else if (hasName) {
            // Filtrar solo por Nombre
            pageResult = artistRepository.findByNameContainingIgnoreCase(name, pageable);
        } else if (hasGenre) {
            // Filtrar solo por Género
            pageResult = artistRepository.findByGenreContainingIgnoreCase(genre, pageable);
        } else {
            // Sin filtros -> Devolver todos paginados
            pageResult = artistRepository.findAll(pageable);
        }

        // 3. Conversión a DTO
        return pageResult.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Método privado de conversión.
     * Convierte una ArtistEntity (de la BD) a un Artist (DTO de la API).
     */
    private Artist toDto(ArtistEntity entity) {
        Artist dto = new Artist();
        // CORRECCIÓN: Convertir Long a String
        dto.setId(entity.getId().toString());
        
        dto.setName(entity.getName());
        dto.setUserId(entity.getUserId());
        dto.setDescription(entity.getDescription());
        dto.setGenre(entity.getGenre());
        return dto;
    }
}