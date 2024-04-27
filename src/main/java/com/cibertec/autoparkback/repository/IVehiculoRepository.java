package com.cibertec.autoparkback.repository;

import com.cibertec.autoparkback.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVehiculoRepository extends JpaRepository<Vehiculo, Integer> {
}
