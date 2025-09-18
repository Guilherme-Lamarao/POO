/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

public class DAOFactory {
    public static BookDAO criarBookDAO() {
        return new BookDAOJDBC();
    }
    public static UsuarioDAO criarUsuarioDAO(){
        return new UsuarioDAOJDBC();
    } 
}
