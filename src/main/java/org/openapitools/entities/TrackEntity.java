package org.openapitools.persistence.entities;

import javax.persistence.*;
import java.util.Objects;

/**
 * Esta es la ENTIDAD de base de datos para una Canción (Track).
 * Representa la tabla "tracks" en PostgreSQL.
 */
@Entity
@Table(name = "tracks")
public class TrackEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // <--- CAMBIO
    private Long id;                                    // <--- CAMBIO

    @Column(nullable = false)
    private String title;
    private String duration;
    
    @Column(name = "file_url")
    private String fileUrl;
    
    @Column(name = "published_at")
    private String publishedAt;

    // --- NUEVO CAMPO ---
    @Column(name = "genre")
    private String genre; 

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id", nullable = false)
    private AlbumEntity album;

    // --- Constructores ---
    public TrackEntity() {
    }

    // --- Getters y Setters ---
    public Long getId() { 
        return id; 
    }
    
    public void setId(Long id) { 
        this.id = id; 
    }

    public String getGenre() { 
        return genre; 
    } 

    public void setGenre(String genre) { 
        this.genre = genre; 
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public AlbumEntity getAlbum() {
        return album;
    }

    public void setAlbum(AlbumEntity album) {
        this.album = album;
    }

    // --- equals() y hashCode() ---
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrackEntity that = (TrackEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}