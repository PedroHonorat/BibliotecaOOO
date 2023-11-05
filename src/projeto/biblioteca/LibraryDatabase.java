package projeto.biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LibraryDatabase {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Conectar ao banco de dados SQLite (o arquivo library.db será criado se não existir)
            connection = DriverManager.getConnection("jdbc:sqlite:library.db");
            statement = connection.createStatement();

            // Criar a tabela "Livros" para armazenar informações sobre os livros
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Livros (" +
                    "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "Titulo TEXT," +
                    "Quantidade INTEGER" +
                    ");");

            // Criar a tabela "Locacoes" para rastrear quem alugou os livros
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Locacoes (" +
                    "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "Livro_ID INTEGER," +
                    "Aluguel_Ativo INTEGER," +
                    "Locatario TEXT," +
                    "FOREIGN KEY (Livro_ID) REFERENCES Livros(ID)" +
                    ");");

            // Inserir alguns dados de exemplo
            statement.executeUpdate("INSERT INTO Livros (Titulo, Quantidade) VALUES ('Livro A', 5);");
            statement.executeUpdate("INSERT INTO Livros (Titulo, Quantidade) VALUES ('Livro B', 10);");
            statement.executeUpdate("INSERT INTO Livros (Titulo, Quantidade) VALUES ('Livro C', 3);");

            // Exibir informações sobre os livros e locações
            ResultSet resultSet = statement.executeQuery("SELECT Livros.Titulo, Livros.Quantidade, " +
                    "Locacoes.Locatario, COUNT(Locacoes.ID) AS Alugados FROM Livros " +
                    "LEFT JOIN Locacoes ON Livros.ID = Locacoes.Livro_ID GROUP BY Livros.Titulo;");
            while (resultSet.next()) {
                String titulo = resultSet.getString("Titulo");
                int quantidade = resultSet.getInt("Quantidade");
                String locatario = resultSet.getString("Locatario");
                int alugados = resultSet.getInt("Alugados");
                System.out.println("Livro: " + titulo);
                System.out.println("Quantidade na Biblioteca: " + quantidade);
                System.out.println("Locatário: " + (locatario != null ? locatario : "Nenhum"));
                System.out.println("Quantidade Alugados: " + alugados);
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
