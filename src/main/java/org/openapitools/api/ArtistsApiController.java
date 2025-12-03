package org.openapitools.api;

import org.openapitools.model.Artist;
import org.openapitools.model.Album;
import org.openapitools.model.CreateAlbumRequest;
import org.openapitools.model.Subscription;
import org.openapitools.model.Track;
import org.openapitools.service.ArtistService;
import org.openapitools.service.AlbumService;
import org.openapitools.service.SubscriptionService;
import org.openapitools.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("${openapi.microservicioDeContenidos.base-path:}")
public class ArtistsApiController implements ArtistsApi {

    private static final Logger logger = LoggerFactory.getLogger(ArtistsApiController.class);
    private final NativeWebRequest request;
    private final ArtistService artistService;
    private final AlbumService albumService;
    private final TrackService trackService;
    private final SubscriptionService subscriptionService;

    @Autowired
    public ArtistsApiController(
            NativeWebRequest request,
            ArtistService artistService,
            AlbumService albumService,
            TrackService trackService,
            SubscriptionService subscriptionService
    ) {
        this.request = request;
        this.artistService = artistService;
        this.albumService = albumService;
        this.trackService = trackService;
        this.subscriptionService = subscriptionService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    // --- GET: Información de artista por ID ---
    @Override
    public ResponseEntity<Artist> getArtistById(String idArtist) {
        return artistService.findById(idArtist)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // --- GET: Listado de artistas (MANUAL / BLINDADO) ---
    @Override
    public ResponseEntity<List<Artist>> listArtists() {
        // 1. Lectura manual de parámetros para evitar conflictos de firma
        String pageStr = request.getParameter("page");
        String sizeStr = request.getParameter("size");
        String name = request.getParameter("name");
        String genre = request.getParameter("genre");

        // 2. Conversión segura
        Integer page = (pageStr != null) ? Integer.parseInt(pageStr) : 0;
        Integer size = (sizeStr != null) ? Integer.parseInt(sizeStr) : 10;

        // 3. Chivato
        logger.info("🎤 ARTISTAS: Petición recibida. Name='{}', Genre='{}'", name, genre);

        // 4. Llamada al servicio
        List<Artist> artists = artistService.findArtists(page, size, name, genre);
        return ResponseEntity.ok(artists);
    }

    // --- POST: Crear Álbum ---
    @Override
    public ResponseEntity<Void> createAlbum(String idArtist, CreateAlbumRequest createAlbumRequest) {
        try {
            albumService.createAlbum(idArtist, createAlbumRequest);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // --- GET: Listar Álbumes de un Artista ---
    @Override
    public ResponseEntity<List<Album>> listArtistAlbums(String idArtist) {
        return ResponseEntity.ok(albumService.findByArtistId(idArtist));
    }

    // --- GET: Listar Canciones de un Artista ---
    @Override
    public ResponseEntity<List<Track>> listArtistTracks(String idArtist) {
        return ResponseEntity.ok(trackService.findByArtistId(idArtist));
    }

    // --- GET: Suscriptores ---
    @Override
    public ResponseEntity<List<Subscription>> getArtistSubscribers(String idArtist) {
        return ResponseEntity.ok(subscriptionService.findSubscribersByArtist(idArtist));
    }
}