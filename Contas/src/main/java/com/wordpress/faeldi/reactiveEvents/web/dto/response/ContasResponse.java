package com.wordpress.faeldi.reactiveEvents.web.dto.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContasResponse {
    private Integer agencia;

    private Integer conta;

    private String cliente;

    private double saldo;

}
