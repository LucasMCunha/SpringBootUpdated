package com.bcopstein.ctrlcorredor_v8_JPA.negocio.repositorios;

import java.util.List;

import com.bcopstein.ctrlcorredor_v8_JPA.negocio.entidades.Evento;

public interface IEventoRepository {
    List<Evento> todos();
    boolean cadastra(String cpf, Evento evento);
}
