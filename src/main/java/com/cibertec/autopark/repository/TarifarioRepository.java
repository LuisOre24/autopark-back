package com.cibertec.autopark.repository;

import com.cibertec.autopark.model.Tarifario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TarifarioRepository extends JpaRepository<Tarifario,Integer> {

    @Query(value = "select * from tb_tarifario where id_tipo_vehiculo = :id", nativeQuery = true)
    Tarifario tarifaPorTVehiculo(@Param("id") Integer idTipo);

}
