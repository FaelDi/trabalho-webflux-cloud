package com.wordpress.faeldi.reactiveEvents.infra.Gateway;

import com.wordpress.faeldi.reactiveEvents.infra.api.SendEventos;
import com.wordpress.faeldi.reactiveEvents.web.dto.request.EventosRequest;
import com.wordpress.faeldi.reactiveEvents.web.dto.response.EventosResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class EventosGateway {

    @Autowired
    private SendEventos sendEventos;
   @CircuitBreaker(name = "findEvent", fallbackMethod = "findEventFallback")
    public ResponseEntity<EventosResponse> send(EventosRequest eventosRequest) throws InterruptedException {
        return sendEventos.send(eventosRequest);
    }

    private ResponseEntity<EventosResponse> findEventFallback(EventosRequest eventosRequest, Throwable e){
       throw new ResponseStatusException(HttpStatus.NOT_FOUND, "evento não disponivel, tente mais tarde");
    }


}
