package com.bcopstein.ctrlcorredor_v8_JPA.adaptadores.repositorios;

import java.util.List;

import com.bcopstein.ctrlcorredor_v8_JPA.negocio.entidades.Corredor;
import com.bcopstein.ctrlcorredor_v8_JPA.negocio.entidades.Evento;
import com.bcopstein.ctrlcorredor_v8_JPA.negocio.repositorios.IEventoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class EventoRepository implements IEventoRepository {
    private IEventoCRUD eventoCRUD;
    private ICorredorCRUD corredorCRUD;

    @Autowired
    public EventoRepository(IEventoCRUD eventoCRUD, 
                            ICorredorCRUD corredorCRUD) {
        this.eventoCRUD = eventoCRUD;
        this.corredorCRUD = corredorCRUD;
    }

    public List<Evento> todos() {
        return eventoCRUD.findAll();
    }

    public boolean cadastra(String cpf, Evento evento){
        Corredor corredor = corredorCRUD.findByCpf(cpf);
        evento.setCorredor(corredor);
        eventoCRUD.save(evento);
        return true;
    }
}
