package br.com.fiap.drones.dto;

import br.com.fiap.drones.model.Drone;
import br.com.fiap.drones.model.HistoricoVoo;
import br.com.fiap.drones.model.LicencaVoo;
import br.com.fiap.drones.model.Telemetria;

import java.util.List;

public record DadosListagemDrone(Long id,
                                 String modelo,
                                 Long numeroSerie,
                                 List<LicencaVoo> licencaVoo,
                                 List<HistoricoVoo> historicoVoo,
                                 double horasVoo,
                                 String capacidadeCarga,
                                 String capacidadeBateria,
                                 List<Telemetria> telemetrias) {

    public DadosListagemDrone(Drone drone){
        this(drone.getId(), drone.getModelo(), drone.getNumeroSerie(), drone.getLicencaVoo(), drone.getHistoricoVoo(), drone.getHorasVoo(),
                drone.getCapacidadeCarga(), drone.getCapacidadeBateria(), drone.getTelemetrias());
    }

}
