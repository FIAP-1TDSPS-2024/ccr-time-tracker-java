package Main;

import java.util.ArrayList;

public class Funcionario extends Pessoa {

    private String senha;
    private String cargo;
    private ArrayList<Item> itens = new ArrayList<Item>();

    public Funcionario(String nome, String cpf, String email, String senha, String cargo) {
        super(nome, cpf, email);
        this.senha = senha;
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    protected void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void login(String senha) {
        if (this.senha.equals(senha)) {
            System.out.println("Login efetuado com sucesso!");
        } else {
            System.out.println("Senha incorreta!");
        }
    }

    public void adicionarItem(Item item) {
        for (Item i : itens) {
            if (i.equals(item)) {
                System.out.println("Item já adicionado!");
                return;
            }
        }
        itens.add(item);
    }

    public void removerItem(Item item) {
        for (Item i : itens) {
            if (i.equals(item)) {
                System.out.println("Removendo item " + item.getNome());
                itens.remove(item);
            }
        }

    }

    public void acessarItem(Item item) {
        for (Item i : itens) {
            if (i.equals(item)) {
                System.out.println("Acessando item " + item.getUrl());
                item.acessar();
            }
        }
    }

    public void listarItens() {
        for (Item item : itens) {
            System.out.println(item.getNome());
        }
    }

    public void favoritarItem(Item item) {
        item.setFavorito(true);
    }

    public void desfavoritarItem(Item item) {
        item.setFavorito(false);
    }
}
