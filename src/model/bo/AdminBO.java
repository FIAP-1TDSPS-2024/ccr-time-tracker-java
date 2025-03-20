package model.bo;

import connection.CrudConnection;
import controller.CrudFuncionarioController;
import model.dao.FuncionarioDAO;
import model.vo.Funcionario;
import view.CrudFuncionarioView;

import java.sql.SQLException;

public class AdminBO extends FuncionarioBO{

    private FuncionarioDAO model;
    private CrudFuncionarioView view;
    private CrudFuncionarioController controller;

    public AdminBO(int id_funcionario, String nome, String cpf, String email, String senha, String cargo, CrudConnection connection) throws SQLException {
        super(id_funcionario, nome, cpf, email, senha, cargo, connection);
        this.model = new FuncionarioDAO(connection);
        this.view = new CrudFuncionarioView();
        this.controller = new CrudFuncionarioController(model, view);
    }

    public void cadastrarFuncionario() throws SQLException {
       controller.cadastrarFuncionario(this);
    }

    public void removerFuncionario(int id) throws SQLException {
        controller.removerFuncionario(id);
    }

    public void editarFuncionario() throws SQLException {
        controller.editarFuncionario(this);
    }

    public void listarFuncionarios() throws SQLException {
        controller.listarFuncionarios();
    }

}
