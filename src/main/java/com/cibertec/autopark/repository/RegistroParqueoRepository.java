package com.cibertec.autopark.repository;

import com.cibertec.autopark.model.RegistroParqueo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface RegistroParqueoRepository extends JpaRepository<RegistroParqueo, Integer> {

    @Modifying
    @Query(value = "UPDATE tb_registro_parqueo SET hora_fecha_salida = :dateTime,tiempo_parqueo = :tiempo WHERE id_registro_parqueo=:idRegistro", nativeQuery = true)
    void salidaVehiculo(@Param("idRegistro") Integer idRegistro, @Param("dateTime") LocalDateTime localDateTime, @Param("tiempo") Integer tiempo);

}
