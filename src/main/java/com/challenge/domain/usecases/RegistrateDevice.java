package com.challenge.domain.usecases;

import com.challenge.domain.models.Device;

public interface RegistrateDevice {
    Device registrate(Device device) throws Exception;
}
