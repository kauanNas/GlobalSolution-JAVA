package br.com.fiap.drones.dto;

import br.com.fiap.drones.model.LicencaVoo;

import java.time.LocalDate;

public record DadosDetalhamentoLicencaDrone(
        Long id,
        Long numeroLicenca,
        LocalDate dataEmissao,
        LocalDate validade) {

    public DadosDetalhamentoLicencaDrone(LicencaVoo licencaVoo){
        this(licencaVoo.getId(), licencaVoo.getNumeroLicenca(), licencaVoo.getDataEmissao(), licencaVoo.getValidade());
    }

}
