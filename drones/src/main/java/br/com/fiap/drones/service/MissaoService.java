package br.com.fiap.drones.service;

import br.com.fiap.drones.dto.DadosDetalhamentoMissao;
import br.com.fiap.drones.dto.DadosDetalhamentoTelemetria;
import br.com.fiap.drones.dto.DadosFimMissao;
import br.com.fiap.drones.dto.DadosInicioMissao;
import br.com.fiap.drones.model.HistoricoVoo;
import br.com.fiap.drones.model.Telemetria;
import br.com.fiap.drones.repository.DroneRepository;
import br.com.fiap.drones.repository.HistoricoVooRepository;
import br.com.fiap.drones.repository.TelemetriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class MissaoService {

    @Autowired
    private DroneRepository droneRepository;

    @Autowired
    private HistoricoVooRepository historicoVooRepository;

    @Autowired
    private TelemetriaRepository telemetriaRepository;

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

    public DadosDetalhamentoTelemetria gerarTelemetria(Long idDrone, Long idHistorico) {
        var drone = droneRepository.getReferenceById(idDrone);
        var telemetria = new Telemetria();
        Random random = new Random();
        DecimalFormat df = new DecimalFormat("###,###");
        DecimalFormat decimalFormat = new DecimalFormat("#,##");
        telemetria.setLatitude(Double.parseDouble(df.format(-300.277 + (300.277 - (-300.277)) * random.nextDouble())));
        telemetria.setLongitude((-300.277 + (300.277 - (-300.277)) * random.nextDouble()));
        telemetria.setAltitude(random.nextInt(100-0+1) + 0);
        telemetria.setVelocidade(Double.parseDouble(decimalFormat.format((Math.random() * (140 - 0) + 0)/3.6)));
        telemetria.setDirecao(random.nextInt(340-70+1) + 70);
        telemetria.setDataHora(gerarDataHoraAleatoria(idHistorico));
        telemetriaRepository.save(telemetria);
        List<Telemetria> listaTelemetrias = new ArrayList<>();
        listaTelemetrias.add(telemetria);
        drone.setTelemetrias(listaTelemetrias);

        return new DadosDetalhamentoTelemetria(telemetria);
    }

    public LocalDateTime gerarDataHoraAleatoria(Long id) {
        var historico = historicoVooRepository.getReferenceById(id);
        LocalDateTime dataInicial = historico.getDataDecolagem();
        Random random = new Random();
        long minutos = ChronoUnit.MINUTES.between(dataInicial, LocalDateTime.now());
        long minutosAleatorios = random.nextLong() % minutos;
        if (minutosAleatorios < 0) {
            minutosAleatorios += minutos;
        }
        return dataInicial.plusMinutes(minutosAleatorios);
    }

}
