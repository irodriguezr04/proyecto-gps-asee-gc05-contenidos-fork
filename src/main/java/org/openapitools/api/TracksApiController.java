package org.openapitools.api;

import org.openapitools.model.Track;
import org.openapitools.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-11-03T18:02:44.513930+01:00[Europe/Madrid]", comments = "Generator version: 7.17.0")
@Controller
@RequestMapping("${openapi.microservicioDeContenidos.base-path:}")
public class TracksApiController implements TracksApi {

    private final NativeWebRequest request;
    private final TrackService trackService;

    @Autowired
    public TracksApiController(NativeWebRequest request, TrackService trackService) {
        this.request = request;
        this.trackService = trackService; 
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    /**
     * GET /tracks/{idTrack} : Información de canción por ID
     */
    @Override
    public ResponseEntity<Track> getTrackById(String idTrack) {
        // Llamamos al servicio para buscar por ID
        return trackService.findById(idTrack)
                .map(ResponseEntity::ok) // Si se encuentra -> 200 OK
                .orElse(ResponseEntity.notFound().build()); // Si no -> 404 Not Found
    }

    /**
     * GET /tracks : Listado de canciones
     */
    @Override
    public ResponseEntity<List<Track>> listTracks() {
        // Llamamos al servicio para buscar todos
        List<Track> tracks = trackService.findAll();
        return ResponseEntity.ok(tracks);
    }
}