package br.com.fiap.drones.service;

import br.com.fiap.drones.dto.DadosCadastroLicenca;
import br.com.fiap.drones.dto.*;
import br.com.fiap.drones.model.LicencaVoo;
import br.com.fiap.drones.repository.DroneRepository;
import br.com.fiap.drones.model.Drone;
import br.com.fiap.drones.repository.LicencaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DroneService {

    @Autowired
    private DroneRepository droneRepository;

    @Autowired
    private LicencaRepository licencaRepository;

    public DadosDetalhamentoDrone adicionarDrone(DadosCadastroDrones dados) {
        var drone = new Drone(dados.nome(), dados.modelo(), dados.numeroSerie(), dados.licencaVoo(),
                dados.historicoVoo(), dados.capacidadeCarga(), dados.capacidadeBateria(), dados.telemetrias());
        droneRepository.save(drone);
        return new DadosDetalhamentoDrone(drone);
    }

    public Page<DadosCadastroListagemDrone> buscarDrone(Pageable paginacao) {
        var page = droneRepository.findAll(paginacao).map(DadosCadastroListagemDrone::new);
        return page;
    }

    public DadosDetalhamentoDrone editarDrone(DadosAtualizacaoDrone dados) {
        var drone = droneRepository.getReferenceById(dados.id());
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
        droneRepository.deleteById(id);
    }

    public DadosDetalhamentoDrone especificarDrone(Long id){
        var drone = droneRepository.getReferenceById(id);
        return new DadosDetalhamentoDrone(drone);
    }

    public DadosDetalhamentoLicencaDrone adicionarLicencaDrone(DadosCadastroLicenca dados) {
        var licenca = new LicencaVoo(dados.numeroLicenca(), dados.dataEmissao(), dados.validade());
        licencaRepository.save(licenca);
        return new DadosDetalhamentoLicencaDrone(licenca);
    }
}
