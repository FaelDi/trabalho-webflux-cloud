package com.wordpress.faeldi.reactiveEvents.web.dto.request;

import lombok.Data;
import lombok.Getter;

@Data
public class EventosRequest {

    private String cliente;


    private Double saldoAtual;


    private Double saldoAnterior;


    private Double valorRecebido;;
}
