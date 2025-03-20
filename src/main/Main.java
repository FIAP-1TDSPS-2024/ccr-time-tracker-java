package main;

import connection.CrudConnection;
import controller.LoginController;
import model.bo.AdminBO;
import model.bo.FuncionarioBO;
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
        }
        else if(funcionarioLogado instanceof FuncionarioBO){
            ((FuncionarioBO) funcionarioLogado).listarItens();
            ((FuncionarioBO) funcionarioLogado).editarItem();
            ((FuncionarioBO) funcionarioLogado).adicionarItem();
        }

        connection.fecharConexao();

    }
}