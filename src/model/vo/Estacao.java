package model.vo;

import java.util.ArrayList;

// Estação de trem
public class Estacao {
    private int id_estacao;
    private String nome;
    private String sigla;
    private String endereco;
    private boolean implantada; // Se a estação já foi implantada ou está em construção

    public Estacao(int id_estacao, String nome, String sigla, String endereco) {
        this.id_estacao = id_estacao;
        this.nome = nome;
        this.sigla = sigla;
        this.endereco = endereco;
    }

    public int getId_estacao() {
        return id_estacao;
    }

    public String getNome() {
        return nome;
    }

    public String getSigla() {
        return sigla;
    }

    public String getEndereco() {
        return endereco;
    }

    public boolean isImplantada() {
        return implantada;
    }
}
