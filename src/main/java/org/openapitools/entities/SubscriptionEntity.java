package org.openapitools.persistence.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "subscriptions")
public class SubscriptionEntity {

    @Id
    private String id; // ID interno de la suscripción

    @Column(name = "userid", nullable = false)
    private String userId; // ID del usuario que sigue al artista

    @Column(name = "createdat")
    private String createdAt;

    // Relación: Una suscripción pertenece a un Artista
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artistid", nullable = false)
    private ArtistEntity artist;

    // --- Constructor ---
    public SubscriptionEntity() {
        // Generamos un ID aleatorio al crear la instancia
        this.id = "sub_" + UUID.randomUUID().toString();
    }

    // --- Getters y Setters ---
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }

    public ArtistEntity getArtist() { return artist; }
    public void setArtist(ArtistEntity artist) { this.artist = artist; }
}