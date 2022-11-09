package com.bcopstein.ctrlcorredor_v8_JPA.negocio.entidades;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Corredor {
    @Id
    private String cpf;
    private String nome;
    private int diaDn,mesDn,anoDn;
    private String genero;

    public Corredor(String cpf, String nome, int diaDn,int mesDn,int anoDn, String genero) {
        this.cpf = cpf;
        this.nome = nome;
        this.diaDn = diaDn;
        this.mesDn = mesDn;
        this.anoDn = anoDn;
        this.genero = genero;
        this.eventos = new ArrayList<>();
    }

     // requisito do JPA...
     public Corredor(){}

    @OneToMany(fetch = FetchType.EAGER,
                mappedBy = "corredor", 
                cascade = CascadeType.ALL)
    private List<Evento> eventos;

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public int getDiaDn() {
        return diaDn;
    }

    public int getMesDn() {
        return mesDn;
    }
    public int getAnoDn() {
        return anoDn;
    }

    public String getGenero() {
        return genero;
    }

}