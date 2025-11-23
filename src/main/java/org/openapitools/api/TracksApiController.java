package org.openapitools.api;

import org.openapitools.model.Track;
import org.openapitools.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

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

    // --- GET: Track por ID ---
    @Override
    public ResponseEntity<Track> getTrackById(String idTrack) {
        return trackService.findById(idTrack)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // --- GET: Listado de Tracks (MANUAL / BLINDADO) ---
    @Override
    public ResponseEntity<List<Track>> listTracks() {
        // 1. Lectura manual (aunque no los usemos todos aún, evita el error 501)
        String pageStr = request.getParameter("page");
        String sizeStr = request.getParameter("size");
        
        // Chivato
        System.out.println("🎵 TRACKS: Petición recibida.");

        // 2. Por ahora llamamos a findAll (podrás añadir filtros luego si quieres)
        List<Track> tracks = trackService.findAll();
        return ResponseEntity.ok(tracks);
    }
}