package com.bcopstein.ctrlcorredor_v8_JPA.adaptadores.controllers;

import java.util.List;

import com.bcopstein.ctrlcorredor_v8_JPA.aplicacao.casosDeUso.CadastraCorredoresUC;
import com.bcopstein.ctrlcorredor_v8_JPA.aplicacao.casosDeUso.CadastraEventoUC;
import com.bcopstein.ctrlcorredor_v8_JPA.aplicacao.casosDeUso.ConsultaCorredoresUC;
import com.bcopstein.ctrlcorredor_v8_JPA.aplicacao.casosDeUso.ConsultaEstatisticasUC;
import com.bcopstein.ctrlcorredor_v8_JPA.aplicacao.casosDeUso.ConsultaEventosUC;
import com.bcopstein.ctrlcorredor_v8_JPA.aplicacao.casosDeUso.ConsultaPerformanceUC;
import com.bcopstein.ctrlcorredor_v8_JPA.aplicacao.dtos.EstatisticasDTO;
import com.bcopstein.ctrlcorredor_v8_JPA.aplicacao.dtos.PerformanceDTO;
import com.bcopstein.ctrlcorredor_v8_JPA.negocio.entidades.Corredor;
import com.bcopstein.ctrlcorredor_v8_JPA.negocio.entidades.Evento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ctrlCorridas")
public class CtrlCorridasController {
    private ConsultaCorredoresUC consultaCorredoresUC;
    private CadastraCorredoresUC cadastraCorredoresUC;
    private ConsultaEventosUC consultaEventosUC;
    private CadastraEventoUC cadastraEventoUC;
    private ConsultaEstatisticasUC consultaEstatisticasUC;
    private ConsultaPerformanceUC consultaPerformanceUC;

    @Autowired
    public CtrlCorridasController(ConsultaCorredoresUC consultaCorredoresUC, CadastraCorredoresUC cadastraCorredoresUC,
            ConsultaEventosUC consultaEventosUC, CadastraEventoUC cadastraEventoUC,
            ConsultaEstatisticasUC consultaEstatisticasUC, ConsultaPerformanceUC consultaPerformanceUC) {
        this.consultaCorredoresUC = consultaCorredoresUC;
        this.cadastraCorredoresUC = cadastraCorredoresUC;
        this.consultaEventosUC = consultaEventosUC;
        this.cadastraEventoUC = cadastraEventoUC;
        this.consultaEstatisticasUC = consultaEstatisticasUC;
        this.consultaPerformanceUC = consultaPerformanceUC;
    }

    @GetMapping("/corredor")
    @CrossOrigin(origins = "*")
    public List<Corredor> consultaCorredor() {
        return consultaCorredoresUC.run();
    }

    @PostMapping("/corredor")
    @CrossOrigin(origins = "*")
    public boolean cadastraCorredor(@RequestBody final Corredor corredor) {
        cadastraCorredoresUC.run(corredor);
        return true;
    }

    @GetMapping("/eventos")
    @CrossOrigin(origins = "*")
    public List<Evento> consultaEventos() {
        return consultaEventosUC.run();
    }

    @PostMapping("/eventos") // adiciona evento no ??nico corredor
    @CrossOrigin(origins = "*")
    public boolean informaEvento(@RequestParam String cpf, @RequestBody final Evento evento) {
        cadastraEventoUC.run(cpf, evento);
        return true;
    }

    @GetMapping("/estatisticas")
    @CrossOrigin(origins = "*")
    public EstatisticasDTO estatisticas(@RequestParam final Integer distancia) {
        return consultaEstatisticasUC.run(distancia);
    }

    @GetMapping("/aumentoPerformance")
    @CrossOrigin(origins = "*")
    public PerformanceDTO aumentoPerformance(@RequestParam final Integer distancia, @RequestParam final Integer ano) {
        return consultaPerformanceUC.run(distancia, ano);
    }
}
