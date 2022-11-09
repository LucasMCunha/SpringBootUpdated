package com.bcopstein.ctrlcorredor_v8_JPA.adaptadores.configuradores;

import com.bcopstein.ctrlcorredor_v8_JPA.aplicacao.servicos.EstatisticaDesconsidera;
import com.bcopstein.ctrlcorredor_v8_JPA.aplicacao.servicos.EstatisticaNormal;
import com.bcopstein.ctrlcorredor_v8_JPA.aplicacao.servicos.ICalculoEstatistica;
import com.bcopstein.ctrlcorredor_v8_JPA.negocio.repositorios.IEventoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguradorCalculoEstatistica {
    private IEventoRepository eventoRep;

    @Autowired
    public ConfiguradorCalculoEstatistica(IEventoRepository eventoRep) {
        this.eventoRep = eventoRep;
    }

    @Bean
    @ConditionalOnProperty(name = "calculo.estatistica", havingValue = "original", matchIfMissing = true)
    public ICalculoEstatistica opcaoRegraClassica() {
        return new EstatisticaNormal(eventoRep);
    }

    @Bean
    @ConditionalOnProperty(name = "calculo.estatistica", havingValue = "desconsidera")
    public ICalculoEstatistica opcaoDesconsidera() {
        return new EstatisticaDesconsidera(eventoRep);
    }
}
