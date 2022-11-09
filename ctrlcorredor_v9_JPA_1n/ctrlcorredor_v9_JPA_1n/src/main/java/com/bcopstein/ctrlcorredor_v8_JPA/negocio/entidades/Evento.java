package com.bcopstein.ctrlcorredor_v8_JPA.negocio.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;



@Entity
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    // Data do evento
    private int dia;
    private int mes;
    private int ano;
    // Distancia percorrida
    private int distancia; // metros
    // Tempo que o corredor levou para percorrer a distancia
    private int horas;
    private int minutos;
    private int segundos;

 
    public Evento(int id,String nome, int dia, int mes, int ano, int distancia, int horas, int minutos, int segundos) {
        this.id = id;
        this.nome = nome;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.distancia = distancia;
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    // requisito do JPA...
    public Evento(){}

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="cpf", nullable=false)
    private Corredor corredor;
    
    public void setCorredor(Corredor umCorredor) {
        this.corredor = umCorredor;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public int getDistancia() {
        return distancia;
    }

    public int getHoras() {
        return horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    @Override
    public String toString() {
        return "Evento [ano=" + ano + ", dia=" + dia + ", distancia=" + distancia + ", horas=" + horas + ", id=" + id
                + ", mes=" + mes + ", minutos=" + minutos + ", nome=" + nome + ", segundos=" + segundos + "]";
    }
}
