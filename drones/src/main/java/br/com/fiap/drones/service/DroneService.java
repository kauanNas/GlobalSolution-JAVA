package br.com.fiap.drones.service;

import br.com.fiap.drones.dto.DadosCadastroLicenca;
import br.com.fiap.drones.dto.*;
import br.com.fiap.drones.model.LicencaVoo;
import br.com.fiap.drones.repository.DroneRepository;
import br.com.fiap.drones.model.Drone;
import br.com.fiap.drones.repository.LicencaVooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DroneService {

    @Autowired
    private DroneRepository droneRepository;

    @Autowired
    LicencaVooRepository licencaVooRepository;


    public DadosDetalhamentoDrone adicionarDrone(DadosCadastroDrones dados) {
        var drone = new Drone(dados.nome(), dados.modelo(), dados.numeroSerie(),
                dados.capacidadeCarga(), dados.capacidadeBateria());
        droneRepository.save(drone);
        return new DadosDetalhamentoDrone(drone);
    }

    public Page<DadosListagemDrone> buscarDrone(Pageable paginacao) {
        var page = droneRepository.findAll(paginacao).map(DadosListagemDrone::new);
        return page;
    }

    public DadosDetalhamentoDrone editarDrone(Long id, DadosAtualizacaoDrone dados) {
        var drone = droneRepository.getReferenceById(id);
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

        if (dados.capacidadeCarga() != null) {
            droneEditado.setCapacidadeCarga(dados.capacidadeCarga());
        }

        if (dados.capacidadeBateria() != null) {
            droneEditado.setCapacidadeBateria(dados.capacidadeBateria());
        }

        droneRepository.save(droneEditado);
        return new DadosDetalhamentoDrone(droneEditado);
    }

    public void removerDrone(Long id) {
        droneRepository.deleteById(id);
    }


    public DadosDetalhamentoDrone adicionarLicencaDrone(DadosCadastroLicenca dados, Long id) {
        var drone = droneRepository.getReferenceById(id);
        var licenca = new LicencaVoo(dados.numeroLicenca(), dados.dataEmissao(), dados.validade());
        licencaVooRepository.save(licenca);

        drone.getLicencaVoo().add(licenca);

        return new DadosDetalhamentoDrone(drone);
    }

    public Drone findDroneById(Long id) {
        return droneRepository.getReferenceById(id);
    }
}
