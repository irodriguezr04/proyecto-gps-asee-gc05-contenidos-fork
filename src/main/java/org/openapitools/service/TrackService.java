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

    public Optional<Track> findById(String id) {
        return trackRepository.findById(id)
                .map(this::toDto);
    }

    // --- ESTE ES EL MÉTODO QUE TE FALTABA O DABA ERROR ---
    public Track createTrackForAlbum(String idAlbum, UploadTrackRequest dto) {
        AlbumEntity album = albumRepository.findById(idAlbum)
                .orElseThrow(() -> new RuntimeException("Álbum no encontrado con id: " + idAlbum));

        TrackEntity entity = new TrackEntity();
        entity.setId("trk_" + UUID.randomUUID().toString());
        entity.setTitle(dto.getTitle());
        entity.setDuration(dto.getDuration());
        entity.setFileUrl(dto.getFileUrl());
        entity.setPublishedAt(OffsetDateTime.now().toString());
        
        entity.setAlbum(album);

        TrackEntity savedEntity = trackRepository.save(entity);

        return toDto(savedEntity);
    }

    // --- Método para filtrar por artista (para GET /artists/{id}/tracks) ---
    public List<Track> findByArtistId(String artistId) {
        return trackRepository.findAll().stream()
                .filter(track -> track.getAlbum().getArtist().getId().equals(artistId))
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private Track toDto(TrackEntity entity) {
        Track dto = new Track();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDuration(entity.getDuration());
        dto.setFileUrl(entity.getFileUrl());
        dto.setPublishedAt(entity.getPublishedAt());
        
        if (entity.getAlbum() != null) {
            dto.setAlbumId(entity.getAlbum().getId());
        }
        return dto;
    }
}