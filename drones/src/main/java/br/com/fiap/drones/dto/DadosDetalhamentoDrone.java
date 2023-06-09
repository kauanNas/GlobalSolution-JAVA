package br.com.fiap.drones.dto;

import br.com.fiap.drones.model.Drone;
import br.com.fiap.drones.model.HistoricoVoo;
import br.com.fiap.drones.model.LicencaVoo;
import br.com.fiap.drones.model.Telemetria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DadosDetalhamentoDrone(Long id,
                                     String nome,
                                     String modelo,
                                     Long numeroSerie,
                                     List<LicencaVoo> licencaVoo,
                                     List<HistoricoVoo> historicoVoo,
                                     double horasVoo,
                                     String capacidadeCarga,
                                     String capacidadeBateria,
                                     List<Telemetria> telemetrias) {

    public DadosDetalhamentoDrone(Drone drone){
        this(drone.getId(), drone.getNome(), drone.getModelo(), drone.getNumeroSerie(), drone.getLicencaVoo(), drone.getHistoricoVoo(), drone.getHorasVoo(),
                drone.getCapacidadeCarga(), drone.getCapacidadeBateria(), drone.getTelemetrias());
    }

}
