
package dao;

import java.util.List;
import modelo.Book;
import java.sql.*;


public interface BookDAO {
    public int inserir(Book book);
    public int editar(Book book);
    public int apagar(int codigo) throws ClassNotFoundException, SQLException, SQLIntegrityConstraintViolationException;
    public List<Book> listar();
    public Book listar(int codigo);
}
