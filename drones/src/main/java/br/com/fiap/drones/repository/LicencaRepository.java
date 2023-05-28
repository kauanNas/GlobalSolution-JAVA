package br.com.fiap.drones.repository;

import br.com.fiap.drones.model.LicencaVoo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LicencaRepository extends JpaRepository<LicencaVoo, Long> {
}
