package model.dao;

import credentials.Credenciais;
import model.vo.Estacao;
import oracle.jdbc.datasource.impl.OracleDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstacaoDAO {

    /*
     * Connection URL: The connection URL for the oracle10G
     * database is jdbc:oracle:thin:@localhost:1521:xe where
     * jdbc is the API, oracle is the database, thin is the driver,
     * localhost is the server name on which oracle is running,
     * we may also use IP address, 1521 is the port number and XE
     * is the Oracle service name.
     */

    private String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
    private Connection conn;


    public EstacaoDAO() throws SQLException {

        OracleDataSource ods = new OracleDataSource();

        //configurando a URL
        ods.setURL(url);
        //configurando o usuário
        ods.setUser(Credenciais.user);
        //configurando a senha
        ods.setPassword(Credenciais.pwd);
        //obtendo uma conexão com o jdbc
        conn = ods.getConnection();

        System.out.println("Conectado!");
    }

    //método inserir()
    public boolean inserir(Estacao estacao) {

        //persons é o nome da tabela
        String sql = "INSERT into estacao VALUES(?, ?, ?, ?)";

        //preparação do statement
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, estacao.getId_estacao());
            ps.setString(2, estacao.getNome());
            ps.setString(3, estacao.getSigla());
            ps.setString(4, estacao.getEndereco());
            ps.execute();
        } catch (SQLException e) {
            if(conn == null) {
                System.err.println("Conexão nula!");
            }else {
                System.err.println("Erro no PreparedStatement!");
            }
            e.printStackTrace();
            return false;
        }finally {
            System.out.println("Fechando a conexão com o banco de dados!");
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão!");
                e.printStackTrace();
            }
        }
        return true;
    }

    //método excluir()
    public boolean excluir(int id) {
        String sql = "DELETE FROM estacao WHERE id_estacao = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            System.err.println("Erro ao remover estacão!");
            e.printStackTrace();
            return false;
        }finally {
            System.out.println("Fechando a conexão com o banco de dados!");
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("Não foi possível encerrar a conexão!");
                e.printStackTrace();
            }
        }
        return true;
    }

    //Método atualizar
    public void update(Estacao estacao){
        System.out.println("Atualizando Estação " + estacao.getNome());

        String sql = "update cliente SET nome = ?, sigla = ?, endereco = ? " +
                "WHERE id_estacao = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, estacao.getNome());
            ps.setString(2, estacao.getSigla());
            ps.setString(3, estacao.getEndereco());
            ps.setInt(4, estacao.getId_estacao());
            ps.execute();
        } catch (SQLException e) {
            if (conn == null){
                System.err.println("Conexão nula! - Atualizar");
            }
            else{
                System.err.println("Erro no prepared Statement");
            }
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //Método ler
    public List<Estacao> listar(){

        //criando uma lista de Clientes
        List<Estacao> estacoes = new ArrayList<Estacao>();

        //Configurando a query
        String sql = "SELECT * FROM estacao";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            //Preparar o objeto para receber os resultados
            ResultSet rs = ps.executeQuery(sql);

            while (rs.next()){
                int id_estacao = rs.getInt("id_estacao");
                String nome = rs.getString("nome");
                String sigla = rs.getString("sigla");
                String endereco = rs.getString("endereco");

                estacoes.add(new Estacao(id_estacao, nome, sigla, endereco));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return estacoes;
    }

    //Método consultar estacoes por linha
    public List<Estacao> listarEstacoesLinha(int idEstacao){

        //criando uma lista de Clientes
        List<Estacao> estacoes = new ArrayList<Estacao>();

        //Configurando a query
        String sql = "SELECT * FROM estacao" +
                     "INNER JOIN linha_estacao" +
                     "ON linha_estacao.id_linha = estacao.id_estacao" +
                     " WHERE id_linha = ?; ";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            //Preparar o objeto para receber os resultados
            ResultSet rs = ps.executeQuery(sql);
            ps.setInt(1, idEstacao);
            ps.execute();

            while (rs.next()){
                int id_estacao = rs.getInt("id_estacao");
                String nome = rs.getString("nome");
                String sigla = rs.getString("sigla");
                String endereco = rs.getString("endereco");

                estacoes.add(new Estacao(id_estacao, nome, sigla, endereco));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return estacoes;
    }
}
