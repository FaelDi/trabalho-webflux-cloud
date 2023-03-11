package com.wordpress.faeldi.reactiveEvents.web.functional;

import com.wordpress.faeldi.reactiveEvents.domain.service.ContasService;
import com.wordpress.faeldi.reactiveEvents.web.dto.request.ContasRequest;
import com.wordpress.faeldi.reactiveEvents.web.dto.request.Deposito;
import com.wordpress.faeldi.reactiveEvents.web.dto.request.HasBalance;
import com.wordpress.faeldi.reactiveEvents.web.dto.response.ContasResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ContasHandler {

    @Autowired
    private ContasService contasService;

    public Mono<ServerResponse> criarConta(ServerRequest serverRequest){
        final Mono<ContasRequest> salesRequestMono = serverRequest.bodyToMono(ContasRequest.class);
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(salesRequestMono.flatMap(contasService::criarContas), ContasResponse.class));
    }

    public Mono<ServerResponse> depositar(ServerRequest serverRequest){
        final Mono<HasBalance> hasBalanceMono = serverRequest.bodyToMono(Deposito.class);
        final Integer agencia = Integer.valueOf(serverRequest.queryParam("agencia").get());
        final Integer conta = Integer.valueOf(serverRequest.queryParam("conta").get());
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(hasBalanceMono.flatMap(balance -> contasService.depositar(agencia, conta, balance)), ContasResponse.class));
    }

    public Mono<ServerResponse> listarTodasContas(ServerRequest serverRequest){
        Flux<ContasResponse> salesResponseFlux = contasService.listarTodasContas();
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(salesResponseFlux, ContasResponse.class);
    }

}
