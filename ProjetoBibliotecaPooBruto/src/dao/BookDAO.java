package dao;

import java.util.List;
import modelo.Book;
import java.sql.SQLException;

public interface BookDAO {
    
    
    public int inserir(Book book);
    
    public int editar(Book book);
       
    public int apagar(int codigo) throws ClassNotFoundException, SQLException;
       
    public List<Book> listar();
        
    public Book listar(int codigo);

    public Book buscar(int codigo);  
    
    public int excluir(int codigo) throws ClassNotFoundException, SQLException;  
}
