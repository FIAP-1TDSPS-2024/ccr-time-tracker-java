package model.dao;

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
    // Connection URL: URL de conexão com o banco de dados Oracle
    private String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
    private Connection conn;

    public ItemDAO() throws SQLException {
        OracleDataSource ods = new OracleDataSource();

        // Configurando a URL
        ods.setURL(url);
        // Configurando o usuário
        ods.setUser(Credenciais.user);
        // Configurando a senha
        ods.setPassword(Credenciais.pwd);
        // Obtendo uma conexão com o JDBC
        conn = ods.getConnection();

        System.out.println("Conectado ao banco de dados!");
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
        } finally {
            fecharConexao();
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
        } finally {
            fecharConexao();
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
        } finally {
            fecharConexao();
        }
        return true;
    }

    // Método para listar todos os itens
    public List<Item> listar() {
        List<Item> itens = new ArrayList<>();
        String sql = "SELECT * FROM item";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
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
        } finally {
            fecharConexao();
        }
        return itens;
    }

    // Método para fechar a conexão com o banco de dados
    private void fecharConexao() {
        System.out.println("Fechando a conexão com o banco de dados!");
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao fechar a conexão!");
            e.printStackTrace();
        }
    }
}
