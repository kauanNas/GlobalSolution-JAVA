package br.com.fiap.drones.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
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
    private Long numeroLicenca;
    private LocalDate dataEmissao;
    private LocalDate validade;

    public LicencaVoo(Long numeroLicenca, LocalDate dataEmissao, LocalDate validade) {
        this.numeroLicenca = numeroLicenca;
        this.dataEmissao = dataEmissao;
        this.validade = validade;
    }

    @Override
    public String toString() {
        return "LicencaVoo{" +
                "numeroLicenca=" + numeroLicenca +
                ", dataEmissao=" + dataEmissao +
                ", validade=" + validade +
                '}';
    }

}
