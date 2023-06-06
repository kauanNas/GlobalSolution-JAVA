package br.com.fiap.drones.dto;

import java.time.LocalDateTime;

public record DadosRecebimentoTelemetria(
        double latitude,
        double longitude,
        int altitude,
        double velocidade,
        int direcao,
        String tempo,
        LocalDateTime dataHora
) {
}
