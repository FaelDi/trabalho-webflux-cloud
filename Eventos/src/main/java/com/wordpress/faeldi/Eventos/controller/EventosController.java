package com.wordpress.faeldi.Eventos.controller;


import com.wordpress.faeldi.Eventos.request.EventosRequest;
import com.wordpress.faeldi.Eventos.response.EventosResponse;
import com.wordpress.faeldi.Eventos.service.EventosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventosController {
    @Autowired
    EventosService eventsService;

    @PostMapping
    public ResponseEntity<EventosResponse> createEvent(@RequestBody EventosRequest eventRequest) {
        EventosResponse createdEvent = eventsService.createEvent(eventRequest);
        return ResponseEntity.ok().body(createdEvent);
    }

    @GetMapping
    public List<EventosResponse> getAllEvents() {
        List<EventosResponse> events = eventsService.getAllEventos();
        return events;
    }

}
