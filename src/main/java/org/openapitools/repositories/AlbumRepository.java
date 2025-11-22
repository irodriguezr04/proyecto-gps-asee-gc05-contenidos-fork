package org.openapitools.persistence.repositories;

import org.openapitools.persistence.entities.AlbumEntity;
import org.openapitools.persistence.entities.ArtistEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<AlbumEntity, Long> { // <--- OJO: Long
    
    // Validación de duplicados
    boolean existsByTitleAndArtist(String title, ArtistEntity artist);

    // --- MÉTODOS DE FILTRADO QUE TE FALTAN ---
    
    // 1. Solo Título
    Page<AlbumEntity> findByTitleContainingIgnoreCase(String title, Pageable pageable);

    // 2. Solo Género (Este es el que te daba error)
    Page<AlbumEntity> findByArtist_GenreContainingIgnoreCase(String genre, Pageable pageable);

    // 3. Título Y Género (Este también te daba error)
    Page<AlbumEntity> findByTitleContainingIgnoreCaseAndArtist_GenreContainingIgnoreCase(String title, String genre, Pageable pageable);
}