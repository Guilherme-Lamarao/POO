package dao;

import modelo.Usuario;
import java.sql.SQLException;
import java.util.List;

public interface UsuarioDAO {
    int inserir(Usuario usuario) throws SQLException;
    Usuario autenticar(String username, String userpass) throws SQLException;
    List<Usuario> listar() throws SQLException;
}
