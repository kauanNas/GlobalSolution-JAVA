package br.com.fiap.drones.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "Drone")
@Table(name = "Drones")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Drone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String modelo;
    private Long numeroSerie;
    @ManyToMany
    private List<LicencaVoo> lincecaVoo;
    @OneToMany
    private List<HistoricoVoo> historicoVoo;
    private double horasVoo;
    private String capacidadeCarga;
    private String capacidadeBateria;

    public void definirHorasVoo(){
            for(HistoricoVoo historico : historicoVoo){
                horasVoo += historico.getDuracao();
            }
    }

}
