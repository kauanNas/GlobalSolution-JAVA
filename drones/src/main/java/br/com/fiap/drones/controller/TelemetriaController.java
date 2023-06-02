package br.com.fiap.drones.controller;

import br.com.fiap.drones.dto.DadosRecebimentoTelemetria;
import br.com.fiap.drones.service.TelemetriaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("telemetrias")
public class TelemetriaController {

    @Autowired
    private TelemetriaService service;

    @PostMapping("/{idDrone}")
    @Transactional
    public ResponseEntity receberTelemetria(@RequestBody DadosRecebimentoTelemetria dados, @PathVariable Long idDrone){
        service.salvarTelemetria(dados, idDrone);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{idDrone}")
    public ResponseEntity devolverTelemetria(@PathVariable Long idDrone){
        var dto = service.buscarTelemetria(idDrone);
        return ResponseEntity.ok(dto);
    }

}
