package Main;

import java.util.ArrayList;

// Estação de trem
public class Estacao {
    private String nome;
    private String abreviacao;
    private boolean implantada; // Se a estação já foi implantada ou está em construção
    private ArrayList<String> baldoacoes;

    public Estacao(String nome, String abreviacao, ArrayList<String> baldeacoes, boolean implantada) {
        this.nome = nome;
        this.abreviacao = abreviacao;
        this.implantada = implantada;
        this.baldoacoes = baldoacoes;
    }

    public String getNome() {
        return nome;
    }

    public String getAbreviacao() {
        return abreviacao;
    }

    public boolean isImplantada() {
        return implantada;
    }

    public ArrayList<String> getBaldoacoes() {
        return baldoacoes;
    }

}
