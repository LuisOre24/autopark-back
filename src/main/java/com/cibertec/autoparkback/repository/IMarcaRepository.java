package com.cibertec.autoparkback.repository;

import com.cibertec.autoparkback.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMarcaRepository extends JpaRepository<Marca, Integer> {
}
