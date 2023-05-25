package br.com.fiap.drones.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "HistoricoVoo")
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
    @OneToOne
    private Drone drone;
    private LocalDateTime dataDecolagem;
    private LocalDateTime dataAterrisagem;
    private double duracao;
    private double latitudeInicioVoo;
    private double longitudeInicioVoo;
    private double latitudeFimVoo;
    private double longitudeFimVoo;
    private double altitude;
    private double velocidadeMedia;

    public void calcularDuracao() {
        Duration diferenca = Duration.between(dataDecolagem, dataAterrisagem);
        duracao = diferenca.toMinutes();
    }

}
