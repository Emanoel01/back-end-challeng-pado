package com.challenge.main.factories.controllers.device;

import com.challenge.domain.usecases.RegistrateDevice;
import com.challenge.presentation.controllers.implementations.RegistrateDeviceController;
import com.challenge.presentation.controllers.ports.device.RegistrateDeviceHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.validation.Validator;

@Component
public class DeviceControllersFactory {

    @Autowired
    private Validator validator;

    @Bean
    public RegistrateDeviceHandle registrateDeviceHandle (RegistrateDevice registrateDevice){
        return new RegistrateDeviceController(registrateDevice, this.validator);
    }

}
