package com.bcopstein.ctrlcorredor_v8_JPA.negocio.servicos;

import java.util.List;

import com.bcopstein.ctrlcorredor_v8_JPA.negocio.entidades.Corredor;
import com.bcopstein.ctrlcorredor_v8_JPA.negocio.repositorios.ICorredorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicoCorredor {
    public ICorredorRepository corredorRep;

    @Autowired
    public ServicoCorredor(ICorredorRepository corredorRep){
        this.corredorRep = corredorRep;
    }

    public List<Corredor> todos(){
        return corredorRep.todos();
    }

    public void cadastraCorredor(Corredor corredor){
        //corredorRep.removeTodos();
        corredorRep.cadastra(corredor);
    }
    
}
