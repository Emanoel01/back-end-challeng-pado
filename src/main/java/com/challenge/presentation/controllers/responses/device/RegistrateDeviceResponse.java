package com.challenge.presentation.controllers.responses.device;

import lombok.Data;

import java.util.UUID;

@Data
public class RegistrateDeviceResponse {

    private UUID deviceId;
    private String mac;

}
