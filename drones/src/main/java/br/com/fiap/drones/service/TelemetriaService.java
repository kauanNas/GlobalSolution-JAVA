package br.com.fiap.drones.service;

import br.com.fiap.drones.dto.DadosRecebimentoTelemetria;
import br.com.fiap.drones.model.Drone;
import br.com.fiap.drones.model.Telemetria;
import br.com.fiap.drones.repository.DroneRepository;
import br.com.fiap.drones.repository.TelemetriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@Service
public class TelemetriaService {

    @Autowired
    private TelemetriaRepository telemetriaRepository;

    @Autowired
    private DroneRepository droneRepository;
    public void salvarTelemetria(DadosRecebimentoTelemetria dados, Long idDrone) {
        Drone drone = droneRepository.getReferenceById(idDrone);

        var telemetria = new Telemetria(dados.latitude(), dados.longitude(), dados.altitude(), dados.velocidade(),
                dados.direcao(), dados.tempo(), dados.dataHora());
        telemetriaRepository.save(telemetria);

        drone.getTelemetrias().add(telemetria);
    }

    public List<Telemetria> buscarTelemetria(Long idDrone){
        Drone drone = droneRepository.getReferenceById(idDrone);
        return drone.getTelemetrias();
    }

}
