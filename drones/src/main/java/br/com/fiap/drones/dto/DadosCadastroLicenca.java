package br.com.fiap.drones.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosCadastroLicenca(@NotNull
                                   Long numeroLicenca,
                                   @NotNull
                                   LocalDate dataEmissao,
                                   @NotNull
                                   LocalDate validade) {
}
