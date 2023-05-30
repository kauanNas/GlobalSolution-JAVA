package br.com.fiap.drones.repository;

import br.com.fiap.drones.model.Telemetria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelemetriaRepository extends JpaRepository<Telemetria, Long> {
}
