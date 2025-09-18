package dao;

import java.util.List;
import modelo.Book;
import java.sql.SQLException;

public interface BookDAO {
    
    // Insere um novo livro no banco de dados
    public int inserir(Book book);
    
    // Edita um livro existente no banco de dados
    public int editar(Book book);
    
    // Apaga um livro do banco de dados pelo código
    public int apagar(int codigo) throws ClassNotFoundException, SQLException;
    
    // Lista todos os livros do banco de dados
    public List<Book> listar();
    
    // Lista (busca) um livro específico pelo código
    public Book listar(int codigo);

    // Método para buscar um livro específico pelo código
    public Book buscar(int codigo);  // Nova função para buscar um livro

    // Método para excluir (apagar) um livro pelo código
    public int excluir(int codigo) throws ClassNotFoundException, SQLException;  // Nova função para excluir um livro

}
