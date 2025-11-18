package org.openapitools.service;

import org.openapitools.model.Subscription;
import org.openapitools.persistence.entities.SubscriptionEntity;
import org.openapitools.persistence.repositories.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    /**
     * Tarea: Consultar usuarios que siguen al artista.
     */
    public List<Subscription> findSubscribersByArtist(String artistId) {
        // 1. Buscamos en BD usando el repositorio
        List<SubscriptionEntity> entities = subscriptionRepository.findByArtistId(artistId);
        
        // 2. Convertimos a DTOs
        return entities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    // Conversor Entidad -> DTO
    private Subscription toDto(SubscriptionEntity entity) {
        Subscription dto = new Subscription();
        dto.setUserId(entity.getUserId());
        dto.setCreatedAt(entity.getCreatedAt());
        // Obtenemos el ID del artista desde la entidad relacionada
        if (entity.getArtist() != null) {
            dto.setArtistId(entity.getArtist().getId());
        }
        return dto;
    }
}