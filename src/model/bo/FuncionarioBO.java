package model.bo;

import connection.CrudConnection;
import controller.CrudFuncionarioController;
import controller.CrudItemController;
import model.dao.FuncionarioDAO;
import model.dao.ItemDAO;
import model.vo.Funcionario;
import model.vo.Item;
import view.CrudFuncionarioView;
import view.CrudItemView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioBO extends Funcionario{

    private ItemDAO model;
    private CrudItemView view;
    private CrudItemController controller;
    private List<Item> itens;

    public FuncionarioBO(int id_funcionario, String nome, String cpf, String email, String senha, String cargo, CrudConnection connection) throws SQLException {
        super(id_funcionario, nome, cpf, email, senha, cargo);
        itens = new ArrayList<Item>();
        this.model = new ItemDAO(connection);
        this.view = new CrudItemView();
        this.controller = new CrudItemController(model, view);
    }

    public void adicionarItem() {
        controller.adicionarItem(this);
    }

    public void removerItem(Item item) {
        controller.removerItem();
    }

    public void editarItem(){
        controller.editarItem(this);
    }

    //public void acessarItem(Item item) {}

    public void listarItens() {
        controller.buscarItensFunc(this);
    }

    public void favoritarItem(Item item) {
        item.setFavorito(true);
    }

    public void desfavoritarItem(Item item) {
        item.setFavorito(false);
    }
}
