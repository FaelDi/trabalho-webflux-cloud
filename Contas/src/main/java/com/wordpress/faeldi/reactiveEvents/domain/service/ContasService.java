package com.wordpress.faeldi.reactiveEvents.domain.service;

import com.wordpress.faeldi.reactiveEvents.domain.repository.ContasRepository;
import com.wordpress.faeldi.reactiveEvents.domain.repository.entity.Contas;
import com.wordpress.faeldi.reactiveEvents.domain.utils.ContasConvertUtils;
import com.wordpress.faeldi.reactiveEvents.infra.events.ContasEventosHandlerImpl;
import com.wordpress.faeldi.reactiveEvents.web.dto.request.ContasRequest;
import com.wordpress.faeldi.reactiveEvents.web.dto.request.EventosRequest;
import com.wordpress.faeldi.reactiveEvents.web.dto.request.HasBalance;
import com.wordpress.faeldi.reactiveEvents.web.dto.response.ContasResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class ContasService {

    private static final Integer MAGIC_NUMBER_TWENTY_THOUSAND = 20000;
    @Autowired
    private ContasRepository contasRepository;

    @Autowired
    private ContasEventosHandlerImpl contasEventosHandler;

    public Mono<ContasResponse> criarContas(ContasRequest contasRequest){
        Contas contasEntity = ContasConvertUtils.toEntity(contasRequest);
        Mono<Contas> contasEvent = contasRepository.save(contasEntity);
        return contasEvent.map(ContasConvertUtils::toResponse);
    }

    public Flux<ContasResponse> listarTodasContas(){
        Flux<Contas> contasFlux = contasRepository.findAll();
        return contasFlux.map(ContasConvertUtils::toResponse);
    }

    public Mono<ContasResponse> depositar(Integer agencia, Integer conta, HasBalance balance){
        Mono<Contas> account = contasRepository.findByAgenciaAndConta(agencia, conta);
        account = account.map(contas -> deposito(contas,balance));
        return account.map(ContasConvertUtils::toResponse);
    }

    public Contas deposito(Contas entity, HasBalance balance){
        Double saldoAtual = entity.getSaldo()+balance.getValor();
        EventosRequest eventos = new EventosRequest();
        eventos.setCliente(entity.getCliente());
        eventos.setSaldoAnterior(entity.getSaldo());
        eventos.setSaldoAtual(saldoAtual);
        eventos.setValorRecebido(balance.getValor());
        entity.setSaldo(saldoAtual);
        if(balance.getValor()>=MAGIC_NUMBER_TWENTY_THOUSAND){
            contasEventosHandler.sendEvent(eventos);
        }
        contasRepository.save(entity).subscribe();
        return  entity;
    }

}
