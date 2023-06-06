package br.com.fiap.drones.dto;

import br.com.fiap.drones.model.HistoricoVoo;


import java.time.LocalDateTime;

public record DadosDetalhamentoMissao(
        Long id,
        LocalDateTime dataDecolagem,
        double latitudeInicioVoo,
        double longitudeInicioVoo,
        int altitude,
        LocalDateTime dataAterrisagem,
        double latitudeFimVoo,
        double longitudeFimVoo,
        double duracaoMinutos,
        double velocidadeMedia
) {
    public DadosDetalhamentoMissao(HistoricoVoo dadosVoo) {
        this(dadosVoo.getId(), dadosVoo.getDataDecolagem(), dadosVoo.getLatitudeInicioVoo(),
                dadosVoo.getLongitudeInicioVoo(), dadosVoo.getAltitude(), dadosVoo.getDataAterrisagem(),
                dadosVoo.getLatitudeFimVoo(), dadosVoo.getLongitudeFimVoo(), dadosVoo.getDuracaoMinutos(),
                dadosVoo.getVelocidadeMedia());
    }
}
