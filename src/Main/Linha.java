package Main;

import java.util.ArrayList;

// Linha tem várias estações
public class Linha {
    private String nome;
    private String abreviacao;
    private ArrayList<Estacao> estacoes = new ArrayList<Estacao>();

    public Linha(String nome, String abreviacao, ArrayList<Estacao> estacoes) {
        this.nome = nome;
        this.abreviacao = abreviacao;
        this.estacoes = estacoes;
    }

    public String getNome() {
        return nome;
    }

    public String getAbreviacao() {
        return abreviacao;
    }

    public ArrayList<Estacao> getEstacoes() {
        return estacoes;
    }
}
