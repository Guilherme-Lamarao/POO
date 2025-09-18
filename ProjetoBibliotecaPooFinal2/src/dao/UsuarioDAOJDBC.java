package dao;

import modelo.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAOJDBC implements UsuarioDAO {

    @Override
    public int inserir(Usuario usuario) {
        String sql = "INSERT INTO usuario (username, userpass) VALUES (?, ?)";
        int linhasAfetadas = 0;
        try {
            String senhaHashed = hashPassword(usuario.getUserpass()); // Hash da senha
            linhasAfetadas = DAOGenerico.executarComando(sql, usuario.getUsername(), senhaHashed);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return linhasAfetadas;
    }

    @Override
    public Usuario autenticar(String username, String userpass) {
        String sql = "SELECT * FROM usuario WHERE username = ?";
        ResultSet rset = null;
        Usuario usuario = null;
        try {
            try {
                rset = DAOGenerico.executarConsulta(sql, username);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UsuarioDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (rset.next()) {
                String senhaBanco = rset.getString("userpass");
                if (checkPassword(userpass, senhaBanco)) {
                    usuario = new Usuario();
                    usuario.setUserid(rset.getInt("userid"));
                    usuario.setUsername(rset.getString("username"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    @Override
    public List<Usuario> listar() {
        String sql = "SELECT * FROM usuario";
        List<Usuario> usuarios = new ArrayList<>();
        try {
            ResultSet rset = DAOGenerico.executarConsulta(sql);
            while (rset.next()) {
                Usuario usuario = new Usuario();
                usuario.setUserid(rset.getInt("userid"));
                usuario.setUsername(rset.getString("username"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

    // Métodos auxiliares para hash de senha
    private String hashPassword(String password) {
       
        return password;
    }

    private boolean checkPassword(String password, String hashedPassword) {
       
        return password.equals(hashedPassword); 
    }
}
