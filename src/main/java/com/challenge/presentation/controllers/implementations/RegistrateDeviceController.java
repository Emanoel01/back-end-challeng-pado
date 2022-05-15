package com.challenge.presentation.controllers.implementations;

import com.challenge.domain.models.Device;
import com.challenge.domain.usecases.RegistrateDevice;
import com.challenge.main.adapters.device.DeviceAdapter;
import com.challenge.presentation.controllers.ports.device.RegistrateDeviceHandle;
import com.challenge.presentation.controllers.requests.RegistrateDeviceRequest;
import com.challenge.presentation.controllers.responses.device.RegistrateDeviceResponse;
import com.challenge.presentation.controllers.responses.error.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public class RegistrateDeviceController implements RegistrateDeviceHandle {

    private RegistrateDevice service;
    private Validator validator;

    public RegistrateDeviceController(RegistrateDevice service, Validator validator) {
        this.service = service;
        this.validator = validator;
    }

    @Override
    public Mono<ServerResponse> registrateDevice(RegistrateDeviceRequest request) {
        try{
            Set<ConstraintViolation<RegistrateDeviceRequest>> violations = this.validator.validate(request);

            if(!violations.isEmpty()) {
                ErrorResponse errorResponse = new ErrorResponse();
                String[] errors = violations
                        .stream().map(v ->  v.getPropertyPath() + " - " + v.getMessage())
                        .collect(Collectors.toList()).toArray(new String[0]);


                errorResponse.setErrors(errors);

                return ServerResponse.status(HttpStatus.BAD_REQUEST).bodyValue(errorResponse);
            }

            Device device = DeviceAdapter.adaptDeviceDtoToDevice(request);

            RegistrateDeviceResponse response = DeviceAdapter.adaptDeviceToRegistrateDeviceResponse(this.service.registrate(device));

            return ServerResponse.status(HttpStatus.CREATED).bodyValue(response);
        }catch (Exception e){
            e.printStackTrace();
            switch (e.getMessage()){
                default:
                    return  ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }
    }
}
