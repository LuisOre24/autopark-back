package com.cibertec.autopark.repository;

import com.cibertec.autopark.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer> {

    @Query(value="SELECT * FROM tb_vehiculo WHERE placa = :placa", nativeQuery = true)
    Vehiculo buscarPlaca(@Param("placa")String placa);

}
