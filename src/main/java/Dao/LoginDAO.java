/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Profesor;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginDAO {

    private Connection conexion;

    //Conectar a la Base de datos
    public LoginDAO() throws URISyntaxException {
        DbConnection c = new DbConnection();
        this.conexion = c.getConnection();
    }

    //Desconectar a la Base de datos
    public void desconectar() throws SQLException, ClassNotFoundException {
        conexion.close();
    }

    //Metodo para consultar si un email y contraseñan pertenecen a una cuenta registrada
    public boolean isAcountExists(String usuario, String password) throws SQLException {
        String sql = "SELECT * FROM Usuario WHERE usuario='" + usuario + "' AND contraseña='" + password + "'";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }

    //Metodo para consultar si el email recibido ya esta registrado
    public boolean isEmailRegistered(String usuario) throws SQLException {
        String sql = "SELECT * FROM Usuario WHERE usuario='" + usuario + "'";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }

    public String getNameByEmail(String email) throws SQLException {
        String sql = "(SELECT * FROM Profesor  where usuario='" + email.trim() + "' ) union (SELECT * FROM Admin  where usuario='" + email.trim() + "' )";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getString("nombre");
        }

        return null;
    }

    public String gettypeByEmail(String email) throws SQLException {
        String sql = "SELECT * FROM Usuario WHERE usuario='" + email + "'";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getString("tipoUsuario");
        }
        return null;
    }
}
