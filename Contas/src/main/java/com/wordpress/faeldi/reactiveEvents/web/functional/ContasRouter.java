package com.wordpress.faeldi.reactiveEvents.web.functional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class ContasRouter {

    @Bean
    public RouterFunction<ServerResponse> contasRoute(ContasHandler contasHandler) {
        return RouterFunctions.route(
                        RequestPredicates.GET("/contas"), contasHandler::listarTodasContas)
                .andRoute(RequestPredicates.POST("/contas"), contasHandler::criarConta)
                .andRoute(RequestPredicates.POST("/depositar"), contasHandler::depositar);
    }
}
