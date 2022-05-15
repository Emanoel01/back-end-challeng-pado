package com.challenge.main.routes.device;

import com.challenge.presentation.controllers.ports.device.RegistrateDeviceHandle;
import com.challenge.presentation.controllers.requests.RegistrateDeviceRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Configuration
public class RegistrateDeviceRoutes {

    private RegistrateDeviceHandle  registrateDeviceHandle;

    public RegistrateDeviceRoutes(RegistrateDeviceHandle registrateDeviceHandle) {
        this.registrateDeviceHandle = registrateDeviceHandle;
    }

    @Bean
    public RouterFunction<ServerResponse> registrateDeviceRouter(){
        return RouterFunctions.route().POST("/registrar",request -> {

            Mono<ServerResponse> serverResponse = request.bodyToMono(RegistrateDeviceRequest.class).flatMap(dto -> this.registrateDeviceHandle.registrateDevice(dto));
            return serverResponse;
        }).build();
    }

}
