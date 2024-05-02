package com.cibertec.autopark.repository;

import com.cibertec.autopark.model.RegistroParqueo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroParqueoRepository extends JpaRepository<RegistroParqueo, Integer> {
}
