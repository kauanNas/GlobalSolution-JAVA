package br.com.fiap.drones.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "Telemetria")
@Table(name = "Telemetrias")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Telemetria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private List<Drone> drone;
    private double latitude;
    private double longitude;
    private double altitude;
    private double velocidade;
    private String direcao;
    private String tempo;
    private LocalDateTime dataHora;

}