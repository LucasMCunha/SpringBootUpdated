package com.bcopstein.ctrlcorredor_v8_JPA.adaptadores.repositorios;

import java.util.List;

import com.bcopstein.ctrlcorredor_v8_JPA.negocio.entidades.Corredor;

import org.springframework.data.repository.CrudRepository;

public interface ICorredorCRUD extends CrudRepository<Corredor,String> {
    List<Corredor> findAll();
    Corredor findByCpf(String cpf);
}
