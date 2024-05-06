package com.cibertec.autopark.repository;

import com.cibertec.autopark.model.Tarifario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarifarioRepository extends JpaRepository<Tarifario,Integer> {
}
