package com.cibertec.autopark.repository;

import com.cibertec.autopark.model.Parqueo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParqueoRepository extends JpaRepository<Parqueo, Long> {
}
