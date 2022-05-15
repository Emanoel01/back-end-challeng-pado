package com.challenge.presentation.dto.device;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;

import javax.validation.Validator;
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
    @NotBlank
    private String latitude;

    @NotNull
    @NotBlank
    private String longitude;

}
