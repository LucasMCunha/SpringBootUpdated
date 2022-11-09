package com.bcopstein.ctrlcorredor_v8_JPA.aplicacao.casosDeUso;

import java.util.List;

import com.bcopstein.ctrlcorredor_v8_JPA.negocio.entidades.Evento;
import com.bcopstein.ctrlcorredor_v8_JPA.negocio.servicos.ServicoEvento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsultaEventosUC {
    private ServicoEvento servicoEvento;

    @Autowired
    public ConsultaEventosUC(ServicoEvento servicoEvento) {
        this.servicoEvento = servicoEvento;
    }
    
    public List<Evento> run(){
        return servicoEvento.todos();
    }    
    
}
