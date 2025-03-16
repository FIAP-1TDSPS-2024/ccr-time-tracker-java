package model.vo;

import java.util.ArrayList;

public class Empresa {
    private String nome;
    private String cnpj;
    private ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

    public Empresa(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void cadastrarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void removerFuncionario(Funcionario funcionario) {
        funcionarios.remove(funcionario);
    }

    public void promoteFuncionario(Funcionario funcionario, String cargo) {
        funcionario.setCargo(cargo);
    }

    public Funcionario contratarPessoa(Pessoa pessoa, String senha) {
        Funcionario funcionario = new Funcionario(pessoa.getNome(), pessoa.getCpf(), pessoa.getEmail(), senha,
                "Funcionário");
        cadastrarFuncionario(funcionario);

        return funcionario;
    }
}
