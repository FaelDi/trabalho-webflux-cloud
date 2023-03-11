package com.wordpress.faeldi.reactiveEvents.domain.repository.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("contas")
public class Contas {

    @Id
    @Column("id")
    private Integer id;

    @Column("agencia")
    private Integer agencia;

    @Column("conta")
    private Integer conta;

    @Column("cliente")
    private String cliente;

    @Column("saldo")
    private double saldo;

}
