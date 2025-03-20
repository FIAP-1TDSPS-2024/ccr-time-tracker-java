package model.dao;

import connection.CrudConnection;
import credentials.Credenciais;
import model.vo.Funcionario;
import model.vo.Item;
import oracle.jdbc.datasource.impl.OracleDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {

    private java.sql.Connection conn;
    private CrudConnection connection;

    public ItemDAO(CrudConnection conn) throws SQLException {
        this.conn = conn.getConn();
        this.connection = conn;
    }

    // Método para inserir um item
    public boolean inserir(Item item, Funcionario funcionario) {
        String sql = "INSERT INTO item (id_item, nome, abreviacao, url, id_funcionario) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, item.getId_item());
            ps.setString(2, item.getNome());
            ps.setString(3, item.getAbreviacao());
            ps.setString(4, item.getUrl());
            ps.setInt(5, funcionario.getId_funcionario());
            ps.execute();
        } catch (SQLException e) {
            System.err.println("Erro no PreparedStatement!");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // Método para excluir um item
    public boolean excluir(int id) {
        String sql = "DELETE FROM item WHERE id_item = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            System.err.println("Erro ao remover item!");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // Método para atualizar um item
    public boolean update(Item item, Funcionario funcionario) {
        String sql = "UPDATE item SET nome = ?, abreviacao = ?, url = ?, id_funcionario = ? WHERE id_item = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, item.getNome());
            ps.setString(2, item.getAbreviacao());
            ps.setString(3, item.getUrl());
            ps.setInt(4, funcionario.getId_funcionario());
            ps.setInt(5, item.getId_item());
            ps.execute();
        } catch (SQLException e) {
            System.err.println("Erro no PreparedStatement ao atualizar item!");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Item> listarItensFunc(int idUsuario){
        List<Item> itens = new ArrayList<>();
        String sql = "SELECT * FROM item " +
                     "WHERE id_funcionario = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idUsuario);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idItem = rs.getInt("id_item");
                String nome = rs.getString("nome");
                String abreviacao = rs.getString("abreviacao");
                String url = rs.getString("url");

                itens.add(new Item(idItem, nome, abreviacao, url));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itens;

    }

    public Item selecionarItem(int id){
        Item item = null;
        String sql = "SELECT * FROM item " +
                "WHERE id_item = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();


            int idItem = rs.getInt("id_item");
            String nome = rs.getString("nome");
            String abreviacao = rs.getString("abreviacao");
            String url = rs.getString("url");
            item = new Item(idItem, nome, abreviacao, url);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int definirID(){

        //Configurando a query
        String sql = "SELECT MAX(id_item) AS maior_id FROM item";
        int novoId = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                novoId = (rs.getInt("maior_id")) + 1;
            }

        } catch (SQLException e) {
            System.err.println("Erro ao gerar ID!");
            e.printStackTrace();
        }
        return novoId;
    }
}
