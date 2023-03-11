package com.wordpress.faeldi.Eventos.service;


import com.wordpress.faeldi.Eventos.repository.EventosRepository;
import com.wordpress.faeldi.Eventos.repository.entity.Eventos;
import com.wordpress.faeldi.Eventos.request.EventosRequest;
import com.wordpress.faeldi.Eventos.response.EventosResponse;
import com.wordpress.faeldi.Eventos.service.utils.EventosConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class EventosService {

    @Autowired
    private EventosRepository eventosRepository;

    public EventosResponse createEvent(EventosRequest EventosRequest){
        Eventos EventosEntity = EventosConvertUtils.toEntity(EventosRequest);
        Eventos createdEvent = eventosRepository.save(EventosEntity);
        return EventosConvertUtils.toResponse(createdEvent);
    }

    public List<EventosResponse> getAllEventos(){
        List<Eventos> eventosFlux = eventosRepository.findAll();
        return eventosFlux.stream().map(EventosConvertUtils::toResponse).toList();
    }

}
