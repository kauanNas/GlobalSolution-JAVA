package br.com.fiap.drones.dto;

import br.com.fiap.drones.model.HistoricoVoo;
import br.com.fiap.drones.model.LicencaVoo;
import br.com.fiap.drones.model.Telemetria;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DadosAtualizacaoDrone(
                                    @NotNull
                                    Long id,
                                    String nome,
                                    String modelo,
                                    Long numeroSerie,
                                    String capacidadeCarga,
                                    String capacidadeBateria) {
}
