package com.wordpress.faeldi.reactiveEvents.web.dto.request;

public class Saque implements HasBalance{

    private Double valor;

    @Override
    public Double getValor() {
        return this.valor;
    }
}
