package br.com.fiap.drones.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Drones")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Drone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private Long id;
    private String nome;
    private String modelo;
    private Long numeroSerie;
    @OneToMany
    @JoinColumn(name = "drone_id", nullable = true)
    private List<LicencaVoo> licencaVoo;
    @OneToMany
    @JoinColumn(name = "drone_id", nullable = true)
    private List<HistoricoVoo> historicoVoo;
    private double horasVoo;
    private String capacidadeCarga;
    private String capacidadeBateria;
    @OneToMany
    @JoinColumn(name = "drone_id", nullable = true)
    private List<Telemetria> telemetrias;

    public void definirHorasVoo(){
            for(HistoricoVoo historico : historicoVoo){
                horasVoo += historico.getDuracao();
            }
    }

    public Drone(String nome, String modelo, Long numeroSerie, List<LicencaVoo> licencaVoo, List<HistoricoVoo> historicoVoo, String capacidadeCarga, String capacidadeBateria, List<Telemetria> telemetrias) {
        this.nome = nome;
        this.modelo = modelo;
        this.numeroSerie = numeroSerie;
        this.licencaVoo = licencaVoo;
        this.historicoVoo = historicoVoo;
        this.capacidadeCarga = capacidadeCarga;
        this.capacidadeBateria = capacidadeBateria;
        this.telemetrias = telemetrias;
    }
}
