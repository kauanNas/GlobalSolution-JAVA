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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/drones")
//@PreAuthorize("hasAnyRole('drone-admin')")
public class DroneController {

    @Autowired

    private DroneService service;

    @PostMapping("/cadastrar")
    public ModelAndView cadastrar(@Valid DadosCadastroDrones dados, UriComponentsBuilder uriBuilder){
        var dto = service.adicionarDrone(dados);
        var uri = uriBuilder.path("/drones/{id}").buildAndExpand(dto.id()).toUri();
        ModelAndView modelAndView = new ModelAndView("redireciona");
        modelAndView.addObject("drones", dto);
        return modelAndView;
    }

    @GetMapping("/home")
    public ModelAndView paginaCadastro(){
        ModelAndView modelAndView = new ModelAndView("cadastro");
        return modelAndView;
    }

    @GetMapping("/listar")
    public ModelAndView listar(@PageableDefault(size = 10) Pageable paginacao){
        ModelAndView modelAndView = new ModelAndView("lista");
        var dto = service.buscarDrone(paginacao);
        modelAndView.addObject("drones", dto);
        return modelAndView;
    }

    @PostMapping("/atualizar/{id}")
    public ModelAndView atualizar(@PathVariable("id") long id, @ModelAttribute("dados")  @Valid DadosAtualizacaoDrone dados) {
        var dto = service.editarDrone(id, dados);
        ModelAndView modelAndView = new ModelAndView("altera");
        modelAndView.addObject("drones", dto);
        return modelAndView;
    }



    @GetMapping("/editar/{id}")
    public ModelAndView redirecionaParaEdita(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("edita");
        var drone = service.findDroneById(id);
        modelAndView.addObject(drone);
        return modelAndView;
    }

    @DeleteMapping("/excluir/{id}")
    @Transactional
    public ModelAndView excluir(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("lista");
        service.removerDrone(id);
        return modelAndView;
    }

    @PostMapping("/{id}")
    @Transactional
    public ResponseEntity cadastrarLicenca(@RequestBody @Valid DadosCadastroLicenca dados, @PathVariable Long id){
        var dto = service.adicionarLicencaDrone(dados, id);
        return ResponseEntity.ok(dto);
    }

}
