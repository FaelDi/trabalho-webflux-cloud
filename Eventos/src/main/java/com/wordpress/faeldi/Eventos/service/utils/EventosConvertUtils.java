package com.wordpress.faeldi.Eventos.service.utils;


import com.wordpress.faeldi.Eventos.repository.entity.Eventos;
import com.wordpress.faeldi.Eventos.request.EventosRequest;
import com.wordpress.faeldi.Eventos.response.EventosResponse;

import java.time.LocalDateTime;

public class EventosConvertUtils {

    public static EventosResponse toResponse(Eventos entity){
        EventosResponse response = new EventosResponse();
        response.setCliente(entity.getCliente());
        response.setData(entity.getData());
        response.setSaldoAnterior(entity.getSaldoAnterior());
        response.setSaldoAtual(entity.getSaldoAtual());
        response.setValorRecebido(entity.getValorRecebido());
        return  response;
    }
    public static Eventos toEntity(EventosRequest eventRequest){
        Eventos eventosEntity = new Eventos();
        eventosEntity.setCliente(eventRequest.getCliente());
        eventosEntity.setData(Eventos.localDateTimeToDateWithSlash(LocalDateTime.now()));
        eventosEntity.setSaldoAnterior(eventRequest.getSaldoAnterior());
        eventosEntity.setSaldoAtual(eventRequest.getSaldoAtual());
        eventosEntity.setValorRecebido(eventRequest.getValorRecebido());
        return eventosEntity;
    }

}
