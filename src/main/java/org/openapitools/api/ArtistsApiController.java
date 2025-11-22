package org.openapitools.api;

import org.openapitools.model.Album;
import org.openapitools.model.Artist;
import org.openapitools.model.CreateAlbumRequest;
import org.openapitools.model.Track;
import org.openapitools.model.Subscription;
import org.openapitools.service.AlbumService;
import org.openapitools.service.ArtistService;
import org.openapitools.service.TrackService;
import org.openapitools.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("${openapi.microservicioDeContenidos.base-path:}")
public class ArtistsApiController implements ArtistsApi {

    private final NativeWebRequest request;
    private final ArtistService artistService;
    private final AlbumService albumService;
    private final TrackService trackService;
    private final SubscriptionService subscriptionService;

    @Autowired
    public ArtistsApiController(NativeWebRequest request, ArtistService artistService, AlbumService albumService, TrackService trackService, SubscriptionService subscriptionService) {
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

    @Override
    public ResponseEntity<Artist> getArtistById(String idArtist) {
        return artistService.findById(idArtist)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<List<Artist>> listArtists() {
        return ResponseEntity.ok(artistService.findAll());
    }

    @Override
    public ResponseEntity<Void> createAlbum(String idArtist, CreateAlbumRequest createAlbumRequest) {
        // Llamamos al servicio para crear y vincular
        try {
            albumService.createAlbum(idArtist, createAlbumRequest);
            return ResponseEntity.status(HttpStatus.CREATED).build(); // 201 Created
        } catch (RuntimeException e) {
            // Si el artista no existe
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Override
    public ResponseEntity<List<Album>> listArtistAlbums(String idArtist) {
        // Llamamos al servicio para buscar solo los de este artista
        List<Album> albums = albumService.findByArtistId(idArtist);
        return ResponseEntity.ok(albums);
    }

    @Override
    public ResponseEntity<List<Track>> listArtistTracks(String idArtist) {
        return ResponseEntity.ok(trackService.findByArtistId(idArtist));
    }

    @Override
    public ResponseEntity<List<Subscription>> getArtistSubscribers(String idArtist) {
        return ResponseEntity.ok(subscriptionService.findSubscribersByArtist(idArtist));
    }

    // --- GET: Listado de Artistas (CON FILTROS Y PAGINACIÓN) ---
    
    @GetMapping("/artists")
    public ResponseEntity<List<Artist>> listArtists(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size,
            @RequestParam(required = false) String name,  // Filtro por nombre
            @RequestParam(required = false) String genre  // Filtro por género
    ) {
        System.out.println("--> Buscando artistas. Name: " + name + ", Genre: " + genre); // Debug
        
        List<Artist> artists = artistService.findArtists(page, size, name, genre);
        return ResponseEntity.ok(artists);
    }
}