package com.wordpress.faeldi.Eventos.repository.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Table;



import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Entity
public class Eventos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cliente")
    private String cliente;

    @Column(name = "saldo_atual")
    private Double saldoAtual;

    @Column(name = "saldo_anterior")
    private Double saldoAnterior;

    @Column(name = "valor_recebido")
    private Double valorRecebido;

    @Column(name = "data")
    private String data;

    public static String localDateTimeToDateWithSlash(LocalDateTime localDateTime) {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy").format(localDateTime);
    }

}
