package com.bcopstein.ctrlcorredor_v8_JPA.aplicacao.casosDeUso;

import com.bcopstein.ctrlcorredor_v8_JPA.negocio.entidades.Corredor;
import com.bcopstein.ctrlcorredor_v8_JPA.negocio.servicos.ServicoCorredor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastraCorredoresUC {
    private ServicoCorredor servicoCorredor;

    @Autowired
    public CadastraCorredoresUC(ServicoCorredor servicoCorredor) {
        this.servicoCorredor = servicoCorredor;
    }
    
    public void run(Corredor corredor){
        servicoCorredor.cadastraCorredor(corredor);
    }
    
}
