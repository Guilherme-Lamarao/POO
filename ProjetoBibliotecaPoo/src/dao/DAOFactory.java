
package dao;

public class DAOFactory {
    public static BookDAO criarBookDAO() {
        return new BookDAOJDBC();
    }
}

