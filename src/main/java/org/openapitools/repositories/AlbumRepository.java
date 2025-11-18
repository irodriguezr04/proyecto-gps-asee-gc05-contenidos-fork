package org.openapitools.persistence.repositories;

import org.openapitools.persistence.entities.AlbumEntity;
import org.openapitools.persistence.entities.ArtistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<AlbumEntity, String> {
    // Busca si ya existe un álbum con ese título para ESE artista concreto
    boolean existsByTitleAndArtist(String title, ArtistEntity artist);
}