package com.wordpress.faeldi.reactiveEvents.domain.repository;

import com.wordpress.faeldi.reactiveEvents.domain.repository.entity.Contas;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ContasRepository extends ReactiveCrudRepository<Contas, Integer> {

    Mono<Contas> findByAgenciaAndConta(Integer agencia, Integer conta);
}

