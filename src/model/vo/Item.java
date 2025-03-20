package model.vo;

public class Item {
    private int id_item;
    private String nome;
    private String abreviacao;
    private String url;
    private boolean favorito;

    public Item(int id_item, String nome, String abreviacao, String url) {
        this.id_item = id_item;
        this.nome = nome;
        this.abreviacao = abreviacao;
        this.url = url;
        this.favorito = false;
    }

    public int getId_item() {
        return id_item;
    }

    public String getNome() {
        return nome;
    }

    public String getAbreviacao() {
        return abreviacao;
    }

    public String getUrl() {
        return url;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public void acessar() {
        System.out.println("Acessando " + nome + "...");
    }

}
