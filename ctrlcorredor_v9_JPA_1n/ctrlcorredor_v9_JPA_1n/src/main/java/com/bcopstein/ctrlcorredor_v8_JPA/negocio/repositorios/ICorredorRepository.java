package com.bcopstein.ctrlcorredor_v8_JPA.negocio.repositorios;

import java.util.List;

import com.bcopstein.ctrlcorredor_v8_JPA.negocio.entidades.Corredor;

public interface ICorredorRepository {
    List<Corredor> todos();
    void removeTodos();
    boolean cadastra(Corredor corredor);
}
