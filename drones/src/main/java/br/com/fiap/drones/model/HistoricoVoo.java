package br.com.fiap.drones.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@Table(name = "HistoricosVoos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class HistoricoVoo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataDecolagem;

    private LocalDateTime dataAterrisagem;

    private double duracaoMinutos;

    private double latitudeInicioVoo;

    private double longitudeInicioVoo;

    private double latitudeFimVoo;

    private double longitudeFimVoo;

    private double altitude;

    private double velocidadeMedia;

    public double calcularDuracao() {
        Duration diferenca = Duration.between(dataDecolagem, dataAterrisagem);
        duracaoMinutos = diferenca.toMinutes();
        return duracaoMinutos;
    }

    public HistoricoVoo(LocalDateTime dataDecolagem, double latitudeInicioVoo, double longitudeInicioVoo, double altitude) {
        this.dataDecolagem = dataDecolagem;
        this.latitudeInicioVoo = latitudeInicioVoo;
        this.longitudeInicioVoo = longitudeInicioVoo;
        this.altitude = altitude;
    }

}
