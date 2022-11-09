package com.bcopstein.ctrlcorredor_v8_JPA.adaptadores.repositorios;

import java.util.List;

import com.bcopstein.ctrlcorredor_v8_JPA.negocio.entidades.Evento;

import org.springframework.data.repository.CrudRepository;

public interface IEventoCRUD extends CrudRepository<Evento,Integer> {
    List<Evento> findAll();
    Evento findById(int id);
}
