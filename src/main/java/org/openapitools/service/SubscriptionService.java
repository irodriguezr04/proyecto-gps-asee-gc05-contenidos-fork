package org.openapitools.service;

import org.openapitools.model.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
public class SubscriptionService {

    @Autowired
    private RestTemplate restTemplate;

    // URL del microservicio de Usuarios (ajusta el puerto si es necesario)
    private final String USERS_SERVICE_URL = "http://localhost:8080/users"; 

    public List<Subscription> findSubscribersByArtist(String artistId) {
        // Hacemos una petición HTTP GET al otro microservicio
        // Supongamos que el endpoint allí es /users/subscriptions/artist/{id}
        String url = USERS_SERVICE_URL + "/subscriptions/artist/" + artistId;

        // NOTA: Esto fallará si el microservicio de usuarios no está levantado.
        // En un entorno real usaríamos FeignClient o WebClient con CircuitBreaker.
        try {
            Subscription[] response = restTemplate.getForObject(url, Subscription[].class);
            return Arrays.asList(response);
        } catch (Exception e) {
            // Si falla, devolvemos lista vacía o lanzamos error
            System.err.println("Error conectando con Microservicio Usuarios: " + e.getMessage());
            return List.of(); 
        }
    }
}