package controller;

import model.dao.FuncionarioDAO;
import model.vo.Funcionario;
import view.LoginView;

public class LoginController {
    private LoginView view;
    private FuncionarioDAO model;

    public LoginController(FuncionarioDAO model, LoginView view) {
        this.model = model;
        this.view = view;
    }

    public Funcionario realizarLogin(){
        String nomeDoUsuario = view.obterNomeUsuario();
        String senha = view.obterSenhaUsuario();

        Funcionario funcionario = model.autenticar(nomeDoUsuario, senha);

        if (funcionario != null){
            view.exibirMensagem("Login efetuado com sucesso!");
            return funcionario;
        }
        else{
            view.exibirMensagem("Nome do usuário ou senha inválidos");
            return null;
        }
    }
}
