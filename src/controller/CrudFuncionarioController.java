package controller;

import model.dao.FuncionarioDAO;
import model.bo.AdminBO;
import model.vo.Funcionario;
import view.CrudFuncionarioView;

import java.util.List;

public class CrudFuncionarioController {
    private FuncionarioDAO model;
    private CrudFuncionarioView view;

    public CrudFuncionarioController(FuncionarioDAO model, CrudFuncionarioView view) {
        this.model = model;
        this.view = view;
    }

    public void cadastrarFuncionario(AdminBO adminBO){

        int idFuncionario = model.definirID();
        String nomeFuncionario = view.obterNomeFuncionario();
        String CPFFuncionario = view.obterCPFFuncionario();
        String cargoFuncionario = view.obterCargoFuncionario();
        String emailFuncionario = view.obterEmailFuncionario();
        String senhaFuncionario = view.obterSenhaFuncionario();

        model.inserir(new Funcionario(idFuncionario, nomeFuncionario, CPFFuncionario, emailFuncionario, senhaFuncionario, cargoFuncionario), adminBO);
    }

    public void removerFuncionario(int id){
        model.excluir(id);
    }

    public void editarFuncionario(AdminBO adminBO){
        int idFuncionario = view.obterIdFuncionario();
        String nomeFuncionario = view.obterNomeFuncionario();
        String CPFFuncionario = view.obterCPFFuncionario();
        String cargoFuncionario = view.obterCargoFuncionario();
        String emailFuncionario = view.obterEmailFuncionario();
        String senhaFuncionario = view.obterSenhaFuncionario();

        model.update(new Funcionario(idFuncionario, nomeFuncionario, CPFFuncionario, emailFuncionario, senhaFuncionario, cargoFuncionario), adminBO);
    }

    public void listarFuncionarios(){
        List<Funcionario> lista = model.listar();

        for(Funcionario funcionario : lista){
            String mensagem = "Nome: " + funcionario.getNome() + ", ID: " + funcionario.getId_funcionario();
            view.exibirMensagem(mensagem);
        }
    }


}
