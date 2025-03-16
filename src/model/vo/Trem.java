package model.vo;

public class Trem {
    private String nome;
    private String abreviacao;
    private boolean ativo;

    public Trem(String nome, String abreviacao, boolean ativo) {
        this.nome = nome;
        this.abreviacao = abreviacao;
        this.ativo = ativo;
    }

    public String getNome() {
        return nome;
    }

    public String getAbreviacao() {
        return abreviacao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAbreviacao(String abreviacao) {
        this.abreviacao = abreviacao;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void desativar() {
        this.ativo = false;
    }

    public void ativar() {
        this.ativo = true;
    }

}
