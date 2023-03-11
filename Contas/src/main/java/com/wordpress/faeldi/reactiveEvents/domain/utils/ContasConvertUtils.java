package com.wordpress.faeldi.reactiveEvents.domain.utils;

import com.wordpress.faeldi.reactiveEvents.domain.repository.entity.Contas;
import com.wordpress.faeldi.reactiveEvents.web.dto.request.ContasRequest;
import com.wordpress.faeldi.reactiveEvents.web.dto.request.HasBalance;
import com.wordpress.faeldi.reactiveEvents.web.dto.response.ContasResponse;

public class ContasConvertUtils {

    public static final Integer MAGIC_NUMBER_ZERO = 0;

    public static ContasResponse toResponse(Contas entity){
        ContasResponse response = new ContasResponse();
        response.setConta(entity.getConta());
        response.setAgencia(entity.getAgencia());
        response.setSaldo(entity.getSaldo());
        response.setCliente(entity.getCliente());
        return  response;
    }

    public static ContasResponse saque(Contas entity, HasBalance balance){
        ContasResponse response = new ContasResponse();
        response.setConta(entity.getConta());
        response.setAgencia(entity.getAgencia());
        response.setSaldo(entity.getSaldo()-balance.getValor());
        response.setCliente(entity.getCliente());
        return  response;
    }
    public static Contas toEntity(ContasRequest contasRequest){
        Contas contasEntity = new Contas();
        contasEntity.setConta(contasRequest.getConta());
        contasEntity.setAgencia(contasRequest.getAgencia());
        contasEntity.setCliente(contasRequest.getCliente());
        contasEntity.setSaldo(MAGIC_NUMBER_ZERO);
        return contasEntity;
    }

}
