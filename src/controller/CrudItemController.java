package controller;

import model.dao.ItemDAO;
import model.vo.Funcionario;
import model.vo.Item;
import view.CrudItemView;

import java.util.List;

public class CrudItemController {
    private ItemDAO model;
    private CrudItemView view;

    public CrudItemController(ItemDAO model, CrudItemView view) {
        this.model = model;
        this.view = view;
    }

    public void buscarItensFunc(Funcionario funcionario){
        List<Item> lista = model.listarItensFunc(funcionario.getId_funcionario());

        for(Item item : lista){
            String mensagem = "Nome: " + item.getNome() + ", ID: " + item.getId_item() + ", URL: " + item.getUrl();
            view.exibirMensagem(mensagem);
        }
    }

    public void adicionarItem(Funcionario funcionario){

        int id = model.definirID();
        String nome = view.obterNomeItem();
        String abrev = view.obterAbrevItem();
        String url = view.obterURLItem();

        model.inserir(new Item(id, nome, abrev, url), funcionario);
    }

    public void removerItem(){
        int id = view.obterIdItem();
        model.excluir(id);
    }

    public void editarItem(Funcionario funcionario){
        int id = view.obterIdItem();
        String nome = view.obterNomeItem();
        String abrev = view.obterAbrevItem();
        String url = view.obterURLItem();

        model.update(new Item(id, nome, abrev, url), funcionario);
    }

    public void acessarItem(){
        int id = view.obterIdItem();
        Item item = model.selecionarItem(id);
        String mensagem = "Nome: " + item.getNome() + ", ID: " + item.getId_item() + ", URL: " + item.getUrl();
    }
}
