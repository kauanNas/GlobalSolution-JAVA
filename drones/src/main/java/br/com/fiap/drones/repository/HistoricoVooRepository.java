package br.com.fiap.drones.repository;

import br.com.fiap.drones.model.HistoricoVoo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricoVooRepository extends JpaRepository<HistoricoVoo, Long> {
}
