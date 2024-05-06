package com.cibertec.autopark.repository;

import com.cibertec.autopark.model.Estacionamiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstacionamientoRepository extends JpaRepository<Estacionamiento, Integer> {
}
