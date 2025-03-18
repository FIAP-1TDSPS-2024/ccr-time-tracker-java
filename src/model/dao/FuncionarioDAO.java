package model.dao;

import credentials.Credenciais;
import model.vo.Admin;
import model.vo.Estacao;
import model.vo.Funcionario;
import oracle.jdbc.datasource.impl.OracleDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
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


    public FuncionarioDAO() throws SQLException {

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
    public boolean inserir(Funcionario funcionario, Admin admin) {

        //persons é o nome da tabela
        String sql = "INSERT into funcionario VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        //preparação do statement
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, funcionario.getId_funcionario());
            ps.setString(2, funcionario.getNome());
            ps.setString(3, funcionario.getCpf());
            ps.setString(4, funcionario.getCargo());
            ps.setString(5, funcionario.getEmail());
            ps.setString(6, funcionario.getSenha());
            ps.setString(7, "false");
            ps.setInt(8, admin.getId_funcionario());
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
        String sql = "DELETE FROM funcionario WHERE id_funcionario = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            System.err.println("Erro ao remover funcionário!");
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
    public void update(Funcionario funcionario, Admin admin){
        System.out.println("Atualizando Funcionário " + funcionario.getNome());

        String sql = "update cliente SET nome = ?, cpf= ?, cargo = ?, email = ?, senha = ?, id_funcionario_admin = ?" +
                "WHERE id_funcionario = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getCpf());
            ps.setString(3, funcionario.getCargo());
            ps.setString(4, funcionario.getEmail());
            ps.setInt(5, admin.getId_funcionario());
            ps.setInt(6, funcionario.getId_funcionario());
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
    public List<Funcionario> listar(){

        //criando uma lista de Funcionários
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();

        //Configurando a query
        String sql = "SELECT * FROM funcionario";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            //Preparar o objeto para receber os resultados
            ResultSet rs = ps.executeQuery(sql);

            while (rs.next()){
                int id_funcionario = rs.getInt("id_funcionario");
                String nome = rs.getString("nome");
                String cpf = rs.getString("sigla");
                String cargo = rs.getString("cargo");
                String email = rs.getString("email");
                String senha = rs.getString("senha");

                funcionarios.add(new Funcionario(id_funcionario, nome, cpf, email, senha, cargo));
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
        return funcionarios;
    }

    public Funcionario autenticar(String email, String senha){

        //Configurando a query
        String sql = "SELECT * FROM funcionario WHERE email = ? AND senha = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, senha);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                int id_funcionario = rs.getInt("id_funcionario");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String cargo = rs.getString("cargo");
                String admin = rs.getString("admin");

                if (admin.equals("true")){
                    return new Admin(id_funcionario, nome, cpf, email, senha, cargo);
                }
                else{
                    return new Funcionario(id_funcionario, nome, cpf, email, senha, cargo);
                }
            }
            else{
                return null;
            }

        } catch (SQLException e) {
            System.err.println("Erro ao autenticar funcionário!");
            e.printStackTrace();
            return null;
        }finally {
            System.out.println("Fechando a conexão com o banco de dados!");
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("Não foi possível encerrar a conexão!");
                e.printStackTrace();
            }
        }
    }

    public int definirID(){

        //Configurando a query
        String sql = "SELECT MAX(id_funcionario) AS maior_id FROM funcionario";
        int novoId = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                novoId = (rs.getInt("maior_id")) + 1;
            }

        } catch (SQLException e) {
            System.err.println("Erro ao autenticar funcionário!");
            e.printStackTrace();
        }finally {
            System.out.println("Fechando a conexão com o banco de dados!");
        }
        return novoId;
    }


}