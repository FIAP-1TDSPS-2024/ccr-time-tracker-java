package model.dao;

import credentials.Credenciais;
import model.vo.Trem;
import model.vo.Viagem;
import oracle.jdbc.datasource.impl.OracleDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TremDAO {
    private String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
    private Connection conn;

    public TremDAO() throws SQLException {
        OracleDataSource ods = new OracleDataSource();
        ods.setURL(url);
        ods.setUser(Credenciais.user);
        ods.setPassword(Credenciais.pwd);
        conn = ods.getConnection();
        System.out.println("Conectado!");
    }

    public boolean inserir(Trem trem) {
        String sql = "INSERT INTO trem (id_trem, status, numeracao) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, trem.getId_trem());
            ps.setBoolean(2, trem.isAtivo());
            ps.setInt(3, trem.getNumeracao());
            ps.execute();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir trem!");
            e.printStackTrace();
            return false;
        } finally {
            fecharConexao();
        }
        return true;
    }

    public boolean excluir(int id) {
        String sql = "DELETE FROM trem WHERE id_trem = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            System.err.println("Erro ao remover trem!");
            e.printStackTrace();
            return false;
        } finally {
            fecharConexao();
        }
        return true;
    }

    public void atualizar(Trem trem) {
        String sql = "UPDATE trem SET status = ?, numeracao = ? WHERE id_trem = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setBoolean(1, trem.isAtivo());
            ps.setInt(2, trem.getNumeracao());
            ps.setInt(3, trem.getId_trem());
            ps.execute();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar trem!");
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    public List<Trem> listar() {
        List<Trem> trens = new ArrayList<>();
        String sql = "SELECT * FROM trem";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idTrem = rs.getInt("id_trem");
                Boolean status = rs.getBoolean("status");
                int numeracao = rs.getInt("numeracao");
                trens.add(new Trem(idTrem, status, numeracao));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar trens!");
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
        return trens;
    }

    private void fecharConexao() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Conexão fechada!");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao fechar conexão!");
            e.printStackTrace();
        }
    }
}

