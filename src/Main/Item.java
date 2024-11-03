package Main;

public class Item {
    private String nome;
    private String abreviacao;
    private String url;
    private boolean favorito;

    public Item(String nome, String abreviacao, String url) {
        this.nome = nome;
        this.abreviacao = abreviacao;
        this.url = url;
        this.favorito = false;
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
