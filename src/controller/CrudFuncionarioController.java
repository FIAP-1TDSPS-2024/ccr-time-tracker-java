package controller;

import model.dao.FuncionarioDAO;
import model.vo.Admin;
import model.vo.Funcionario;
import view.CrudFuncionarioView;

public class CrudFuncionarioController {
    private FuncionarioDAO model;
    private CrudFuncionarioView view;

    public CrudFuncionarioController(FuncionarioDAO model, CrudFuncionarioView view) {
        this.model = model;
        this.view = view;
    }

    public void cadastrarFuncionario(Admin admin){

        int idFuncionario = model.definirID();
        String nomeFuncionario = view.obterNomeFuncionario();
        String CPFFuncionario = view.obterCPFFuncionario();
        String cargoFuncionario = view.obterCargoFuncionario();
        String emailFuncionario = view.obterEmailFuncionario();
        String senhaFuncionario = view.obterSenhaFuncionario();

        model.inserir(new Funcionario(idFuncionario, nomeFuncionario, CPFFuncionario, emailFuncionario, senhaFuncionario, cargoFuncionario), admin);
    }
}
