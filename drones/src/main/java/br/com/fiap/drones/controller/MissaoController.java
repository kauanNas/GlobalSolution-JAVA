package br.com.fiap.drones.controller;

import br.com.fiap.drones.dto.DadosFimMissao;
import br.com.fiap.drones.dto.DadosInicioMissao;
import br.com.fiap.drones.service.MissaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/drones/missao")
public class MissaoController {

    @Autowired
    private MissaoService service;

    @PreAuthorize("hasRole('drone-seed')")
    @PostMapping("/inicio/{id}")
    @Transactional
    public ResponseEntity iniciarMissao(@RequestBody @Valid DadosInicioMissao dados, @PathVariable Long id){
        var dto = service.iniciar(dados, id);
        return ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasRole('drone-seed')")
    @PostMapping("/fim/{id}")
    @Transactional
    public ResponseEntity finalizarMissao(@RequestBody @Valid DadosFimMissao dados, @PathVariable Long id){
        var dto = service.finalizar(dados, id);
        return ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasRole('telemetria-reader')")
    @GetMapping("/telemetria/{idDrone}/{idHistorico}")
    public ResponseEntity buscarTelemetria(@PathVariable Long idDrone, @PathVariable Long idHistorico){
        var dto = service.gerarTelemetria(idDrone, idHistorico);
        return ResponseEntity.ok(dto);
    }

}
