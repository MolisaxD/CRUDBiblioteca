package dao;

import model.Livro;

import java.sql.*;
import java.util.ArrayList;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection getConnection() {
        try{
            System.out.println("Operação realizada com sucesso.");
            return DriverManager.getConnection(URL, USER, PASS);
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void create(Livro novoLivro) {
        String query = "INSERT INTO livros (titulo, autor) VALUES (?,?)";
        try {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, novoLivro.getTitulo());
            stmt.setString(2, novoLivro.getAutor());

            stmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Livro> read() {
        ArrayList<Livro> listaLivros = new ArrayList<>();
        String query = "SELECT * FROM livros";
        try {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                listaLivros.add(new Livro(rs.getInt("idLivro"), rs.getString("titulo"), rs.getString("autor")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaLivros;
    }

    public static void update(Livro livroAtualizado, int idLivro) {
        String query = "UPDATE livros SET titulo = ?, autor = ? WHERE idLivro = ?";
        try {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1,livroAtualizado.getTitulo());
            stmt.setString(2, livroAtualizado.getAutor());
            stmt.setInt(3, idLivro);

            stmt.execute();

        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int idLivro) {
        String query = "DELETE FROM livros WHERE idLivro = ?";
        try {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, idLivro);

            stmt.execute();

        } catch(SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
