package br.com.fiap.drones.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosInicioMissao(
        @NotNull
        LocalDateTime dataDecolagem,
        @NotNull
        double latitudeInicioVoo,
        @NotNull
        double longitudeInicioVoo,
        @NotNull
        double altitude
) {
}
