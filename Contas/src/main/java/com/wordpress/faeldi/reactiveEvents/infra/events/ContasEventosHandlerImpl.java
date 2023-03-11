package com.wordpress.faeldi.reactiveEvents.infra.events;


import com.wordpress.faeldi.reactiveEvents.infra.Gateway.EventosGateway;
import com.wordpress.faeldi.reactiveEvents.infra.api.SendEventos;
import com.wordpress.faeldi.reactiveEvents.web.dto.request.EventosRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.scheduler.Schedulers;

@Component
public class ContasEventosHandlerImpl implements ContasEventosHandler {
    @Autowired
    private ContasEventosPublisher contasEventosPublisher;

    @Autowired
    private EventosGateway sendEventos;

    public ContasEventosHandlerImpl(ContasEventosPublisher contasEventosPublisher){
        contasEventosPublisher.getNewsFlux().subscribeOn(Schedulers.newSingle("new thred")).subscribe(
                eventos -> {
                    try {
                        sendEventos.send(eventos);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                },
                error -> System.out.println("error " + error)
        );
    }

    @Override
    public void sendEvent(EventosRequest evento) {
        contasEventosPublisher.publish(evento);
    }
}
