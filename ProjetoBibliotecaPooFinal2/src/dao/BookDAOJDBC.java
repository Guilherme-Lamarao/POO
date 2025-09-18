package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Book;

public class BookDAOJDBC implements BookDAO {
    
    // Método para inserir um novo livro no banco de dados
    @Override
    public int inserir(Book book) {
        String sql = "INSERT INTO book(title, author, ano, genre, editora, pagtotais, paglidas, usuario) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        int linhasAfetadas = 0;
        try {
            linhasAfetadas = DAOGenerico.executarComando(
                sql, 
                book.getTitle(), 
                book.getAuthor(), 
                book.getAno(), 
                book.getGenre(), 
                book.getEditora(), 
                book.getPagtotais(), 
                book.getPaglidas(), 
                book.getUsuario()  // Inserindo o nome do usuário que cadastrou o livro
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linhasAfetadas;
    }

    // Método para editar um livro existente
    @Override
    public int editar(Book book) {
        String sql = "UPDATE book SET title = ?, author = ?, ano = ?, genre = ?, editora = ?, pagtotais = ?, paglidas = ? " +
                     "WHERE codigo = ?";
        int linhasAfetadas = 0;
        try {
            linhasAfetadas = DAOGenerico.executarComando(
                sql, 
                book.getTitle(), 
                book.getAuthor(), 
                book.getAno(), 
                book.getGenre(), 
                book.getEditora(), 
                book.getPagtotais(), 
                book.getPaglidas(), 
                book.getCodigo()  // Atualiza o livro com base no código
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linhasAfetadas;
    }

    // Método para excluir um livro do banco de dados pelo código
    @Override
    public int apagar(int codigo) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM book WHERE codigo = ?";
        int linhasAfetadas = 0;
        try {
            linhasAfetadas = DAOGenerico.executarComando(sql, codigo);
        } catch (SQLException e) {
            throw new SQLException("Erro ao apagar o livro: " + e.getMessage());
        }
        return linhasAfetadas;
    }

    // Método para listar todos os livros do banco de dados
    @Override
    public List<Book> listar() {
        String sql = "SELECT * FROM book";
        List<Book> books = new ArrayList<>();
        try (ResultSet rset = DAOGenerico.executarConsulta(sql)) {
            while (rset.next()) {
                Book book = new Book();
                book.setCodigo(rset.getInt("codigo"));
                book.setTitle(rset.getString("title"));
                book.setAuthor(rset.getString("author"));
                book.setAno(rset.getInt("ano"));
                book.setGenre(rset.getString("genre"));
                book.setEditora(rset.getString("editora"));
                book.setPagtotais(rset.getInt("pagtotais"));
                book.setPaglidas(rset.getInt("paglidas"));
                book.setUsuario(rset.getString("usuario"));  // Adiciona o nome do usuário
                books.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }

    // Método para buscar um livro específico pelo código
    @Override
    public Book buscar(int codigo) {
        String sql = "SELECT * FROM book WHERE codigo = ?";
        Book book = null;
        try (Connection conn = DAOGenerico.getConexao(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                book = new Book();
                book.setCodigo(rs.getInt("codigo"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setAno(rs.getInt("ano"));
                book.setGenre(rs.getString("genre"));
                book.setEditora(rs.getString("editora"));
                book.setPagtotais(rs.getInt("pagtotais"));
                book.setPaglidas(rs.getInt("paglidas"));
                book.setUsuario(rs.getString("usuario"));  // Adiciona o nome do usuário
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return book;
    }

    // Implementação do método listar(int codigo) usando o método buscar
    @Override
    public Book listar(int codigo) {
        return buscar(codigo);
    }

    @Override
    public int excluir(int codigo) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
