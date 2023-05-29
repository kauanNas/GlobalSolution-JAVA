package br.com.fiap.drones.service;

import br.com.fiap.drones.dto.DadosDetalhamentoMissao;
import br.com.fiap.drones.dto.DadosFimMissao;
import br.com.fiap.drones.dto.DadosInicioMissao;
import br.com.fiap.drones.model.HistoricoVoo;
import br.com.fiap.drones.repository.DroneRepository;
import br.com.fiap.drones.repository.HistoricoVooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class MissaoService {

    @Autowired
    private DroneRepository droneRepository;

    @Autowired
    private HistoricoVooRepository historicoVooRepository;

    public DadosDetalhamentoMissao iniciar(DadosInicioMissao dados, Long id) {
        var drone = droneRepository.getReferenceById(id);
        var inicioVoo = new HistoricoVoo(dados.dataDecolagem(), dados.latitudeInicioVoo(), dados.longitudeInicioVoo(),
                dados.altitude());
        historicoVooRepository.save(inicioVoo);
        List<HistoricoVoo> historicoInicioVoo = new ArrayList<>();
        historicoInicioVoo.add(inicioVoo);
        drone.setHistoricoVoo(historicoInicioVoo);
        
        return new DadosDetalhamentoMissao(inicioVoo);
    }

    public DadosDetalhamentoMissao finalizar(DadosFimMissao dados, Long id){
        var historico = historicoVooRepository.getReferenceById(id);
        historico.setDataAterrisagem(dados.dataAterrisagem());
        historico.setLatitudeFimVoo(dados.latitudeFimVoo());
        historico.setLongitudeFimVoo(dados.longitudeFimVoo());
        historico.setDuracaoMinutos(historico.calcularDuracao());
        Random random = new Random();
        DecimalFormat df = new DecimalFormat("#,##");
        historico.setVelocidadeMedia(Double.parseDouble(df.format(40.00 + (random.nextDouble() * (100.00 - 40.00)))));

        return new DadosDetalhamentoMissao(historico);
    }

}
