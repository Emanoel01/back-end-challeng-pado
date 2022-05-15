package com.challenge.main.factories.services.device;

import com.challenge.domain.usecases.RegistrateDevice;
import com.challenge.infra.db.ports.CreateDeviceRepository;
import com.challenge.services.devices.RegistrateDeviceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeviceFactory {

    @Bean
    public RegistrateDevice registrateDevice(CreateDeviceRepository createDeviceRepository){
        return new RegistrateDeviceService(createDeviceRepository);
    }

}
