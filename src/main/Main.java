package main;

import controller.LoginController;
import model.dao.FuncionarioDAO;
import model.vo.*;
import view.LoginView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException, SQLException {

        System.out.println("Testes CCR TimeTracker");
        System.out.println("=====================================");
        System.out.println("Empresa, Pessoa, Admin, Funcionário e Item");

        LoginView view = new LoginView();
        FuncionarioDAO model = new FuncionarioDAO();
        LoginController controller = new LoginController(model, view);

        Funcionario funcionarioLogado = controller.realizarLogin();

        if (funcionarioLogado instanceof Admin) {
            ((Admin) funcionarioLogado).cadastrarFuncionario();
        }

    }
}