package com.cibertec.autopark.repository;

import com.cibertec.autopark.model.ParqueoDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ParqueoDetalleRepository extends JpaRepository<ParqueoDetalle, Long> {
    public List<ParqueoDetalle> getParqueoDetalleByParqueoId(Integer parqueo_id);
}
