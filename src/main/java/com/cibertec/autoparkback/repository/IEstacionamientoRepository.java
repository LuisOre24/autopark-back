package com.cibertec.autoparkback.repository;

import com.cibertec.autoparkback.model.Estacionamiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEstacionamientoRepository extends JpaRepository<Estacionamiento, Integer> {
}
