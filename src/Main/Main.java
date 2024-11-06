package Main;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Testes CCR TimeTracker");
        System.out.println("=====================================");
        System.out.println("Empresa, Pessoa, Admin, Funcionário e Item");
        Empresa empresa = new Empresa("FIAP", "12345678910");

        Admin admin = new Admin("Admin", "12345678910", "01234567890", "123456", empresa);

        Funcionario funcionario1 = new Funcionario("Funcionário 1", "12345678911", "teste@fiap.com.br", "123456",
                "Funcionário");

        admin.cadastrarFuncionario(funcionario1);
        empresa.promoteFuncionario(funcionario1, "Gerente");

        Item item1 = new Item("Google", "G", "https://google.com");

        funcionario1.adicionarItem(item1);
        funcionario1.acessarItem(item1);
        funcionario1.favoritarItem(item1);

        funcionario1.listarItens();

        Pessoa pessoa = new Pessoa("Pessoa", "01234567890", "teste2@fiap.com.br");

        Funcionario funcionario2 = empresa.contratarPessoa(pessoa, "123456");

        admin.removerFuncionario(funcionario2);

        System.out.println("=====================================");
        System.out.println("Estações, Linhas, Trens, Maquinistas e Percursos");
        Estacao estacao1 = new Estacao("Estação 1", "E1", new ArrayList<String>(Arrays.asList("E1")), true);
        Estacao estacao2 = new Estacao("Estação 2", "E2", new ArrayList<String>(Arrays.asList("E2")), true);
        Estacao estacao3 = new Estacao("Estação 3", "E3", new ArrayList<String>(Arrays.asList("E3")), true);
        Estacao estacao4 = new Estacao("Estação 4", "E4", new ArrayList<String>(Arrays.asList("E4")), true);
        Estacao estacao5 = new Estacao("Estação 5", "E5", new ArrayList<String>(Arrays.asList("E5")), true);

        Linha linha1 = new Linha("Linha 1", "L1",
                new ArrayList<Estacao>(Arrays.asList(estacao1, estacao2, estacao3, estacao4, estacao5)));

        Trem trem1 = new Trem("Trem 1", "T1", true);
        Trem trem2 = new Trem("Trem 2", "T2", true);

        Maquinista maquinista1 = new Maquinista("Maquinista 1", "12345678910", "maquinista@fiap.com.br", "123456");
        Maquinista maquinista2 = new Maquinista("Maquinista 2", "12345678911", "maquinista2@fiap.com.br", "123456");

        // Senha correta
        maquinista1.login("123456");

        // Senha incorreta
        maquinista1.login("1234567");

        maquinista1.setTrem(trem1);
        maquinista2.setTrem(trem2);

        trem1.setMaquinista(maquinista1);
        trem2.setMaquinista(maquinista2);

        trem1.getMaquinista().andar();
        trem1.getMaquinista().estacionar();
        trem1.getMaquinista().abrirPortas();
        trem1.getMaquinista().fecharPortas();

        trem2.getMaquinista().andar();
        trem2.getMaquinista().estacionar();
        trem2.getMaquinista().abrirPortas();
        trem2.getMaquinista().fecharPortas();

        System.out.println("Estações da linha " + linha1.getNome() + ":");
        for (Estacao estacao : linha1.getEstacoes()) {
            System.out.println(estacao.getNome());
        }

        System.out.println("Trens da linha " + linha1.getNome() + ":");
        for (Estacao estacao : linha1.getEstacoes()) {
            System.out.println(estacao.getNome());
        }

        Percurso percurso1 = new Percurso(estacao4, estacao5, linha1);

        percurso1.iniciarPercurso();
        System.out.println("Percurso iniciado em: " + percurso1.getDataInicio());

        Thread.sleep(1000);

        percurso1.finalizarPercurso();
        System.out.println("Percurso finalizado em: " + percurso1.getDataFim());

        percurso1.imprimirTempoDePercurso();

    }
}