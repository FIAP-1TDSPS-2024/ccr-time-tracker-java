package view;

import java.util.Scanner;

public class CrudViagemView {
    private Scanner scanner;

    public CrudViagemView(){
        scanner = new Scanner(System.in);
    }

    public int obterIdViagem(){
        System.out.println("ID: ");
        return scanner.nextInt();
    }

    public int obterNumeroEstacaoPartida(){
        System.out.println("Digite o nome da estacao de partida: \n" +
                           "1, Grajaú \n" +
                           "2, Primavera-Interlagos \n" +
                           "3, Autódromo \n" +
                           "4, Jurubatuba \n" +
                           "5, Santo Amaro \n" +
                           "6, Morumbi \n" +
                           "7, Berrini \n" +
                           "8, Vila Olímpia \n" +
                           "9, Cidade Jardim \n" +
                           "10, Hebraica-Rebouças \n" +
                           "11, Pinheiros \n" +
                           "12, Villa-Lobos-Jaguaré \n" +
                           "13, Ceasa \n" +
                           "14, Presidente Altino \n" +
                           "14, Osasco");
        return scanner.nextInt();
    }

    public int obterNumeroEstacaoDestino(){
        System.out.println("Digite o nome da estacao de destino: \n" +
                "1, Grajaú \n" +
                "2, Primavera-Interlagos \n" +
                "3, Autódromo \n" +
                "4, Jurubatuba \n" +
                "5, Santo Amaro \n" +
                "6, Morumbi \n" +
                "7, Berrini \n" +
                "8, Vila Olímpia \n" +
                "9, Cidade Jardim \n" +
                "10, Hebraica-Rebouças \n" +
                "11, Pinheiros \n" +
                "12, Villa-Lobos-Jaguaré \n" +
                "13, Ceasa \n" +
                "14, Presidente Altino \n" +
                "14, Osasco");
        return scanner.nextInt();
    }


    public void exibirMensagem(String mensagem){
        System.out.println(mensagem);
    }
}
