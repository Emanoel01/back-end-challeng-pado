package com.challenge.presentation.controllers.ports.device;

import com.challenge.presentation.controllers.requests.RegistrateDeviceRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public interface RegistrateDeviceHandle {

    Mono<ServerResponse> registrateDevice(RegistrateDeviceRequest request);

}
