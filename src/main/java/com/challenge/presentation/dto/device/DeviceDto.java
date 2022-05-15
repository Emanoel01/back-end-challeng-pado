package com.challenge.presentation.dto.device;

import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class DeviceDto {

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String mac;

    @Email
    @NotNull
    private String email;

    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;

}
