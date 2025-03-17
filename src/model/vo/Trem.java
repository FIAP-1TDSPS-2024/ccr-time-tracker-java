package model.vo;

public class Trem {
    private int id_trem;
    private boolean ativo;
    private int numeracao;

    public Trem(int id_trem, String nome, String abreviacao, boolean ativo, int numeracao) {
        this.id_trem = id_trem;
        this.ativo = ativo;
        this.numeracao = numeracao;
    }

    public int getId_trem() {
        return id_trem;
    }

    public int getNumeracao() {
        return numeracao;
    }

    public boolean isAtivo() {
        return ativo;
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
