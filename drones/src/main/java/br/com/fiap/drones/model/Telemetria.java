package br.com.fiap.drones.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
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
    private double latitude;
    private double longitude;
    private int altitude;
    private double velocidade;
    private int direcao;
    private String tempo;
    private LocalDateTime dataHora;

    public Telemetria(double latitude, double longitude, int altitude, double velocidade, int direcao, String tempo, LocalDateTime dataHora) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.velocidade = velocidade;
        this.direcao = direcao;
        this.tempo = tempo;
        this.dataHora = dataHora;
    }
}
