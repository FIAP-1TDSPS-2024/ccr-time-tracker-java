package model.vo;

import java.util.ArrayList;

// Linha tem várias estações
public class Linha {
    private int id_linha;
    private String nome;
    private String sigla;
    private ArrayList<Estacao> estacoes;

    public Linha(int id_linha, String nome, String sigla, ArrayList<Estacao> estacoes) {
        this.id_linha = id_linha;
        this.nome = nome;
        this.sigla = sigla;
        this.estacoes = estacoes;
    }

    public int getId_linha() {
        return id_linha;
    }

    public String getNome() {
        return nome;
    }

    public String getSigla() {
        return sigla;
    }

    public ArrayList<Estacao> getEstacoes() {
        return estacoes;
    }
}
