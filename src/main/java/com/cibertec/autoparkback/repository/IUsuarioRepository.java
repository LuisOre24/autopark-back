package com.cibertec.autoparkback.repository;

import com.cibertec.autoparkback.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
}
