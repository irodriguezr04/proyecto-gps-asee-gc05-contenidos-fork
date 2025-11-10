package org.openapitools.api;

import org.openapitools.model.Album;
import org.openapitools.model.UploadTrackRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

import javax.validation.constraints.*;
import javax.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-11-03T18:02:44.513930+01:00[Europe/Madrid]", comments = "Generator version: 7.17.0")
@Controller
@RequestMapping("${openapi.microservicioDeContenidos.base-path:}")
public class AlbumsApiController implements AlbumsApi {

    private final NativeWebRequest request;

    @Autowired
    public AlbumsApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    // public ResponseEntity<Album> getAlbumById(String idAlbum) {
    //     Album a = albums.get(idAlbum);
    //     if (a == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    //     return ResponseEntity.ok(a);
    // }

    // @Override
    // public ResponseEntity<List<Album>> listAlbums() {
    //     return ResponseEntity.ok(new ArrayList<>(albums.values()));
    // }

    @Override
    public ResponseEntity<Album> getAlbumById(String idAlbum) {
        // No hay datos, devuelve 404
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    public ResponseEntity<List<Album>> listAlbums() {
        // Devuelve lista vacía con 200 OK
        return ResponseEntity.ok(Collections.emptyList());
    }


}