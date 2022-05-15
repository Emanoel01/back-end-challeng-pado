package com.challenge.domain.models;
import lombok.Data;

import java.util.UUID;

@Data
public class Device {

    private UUID id;
    private String name;
    private String mac;
    private String email;
    private String latitude;
    private String longitude;

}
