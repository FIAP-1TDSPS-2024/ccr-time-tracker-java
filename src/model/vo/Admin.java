package model.vo;

import controller.CrudFuncionarioController;
import model.dao.FuncionarioDAO;
import view.CrudFuncionarioView;

import java.sql.SQLException;

public class Admin extends Funcionario {

    public Admin(int id_funcionario, String nome, String cpf, String email, String senha, String cargo) {
        super(id_funcionario, nome, cpf, email, senha, cargo);
    }

    public void cadastrarFuncionario() throws SQLException {
        FuncionarioDAO model = new FuncionarioDAO();
        CrudFuncionarioController funcionarioController = new CrudFuncionarioController(model, new CrudFuncionarioView());
        funcionarioController.cadastrarFuncionario(this);
    }

    public void removerFuncionario(Funcionario funcionario) {

    }

}
