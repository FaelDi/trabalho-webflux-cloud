package com.wordpress.faeldi.reactiveEvents.web.dto.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventosResponse {

    private String cliente;


    private Double saldoAtual;


    private Double saldoAnterior;


    private Double valorRecebido;


    private String data;
}
