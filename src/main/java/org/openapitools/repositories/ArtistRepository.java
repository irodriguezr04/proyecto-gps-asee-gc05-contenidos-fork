package org.openapitools.persistence.repositories;

import org.openapitools.persistence.entities.ArtistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<ArtistEntity, String> {
    // Spring Data JPA nos da mágicamente findById(), findAll(), save(), delete(), etc.
}