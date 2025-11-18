package org.openapitools.persistence.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Esta es la ENTIDAD de base de datos para un Artista.
 * Representa la tabla "artists" en PostgreSQL.
 */
@Entity
@Table(name = "artists")
public class ArtistEntity {

    @Id
    @Column(nullable = false, unique = true)
    private String id;

    // ID del microservicio de usuarios [cite: 576, 664]
    @Column(name = "user_id") 
    private String userId;

    @Column(nullable = false)
    private String name;

    private String description;
    private String genre;

    // RELACIÓN (Tarea: Relacionar): Un artista tiene muchos álbumes
    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AlbumEntity> albums = new ArrayList<>();

    // --- Constructores ---
    public ArtistEntity() {
    }

    // --- Getters y Setters ---
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<AlbumEntity> getAlbums() {
        return albums;
    }

    public void setAlbums(List<AlbumEntity> albums) {
        this.albums = albums;
    }

    // --- equals() y hashCode() ---
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArtistEntity that = (ArtistEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}