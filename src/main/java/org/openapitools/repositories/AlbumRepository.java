package org.openapitools.persistence.repositories;

import org.openapitools.persistence.entities.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<AlbumEntity, String> {
    // Spring Data JPA nos da mágicamente findById(), findAll(), save(), delete(), etc.
}