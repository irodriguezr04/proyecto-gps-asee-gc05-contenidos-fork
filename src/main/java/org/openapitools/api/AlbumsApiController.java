package org.openapitools.api;

import org.openapitools.model.Album;
import org.openapitools.model.UploadTrackRequest;
import org.openapitools.service.AlbumService;
import org.openapitools.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.bind.annotation.RequestParam;

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

    @Override
    public ResponseEntity<List<Album>> listAlbums() {
        // 1. Leemos los parámetros manualmente del objeto 'request'
        // Esto evita conflictos con la interfaz generada
        String pageStr = request.getParameter("page");
        String sizeStr = request.getParameter("size");
        String title = request.getParameter("title");
        String genre = request.getParameter("genre");

        // 2. Convertimos a números (con valores por defecto)
        Integer page = (pageStr != null) ? Integer.parseInt(pageStr) : 0;
        Integer size = (sizeStr != null) ? Integer.parseInt(sizeStr) : 10;

        // --- CHIVATO ---
        System.out.println("🔥 PETICIÓN RECIBIDA (Método Manual):");
        System.out.println("   👉 Title: " + title);
        System.out.println("   👉 Genre: " + genre);

        // 3. Llamamos al servicio
        List<Album> albums = albumService.findAlbums(page, size, title, genre);
        
        return ResponseEntity.ok(albums);
    }
}