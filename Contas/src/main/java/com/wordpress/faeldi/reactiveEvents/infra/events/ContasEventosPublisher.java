package com.wordpress.faeldi.reactiveEvents.infra.events;

import com.wordpress.faeldi.reactiveEvents.web.dto.request.EventosRequest;
import com.wordpress.faeldi.reactiveEvents.web.dto.response.ContasResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Component
public class ContasEventosPublisher {
    private Sinks.Many<EventosRequest> contasSinks;

    public ContasEventosPublisher(){
        this.contasSinks = Sinks.many().multicast().onBackpressureBuffer();
    }
    public void publish(EventosRequest evento){
        this.contasSinks.tryEmitNext(evento);
    }
    public Flux<EventosRequest> getNewsFlux() {
        return this.contasSinks.asFlux();
    }
}
