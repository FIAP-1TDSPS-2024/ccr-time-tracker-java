package model.vo;

import java.util.ArrayList;

public class Funcionario {

    private int id_funcionario;
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private String cargo;
    private ArrayList<Item> itens = new ArrayList<Item>();

    public Funcionario(int id_funcionario, String nome, String cpf, String email, String senha, String cargo) {
        this.id_funcionario = id_funcionario;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    protected void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }
}
