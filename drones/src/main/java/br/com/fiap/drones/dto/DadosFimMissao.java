package br.com.fiap.drones.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosFimMissao(
        @NotNull
        LocalDateTime dataAterrisagem,
        @NotNull
        double latitudeFimVoo,
        @NotNull
        double longitudeFimVoo
) {
}
