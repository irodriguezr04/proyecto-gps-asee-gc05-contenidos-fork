package org.openapitools.persistence.repositories;

import org.openapitools.persistence.entities.SubscriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<SubscriptionEntity, String> {
    
    // Método mágico de JPA: Busca todas las suscripciones donde el ID del artista sea...
    List<SubscriptionEntity> findByArtistId(String artistId);
}