package com.wordpress.faeldi.reactiveEvents.web.dto.request;

public class Deposito implements HasBalance {

    private Double valor;

    @Override
    public Double getValor() {
        return this.valor;
    }
}
