package com.wordpress.faeldi.reactiveEvents.infra.events;

import com.wordpress.faeldi.reactiveEvents.web.dto.request.EventosRequest;
import org.springframework.stereotype.Component;

@Component
public interface ContasEventosHandler {
    void sendEvent(EventosRequest eventos);
}

