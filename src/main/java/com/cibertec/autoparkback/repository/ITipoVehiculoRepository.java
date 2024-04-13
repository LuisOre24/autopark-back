package com.cibertec.autoparkback.repository;

import com.cibertec.autoparkback.model.TipoVehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITipoVehiculoRepository extends JpaRepository<TipoVehiculo, Integer> {
}
