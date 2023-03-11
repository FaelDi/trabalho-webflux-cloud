package com.wordpress.faeldi.reactiveEvents.infra.api;


import com.wordpress.faeldi.reactiveEvents.web.dto.request.EventosRequest;
import com.wordpress.faeldi.reactiveEvents.web.dto.response.EventosResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SendEventos {

    private RestTemplate restTemplate = new RestTemplate();
    public ResponseEntity<EventosResponse> send(EventosRequest eventos) throws InterruptedException {
        ResponseEntity<EventosResponse> eventosResponse = restTemplate.postForEntity("http://localhost:8089/eventos",eventos, EventosResponse.class);
        System.out.println("Evento enviado");
        return eventosResponse;
    }
}
