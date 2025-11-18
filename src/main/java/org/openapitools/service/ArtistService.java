package org.openapitools.service;

import org.openapitools.model.Artist;
import org.openapitools.persistence.entities.ArtistEntity;
import org.openapitools.persistence.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Optional<Artist> findById(String id) {
        Optional<ArtistEntity> entity = artistRepository.findById(id);
        // Convierte la Entidad (si existe) a un DTO
        return entity.map(this::toDto);
    }

    /**
     * Método privado de conversión.
     * Convierte una ArtistEntity (de la BD) a un Artist (DTO de la API).
     */
    private Artist toDto(ArtistEntity entity) {
        Artist dto = new Artist();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setUserId(entity.getUserId());
        dto.setDescription(entity.getDescription());
        dto.setGenre(entity.getGenre());
        return dto;
    }
}