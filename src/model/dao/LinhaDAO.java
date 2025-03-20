package model.dao;

import credentials.Credenciais;
import model.vo.Estacao;
import model.vo.Item;
import model.vo.Linha;
import oracle.jdbc.datasource.impl.OracleDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LinhaDAO {
    private String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
    private Connection conn;

    public LinhaDAO() throws SQLException {
        OracleDataSource ods = new OracleDataSource();
        ods.setURL(url);
        ods.setUser(Credenciais.user);
        ods.setPassword(Credenciais.pwd);
        conn = ods.getConnection();
        System.out.println("Conectado ao banco de dados!");
    }

    public boolean inserir(Linha linha) {
        String sql = "INSERT INTO linha VALUES(?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, linha.getId_linha());
            ps.setString(2, linha.getNome());
            ps.setString(3, linha.getSigla());
            ps.execute();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir linha!");
            e.printStackTrace();
            return false;
        } finally {
            fecharConexao();
        }
        return true;
    }

    public boolean excluir(int id) {
        String sql = "DELETE FROM linha WHERE id_linha = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            System.err.println("Erro ao remover linha!");
            e.printStackTrace();
            return false;
        } finally {
            fecharConexao();
        }
        return true;
    }

    public boolean atualizar(Linha linha) {
        String sql = "UPDATE linha SET nome = ?, sigla = ?, numero = ? WHERE id_linha = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, linha.getNome());
            ps.setString(2, linha.getSigla());
            ps.setInt(3, linha.getNumero());
            ps.setInt(4, linha.getId_linha());
            ps.execute();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar linha!");
            e.printStackTrace();
            return false;
        } finally {
            fecharConexao();
        }
        return true;
    }

    public List<Linha> listar() {
        List<Linha> linhas = new ArrayList<>();
        String sql = "SELECT * FROM linha";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_linha = rs.getInt("id_linha");
                String nome = rs.getString("nome");
                String sigla = rs.getString("sigla");
                int numero = rs.getInt("numero");


                EstacaoDAO estacaoDAO = new EstacaoDAO();
                List<Estacao> estacoes = new ArrayList<>();

                estacoes = estacaoDAO.listarEstacoesLinha(id_linha);

                linhas.add(new Linha(id_linha, nome, sigla, numero));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar linhas!");
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
        return linhas;
    }

    public Item selecionarLinha(int numero){
        Linha linha = null;
        String sql = "SELECT * FROM linha " +
                "WHERE numero = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, numero);

            ResultSet rs = ps.executeQuery();


            int id_linha = rs.getInt("id_linha");
            String nome = rs.getString("nome");
            String sigla = rs.getString("sigla");

            linha = new Linha(id_linha, nome, sigla, numero);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void fecharConexao() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Conexão fechada!");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao fechar a conexão!");
            e.printStackTrace();
        }
    }
}