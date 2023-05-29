package br.com.fiap.drones.dto;

import br.com.fiap.drones.model.LicencaVoo;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosDetalhamentoLicenca(
        Long id,
        Long numeroLicenca,
        LocalDate dataEmissao,
        LocalDate validade
) {

    public DadosDetalhamentoLicenca(LicencaVoo licencaVoo){
        this(licencaVoo.getId(), licencaVoo.getNumeroLicenca(), licencaVoo.getDataEmissao(), licencaVoo.getValidade());
    }

}
