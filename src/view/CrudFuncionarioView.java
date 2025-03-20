package view;

import model.dao.FuncionarioDAO;

import java.util.Scanner;

public class CrudFuncionarioView {
    private Scanner scanner;

    public CrudFuncionarioView(){
        scanner = new Scanner(System.in);
    }

    public int obterIdFuncionario(){
        System.out.println("ID: ");
        return scanner.nextInt();
    }

    public String obterNomeFuncionario(){
        System.out.println("Nome: ");
        return scanner.nextLine();
    }

    public String obterCPFFuncionario(){
        System.out.println("CPF: ");
        return scanner.nextLine();
    }

    public String obterCargoFuncionario(){
        System.out.println("Cargo: ");
        return scanner.nextLine();
    }

    public String obterEmailFuncionario(){
        System.out.println("Email: ");
        return scanner.nextLine();
    }

    public String obterSenhaFuncionario(){
        System.out.println("Senha: ");
        return scanner.next();
    }

    public void exibirMensagem(String mensagem){
        System.out.println(mensagem);
    }
}
