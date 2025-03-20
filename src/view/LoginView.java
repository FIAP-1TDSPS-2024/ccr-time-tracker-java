package view;

import java.util.Scanner;

public class LoginView {
    private Scanner scanner;

    public LoginView(){
        scanner = new Scanner(System.in);
    }

    public String obterNomeUsuario(){
        System.out.println("Usuário: ");
        return scanner.nextLine();
    }

    public String obterSenhaUsuario(){
        System.out.println("Senha: ");
        return scanner.next();
    }

    public void exibirMensagem(String mensagem){
        System.out.println(mensagem);
    }
}
