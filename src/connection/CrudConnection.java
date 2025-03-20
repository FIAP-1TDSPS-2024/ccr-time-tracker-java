package connection;

import credentials.Credenciais;
import oracle.jdbc.datasource.impl.OracleDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class CrudConnection {

    private String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
    private java.sql.Connection conn;

    public CrudConnection() throws SQLException {

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

    public void fecharConexao() {
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConn() {
        return conn;
    }
}
