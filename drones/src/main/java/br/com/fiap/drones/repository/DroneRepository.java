package br.com.fiap.drones.repository;

import br.com.fiap.drones.model.Drone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DroneRepository extends JpaRepository<Drone, Long> {
}
