package application.model.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoBD {

    // Método para estabelecer uma conexão com o banco de dados SQLite
    public Connection conectar() {
        try {
            // Carrega o driver JDBC do SQLite
            Class.forName("org.sqlite.JDBC");
            // Retorna a conexão usando o caminhp do banco de dados
            return DriverManager.getConnection("jdbc:sqlite:inventariodb");
        } catch (ClassNotFoundException | SQLException e) {
            // Tratando exceções relacionadas à conexão
            e.printStackTrace();
            return null;
        }
    }

    // Método para criar a tabela teste
    public void criarTabelaTeste() {
        try (Connection conn = conectar();
             Statement statement = conn.createStatement()) {
            // Define a instrução SQL para criar a tabela
            String sql = "CREATE TABLE IF NOT EXISTS inventario (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nome TEXT NOT NULL);";
            // Executa a instrução SQl para criar a tabela
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            // trata exceções relacionadas à execução da instrução SQL
            e.printStackTrace();
        }
    }

}
