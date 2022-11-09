package com.bcopstein.ctrlcorredor_v8_JPA.aplicacao.casosDeUso;

import com.bcopstein.ctrlcorredor_v8_JPA.aplicacao.dtos.PerformanceDTO;
import com.bcopstein.ctrlcorredor_v8_JPA.aplicacao.servicos.ServicoEstatistica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsultaPerformanceUC {
        private ServicoEstatistica servicoEstatistica;
    
        @Autowired
        public ConsultaPerformanceUC(ServicoEstatistica servicoEstatistica) {
            this.servicoEstatistica = servicoEstatistica;
        }
    
        public PerformanceDTO run(int distancia,int ano){
            return servicoEstatistica.calculaAumentoPerformance(distancia, ano);
        }
    }
    