package com.cibertec.autoparkback.service;

import java.util.List;

public interface ICrudService <T>{

    T registrar(T entity);
    T actualizar(T entity);
    List<T> listarTodo();
    T listarUno(Integer id);
    void eliminar(Integer id);

}
