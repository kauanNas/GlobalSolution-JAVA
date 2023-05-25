package br.com.fiap.drones.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "LicencaVoo")
@Table(name = "LicencasVoos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class LicencaVoo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    private List<Drone> drone;
    private Long numeroLicenca;
    private LocalDate dataEmissao;
    private LocalDate validade;


}
