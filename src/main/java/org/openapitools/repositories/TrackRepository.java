package org.openapitools.persistence.repositories;

import org.openapitools.persistence.entities.TrackEntity;
import org.openapitools.persistence.entities.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends JpaRepository<TrackEntity, Long> {
    // Busca si ya existe una canción con ese título en ESE álbum
    boolean existsByTitleAndAlbum(String title, AlbumEntity album);
}