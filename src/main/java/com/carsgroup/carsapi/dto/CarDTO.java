package com.carsgroup.carsapi.dto;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

public record CarDTO(
    @NotBlank String modelo,

    @NotBlank String fabricante,

    @Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$") @NotNull String dataFabricacao,

    @NotNull double valor,

    @NotNull int anoModelo) {

}