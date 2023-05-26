package br.com.fiap.drones.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Duration;
import java.time.LocalDate;
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
    @NotNull
    private LocalDateTime dataDecolagem;
    @NotNull
    private LocalDateTime dataAterrisagem;
    @NotNull
    private double duracao;
    @NotNull
    private double latitudeInicioVoo;
    @NotNull
    private double longitudeInicioVoo;
    @NotNull
    private double latitudeFimVoo;
    @NotNull
    private double longitudeFimVoo;
    @NotNull
    private double altitude;
    @NotNull
    private double velocidadeMedia;

    public void calcularDuracao() {
        Duration diferenca = Duration.between(dataDecolagem, dataAterrisagem);
        duracao = diferenca.toMinutes();
    }

}
