package br.com.fiap.drones.dto;

import br.com.fiap.drones.model.HistoricoVoo;
import br.com.fiap.drones.model.LicencaVoo;
import br.com.fiap.drones.model.Telemetria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DadosCadastroDrones(
        @NotBlank
        String nome,
        @NotBlank
        String modelo,
        @NotNull
        Long numeroSerie,

        List<LicencaVoo> licencaVoo,

        List<HistoricoVoo> historicoVoo,
        @NotBlank
        String capacidadeCarga,
        @NotBlank
        String capacidadeBateria,

        List<Telemetria> telemetrias
) {
}
