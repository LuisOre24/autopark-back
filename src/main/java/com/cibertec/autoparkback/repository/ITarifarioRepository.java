package com.cibertec.autoparkback.repository;

import com.cibertec.autoparkback.model.Tarifario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITarifarioRepository extends JpaRepository<Tarifario,Integer> {
}
