package com.challenge.domain.models;
import lombok.Data;

import java.util.UUID;

@Data
public class Device {

    private UUID deviceId;
    private String name;
    private String mac;
    private String email;
    private Double latitude;
    private Double longitude;

}
