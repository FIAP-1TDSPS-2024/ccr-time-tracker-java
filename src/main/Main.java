package main;

import connection.CrudConnection;
import controller.LoginController;
import model.bo.AdminBO;
import model.bo.FuncionarioBO;
import model.bo.ViagemBO;
import model.dao.FuncionarioDAO;
import model.vo.*;
import view.LoginView;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws InterruptedException, SQLException {

        System.out.println("Testes CCR TimeTracker");
        System.out.println("=====================================");
        System.out.println("Empresa, Pessoa, Admin, Funcionário e Item");

        CrudConnection connection = new CrudConnection();

        LoginView view = new LoginView();
        FuncionarioDAO model = new FuncionarioDAO(connection);
        LoginController controller = new LoginController(model, view);

        Funcionario funcionarioLogado = controller.realizarLogin();

        if (funcionarioLogado instanceof AdminBO) {
            ((AdminBO) funcionarioLogado).listarFuncionarios();
            ((AdminBO) funcionarioLogado).cadastrarFuncionario();
            ((AdminBO) funcionarioLogado).editarFuncionario();
            ((AdminBO) funcionarioLogado).listarFuncionarios();
        }
        else if(funcionarioLogado instanceof FuncionarioBO){
            ((FuncionarioBO) funcionarioLogado).listarItens();
            ((FuncionarioBO) funcionarioLogado).adicionarItem();
            ((FuncionarioBO) funcionarioLogado).listarItens();

            Linha linha9 = new Linha(1, "Linha 8 esmeralda", "L8", 9);

            Estacao estacao1 = new Estacao(1, "Santo Amaro", "SA", "Av. Guido Caloi, 2221 - Santo Amaro, São Paulo - SP, 04753-100");
            Estacao estacao2 = new Estacao(2,"Osasco", "OS", "Osasco - Centro, Osasco - SP, 06016-004");

            Trem trem = new Trem(1, true, 33785);

            ViagemBO fazerViagem = new ViagemBO(new Viagem(1, estacao1, estacao2, linha9, trem), (FuncionarioBO) funcionarioLogado);
            fazerViagem.iniciarPercurso();
            fazerViagem.finalizarPercurso();
            fazerViagem.imprimirTempoDePercurso();
        }
        connection.fecharConexao();
    }
}