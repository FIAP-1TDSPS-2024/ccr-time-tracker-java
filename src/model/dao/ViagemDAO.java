package model.dao;

import credentials.Credenciais;
import model.vo.Viagem;
import oracle.jdbc.datasource.impl.OracleDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ViagemDAO {
    private String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
    private Connection conn;

    public ViagemDAO() throws SQLException {
        OracleDataSource ods = new OracleDataSource();
        ods.setURL(url);
        ods.setUser(Credenciais.user);
        ods.setPassword(Credenciais.pwd);
        conn = ods.getConnection();
        System.out.println("Conectado ao banco de dados!");
    }

    public boolean inserir(Viagem viagem) {
        String sql = "INSERT INTO viagem (id_viagem, id_estacao_partida, id_estacao_destino, data_partida, data_chegada) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, viagem.getId_viagem());
            ps.setInt(2, viagem.getestacaoOrigem().getId_estacao());
            ps.setInt(3, viagem.getEstacaoDestino().getId_estacao());
            ps.setTimestamp(4, viagem.getDataInicio());
            ps.setTimestamp(5, viagem.getDataFim());
            ps.execute();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir viagem!");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean excluir(int id) {
        String sql = "DELETE FROM viagem WHERE id_viagem = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            System.err.println("Erro ao remover viagem!");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean atualizar(Viagem viagem) {
        String sql = "UPDATE viagem SET id_estacao_partida = ?, id_estacao_destino = ?, data_partida = ?, data_chegada = ? WHERE id_viagem = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, viagem.getEstacaoOrigem().getId_estacao());
            ps.setInt(2, viagem.getEstacaoDestino().getId_estacao());
            ps.setTimestamp(3, viagem.getDataInicio());
            ps.setTimestamp(4, viagem.getDataFim());
            ps.setInt(5, viagem.getId_viagem());
            ps.execute();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar viagem!");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Viagem> listar() {
        List<Viagem> viagens = new ArrayList<>();
        String sql = "SELECT * FROM viagem";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_viagem = rs.getInt("id_viagem");
                int id_estacao_partida = rs.getInt("id_estacao_partida");
                int id_estacao_destino = rs.getInt("id_estacao_destino");


                //viagens.add(new Viagem(id_viagem, id_estacao_partida, id_estacao_destino));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar viagens!");
            e.printStackTrace();
        }
        return viagens;
    }
}

