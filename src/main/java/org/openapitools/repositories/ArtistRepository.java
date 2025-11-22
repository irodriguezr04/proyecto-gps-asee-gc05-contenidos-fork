package org.openapitools.persistence.repositories;

import org.openapitools.persistence.entities.ArtistEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<ArtistEntity, Long> {
    
    // Validación de duplicados
    boolean existsByName(String name);

    // --- MÉTODOS PARA HU6 (Filtrado y Paginación) ---

    // 1. Buscar por nombre (ignorando mayúsculas/minúsculas)
    Page<ArtistEntity> findByNameContainingIgnoreCase(String name, Pageable pageable);

    // 2. Buscar por género
    Page<ArtistEntity> findByGenreContainingIgnoreCase(String genre, Pageable pageable);

    // 3. Buscar por nombre Y género a la vez
    Page<ArtistEntity> findByNameContainingIgnoreCaseAndGenreContainingIgnoreCase(String name, String genre, Pageable pageable);
}