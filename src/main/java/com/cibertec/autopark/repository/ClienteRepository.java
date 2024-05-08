package com.cibertec.autopark.repository;

import com.cibertec.autopark.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query(value="SELECT * FROM tb_cliente where dni=:dni", nativeQuery = true)
    Cliente buscarClienteDocumento(@Param("dni") String nroDocumento);

}
