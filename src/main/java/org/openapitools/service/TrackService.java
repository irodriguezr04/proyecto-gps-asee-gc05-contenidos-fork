package org.openapitools.service;

import org.openapitools.model.Track;
import org.openapitools.model.UploadTrackRequest;
import org.openapitools.persistence.entities.AlbumEntity;
import org.openapitools.persistence.entities.TrackEntity;
import org.openapitools.persistence.repositories.AlbumRepository;
import org.openapitools.persistence.repositories.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional 
public class TrackService {

    @Autowired
    private TrackRepository trackRepository;

    @Autowired
    private AlbumRepository albumRepository;

    public List<Track> findAll() {
        List<TrackEntity> entities = trackRepository.findAll();
        return entities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public Optional<Track> findById(String idStr) {
        try {
            return trackRepository.findById(Long.parseLong(idStr)).map(this::toDto);
        } catch (NumberFormatException e) { return Optional.empty(); }
    }

    public Track createTrackForAlbum(String idAlbumStr, UploadTrackRequest dto) {
        // PARSEO DE ID (String -> Long)
        Long idAlbum = Long.parseLong(idAlbumStr);

        // 1. Buscar álbum
        AlbumEntity album = albumRepository.findById(idAlbum)
                .orElseThrow(() -> new RuntimeException("Álbum no encontrado con id: " + idAlbum));

        // --- VALIDACIÓN 1: DUPLICADOS ---
        if (trackRepository.existsByTitleAndAlbum(dto.getTitle(), album)) {
            throw new IllegalArgumentException("Error: Este álbum ya contiene la canción '" + dto.getTitle() + "'");
        }

        // --- VALIDACIÓN 2: FORMATO AUDIO ---
        String url = dto.getFileUrl().toLowerCase();
        if (!url.endsWith(".mp3") && !url.endsWith(".wav")) {
            throw new IllegalArgumentException("Error: El archivo debe ser un audio (.mp3 o .wav)");
        }

        // 2. Crear entidad
        TrackEntity entity = new TrackEntity();
        entity.setTitle(dto.getTitle());
        entity.setDuration(dto.getDuration());
        entity.setFileUrl(dto.getFileUrl());
        entity.setGenre(dto.getGenre());
        entity.setPublishedAt(OffsetDateTime.now().toString());
        entity.setAlbum(album);

        // 3. Guardar
        TrackEntity savedEntity = trackRepository.save(entity);
        return toDto(savedEntity);
    }

    // --- Método para filtrar por artista (para GET /artists/{id}/tracks) ---
    public List<Track> findByArtistId(String artistIdStr) {
        try {
            // 1. Convertimos el String de la API a Long para poder comparar
            Long artistId = Long.parseLong(artistIdStr);

            return trackRepository.findAll().stream()
                    // 2. Ahora comparamos Long con Long
                    .filter(track -> track.getAlbum().getArtist().getId().equals(artistId))
                    .map(this::toDto)
                    .collect(Collectors.toList());
                    
        } catch (NumberFormatException e) {
            // Si nos pasan un ID que no es número (ej: "pepe"), devolvemos lista vacía
            return List.of();
        }
    }

    private Track toDto(TrackEntity entity) {
        Track dto = new Track();
        dto.setId(entity.getId().toString());
        dto.setTitle(entity.getTitle());
        dto.setDuration(entity.getDuration());
        dto.setGenre(entity.getGenre());
        dto.setFileUrl(entity.getFileUrl());
        dto.setPublishedAt(entity.getPublishedAt());
        
        if (entity.getAlbum() != null) {
            dto.setAlbumId(entity.getAlbum().getId().toString());
        }
        return dto;
    }
}