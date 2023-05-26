package br.com.fiap.drones.service;

import br.com.fiap.drones.repository.DroneRepository;
import br.com.fiap.drones.dto.DadosAtualizacaoDrone;
import br.com.fiap.drones.dto.DadosCadastroDrones;
import br.com.fiap.drones.dto.DadosDetalhamentoDrone;
import br.com.fiap.drones.dto.DadosListagemDrone;
import br.com.fiap.drones.model.Drone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DroneService {

    @Autowired
    private DroneRepository repository;
    public DadosDetalhamentoDrone adicionarDrone(DadosCadastroDrones dados) {
        var drone = new Drone(dados.nome(), dados.modelo(), dados.numeroSerie(), dados.licencaVoo(),
                dados.historicoVoo(), dados.capacidadeCarga(), dados.capacidadeBateria(), dados.telemetrias());
        repository.save(drone);
        return new DadosDetalhamentoDrone(drone);
    }

    public Page<DadosListagemDrone> buscarDrone(Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DadosListagemDrone::new);
        return page;
    }

    public DadosDetalhamentoDrone editarDrone(DadosAtualizacaoDrone dados) {
        var drone = repository.getReferenceById(dados.id());
        Drone droneEditado = drone;

        if (dados.nome() != null) {
            droneEditado.setNome(dados.nome());
        }

        if (dados.modelo() != null) {
            droneEditado.setModelo(dados.modelo());
        }

        if (dados.numeroSerie() != null) {
            droneEditado.setNumeroSerie(dados.numeroSerie());
        }

        if (dados.licencaVoo() != null) {
            droneEditado.setLicencaVoo(dados.licencaVoo());
        }

        if (dados.historicoVoo() != null) {
            droneEditado.setHistoricoVoo(dados.historicoVoo());
        }

        if (dados.capacidadeCarga() != null) {
            droneEditado.setCapacidadeCarga(dados.capacidadeCarga());
        }

        if (dados.capacidadeBateria() != null) {
            droneEditado.setCapacidadeBateria(dados.capacidadeBateria());
        }

        if (dados.telemetrias() != null) {
            droneEditado.setTelemetrias(dados.telemetrias());
        }


        return new DadosDetalhamentoDrone(droneEditado);
    }

    public void removerDrone(Long id) {
        repository.deleteById(id);
    }

    public DadosDetalhamentoDrone especificarDrone(Long id){
        var drone = repository.getReferenceById(id);
        return new DadosDetalhamentoDrone(drone);
    }

}
