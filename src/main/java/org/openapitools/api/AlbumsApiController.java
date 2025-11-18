package org.openapitools.api;

import org.openapitools.model.Album;
import org.openapitools.model.UploadTrackRequest;
import org.openapitools.service.AlbumService;
import org.openapitools.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-11-03T18:02:44.513930+01:00[Europe/Madrid]", comments = "Generator version: 7.17.0")
@Controller
@RequestMapping("${openapi.microservicioDeContenidos.base-path:}")
public class AlbumsApiController implements AlbumsApi {

    private final NativeWebRequest request;
    private final AlbumService albumService;
    private final TrackService trackService;

    @Autowired
    public AlbumsApiController(NativeWebRequest request, AlbumService albumService, TrackService trackService) {
        this.request = request;
        this.albumService = albumService;
        this.trackService = trackService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    /**
     * GET /albums/{idAlbum} : Información de álbum por ID
     */
    @Override
    public ResponseEntity<Album> getAlbumById(String idAlbum) {
        // Llamamos al servicio para buscar por ID
        return albumService.findById(idAlbum)
                .map(ResponseEntity::ok) // Si se encuentra -> 200 OK
                .orElse(ResponseEntity.notFound().build()); // Si no -> 404 Not Found
    }

    /**
     * GET /albums : Listado de álbumes
     */
    @Override
    public ResponseEntity<List<Album>> listAlbums() {
        // Llamamos al servicio para buscar todos
        List<Album> albums = albumService.findAll();
        return ResponseEntity.ok(albums);
    }

    // --- POST: Subir Canción ---
    @Override
    public ResponseEntity<Void> uploadTrack(String idAlbum, UploadTrackRequest uploadTrackRequest) {
        try {
            trackService.createTrackForAlbum(idAlbum, uploadTrackRequest);
            return ResponseEntity.status(HttpStatus.CREATED).build();
            
        } catch (IllegalArgumentException e) {
            // Si fallan las validaciones (formato o duplicado) -> 400 Bad Request
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            
        } catch (RuntimeException e) {
            // Si no encuentra el álbum -> 404 Not Found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}