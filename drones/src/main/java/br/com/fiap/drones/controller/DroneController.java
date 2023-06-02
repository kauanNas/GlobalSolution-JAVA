package br.com.fiap.drones.controller;

import br.com.fiap.drones.dto.DadosAtualizacaoDrone;
import br.com.fiap.drones.dto.DadosCadastroDrones;
import br.com.fiap.drones.dto.DadosCadastroLicenca;
import br.com.fiap.drones.service.DroneService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/drones")
//@PreAuthorize("hasAnyRole('drone-admin')")
public class DroneController {

    @Autowired

    private DroneService service;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroDrones dados, UriComponentsBuilder uriBuilder){
        var dto = service.adicionarDrone(dados);
        var uri = uriBuilder.path("/drones/{id}").buildAndExpand(dto.id()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity listar(@PageableDefault(size = 10) Pageable paginacao){
        var dto = service.buscarDrone(paginacao);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoDrone dados){
        var dto = service.editarDrone(dados);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        service.removerDrone(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var dto = service.especificarDrone(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/{id}")
    @Transactional
    public ResponseEntity cadastrarLicenca(@RequestBody @Valid DadosCadastroLicenca dados, @PathVariable Long id){
        var dto = service.adicionarLicencaDrone(dados, id);
        return ResponseEntity.ok(dto);
    }

}
