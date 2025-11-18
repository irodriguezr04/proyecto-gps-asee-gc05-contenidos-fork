package org.openapitools.persistence.repositories;

import org.openapitools.persistence.entities.TrackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends JpaRepository<TrackEntity, String> {
    // Spring Data JPA nos da mágicamente findById(), findAll(), save(), delete(), etc.
}