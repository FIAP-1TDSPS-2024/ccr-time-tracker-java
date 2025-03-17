package main;

import model.vo.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Testes CCR TimeTracker");
        System.out.println("=====================================");
        System.out.println("Empresa, Pessoa, Admin, Funcionário e Item");

        Admin admin = new Admin("Admin", "12345678910", "01234567890", "123456");

        Funcionario funcionario1 = new Funcionario(1,"Funcionário 1", "12345678911", "teste@fiap.com.br", "123456",
                "Funcionário");

        admin.cadastrarFuncionario(funcionario1);

        Item item1 = new Item(1,"Google", "G", "https://google.com");

        funcionario1.adicionarItem(item1);
        funcionario1.acessarItem(item1);
        funcionario1.favoritarItem(item1);

        funcionario1.listarItens();

        System.out.println("=====================================");
        System.out.println("Estações, Linhas, Trens, Maquinistas e Percursos");
        Estacao estacao1 = new Estacao(1, "Estação 1", "E1", "Rua dos perdidos, 99");
        Estacao estacao2 = new Estacao(2, "Estação 2", "E2", "Rua dos perdidos, 99");
        Estacao estacao3 = new Estacao(3, "Estação 3", "E3", "Rua dos perdidos, 99");
        Estacao estacao4 = new Estacao(4, "Estação 4", "E4", "Rua dos perdidos, 99");
        Estacao estacao5 = new Estacao(5,"Estação 5", "E5", "Rua dos perdidos, 99");

        Linha linha1 = new Linha(6,"Linha 1", "L1",
                new ArrayList<Estacao>(Arrays.asList(estacao1, estacao2, estacao3, estacao4, estacao5)));

        System.out.println("Estações da linha " + linha1.getNome() + ":");
        for (Estacao estacao : linha1.getEstacoes()) {
            System.out.println(estacao.getNome());
        }

        System.out.println("Trens da linha " + linha1.getNome() + ":");
        for (Estacao estacao : linha1.getEstacoes()) {
            System.out.println(estacao.getNome());
        }

        Viagem percurso1 = new Viagem(1, estacao4, estacao5);

        percurso1.iniciarPercurso();
        System.out.println("Percurso iniciado em: " + percurso1.getDataInicio());

        Thread.sleep(1000);

        percurso1.finalizarPercurso();
        System.out.println("Percurso finalizado em: " + percurso1.getDataFim());

        percurso1.imprimirTempoDePercurso();

    }
}