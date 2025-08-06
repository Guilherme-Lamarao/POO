package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Book;

public class BookDAOJDBC implements BookDAO {
    
    @Override
    public int inserir(Book book) {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("INSERT INTO book(title, author, genre) ") 
                .append("VALUES (?, ?, ?)");
     
        String insert = sqlBuilder.toString();
        int linha = 0;
        try {  
            linha = DAOGenerico.executarComando(insert, book.getTitle(), book.getAuthor(), book.getGenre()); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return linha;
    }

    @Override
    public int editar(Book book) {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("UPDATE book SET ")
                .append("title = ?, ")
                .append("author = ?, ")
                .append("genre = ?, ")
                .append("WHERE codigo = ? ");
        String update = sqlBuilder.toString();
        int linha = 0;
        try {
            linha = DAOGenerico.executarComando(update, book.getTitle(), book.getAuthor(), book.getGenre(), book.getCodigo());
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return linha; 
    }

    @Override
    public int apagar(int codigo) throws ClassNotFoundException, SQLException, SQLIntegrityConstraintViolationException {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("DELETE FROM book ")
                .append("WHERE codigo = ?");
        String delete = sqlBuilder.toString();
        int linha = 0;        
        linha = DAOGenerico.executarComando(delete, codigo);
        return linha;
    }

    @Override
    public List<Book> listar() {
        ResultSet rset;
        String select = "SELECT * FROM book";
        List<Book> books = new ArrayList<>();
        try {        
            rset = DAOGenerico.executarConsulta(select);
            while (rset.next()) {
                Book book = new Book();
                book.setCodigo(rset.getInt("codigo"));
                book.setTitle(rset.getString("title"));
                book.setAuthor(rset.getString("author"));
                book.setGenre(rset.getString("genre")); 
                books.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return books;
    }

    @Override
    public Book listar(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
