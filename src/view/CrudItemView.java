package view;

import java.util.Scanner;

public class CrudItemView {
    private Scanner scanner;

    public CrudItemView(){
        scanner = new Scanner(System.in);
    }

    public int obterIdItem(){
        System.out.println("ID: ");
        return scanner.nextInt();
    }

    public String obterNomeItem(){
        System.out.println("Nome do item: ");
        return scanner.nextLine();
    }

    public String obterAbrevItem(){
        System.out.println("Abreviacao: ");
        return scanner.nextLine();
    }

    public String obterURLItem(){
        System.out.println("URL: ");
        return scanner.nextLine();
    }

    public void exibirMensagem(String mensagem){
        System.out.println(mensagem);
    }
}
