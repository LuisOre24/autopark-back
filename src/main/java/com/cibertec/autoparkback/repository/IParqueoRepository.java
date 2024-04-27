package com.cibertec.autoparkback.repository;

import com.cibertec.autoparkback.model.Parqueo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IParqueoRepository extends JpaRepository<Parqueo, Integer> {
}
