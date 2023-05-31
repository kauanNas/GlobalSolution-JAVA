package br.com.fiap.drones.dto;

import br.com.fiap.drones.model.Telemetria;

import java.time.LocalDateTime;

public record DadosDetalhamentoTelemetria(
        Long id,
        double latitude,
        double longitude,
        int altitude,
        double velocidade,
        int direcao,
        LocalDateTime dataHora
) {
    public DadosDetalhamentoTelemetria(Telemetria telemetria){
        this(telemetria.getId(), telemetria.getLatitude(), telemetria.getLongitude(), telemetria.getAltitude(),
                telemetria.getVelocidade(), telemetria.getDirecao(), telemetria.getDataHora());
    }
}
