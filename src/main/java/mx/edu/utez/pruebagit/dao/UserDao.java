package mx.edu.utez.pruebagit.dao;

import mx.edu.utez.pruebagit.model.user;
import mx.edu.utez.pruebagit.utils.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public user getOne(String user_name, String pass) {
        user user = new user();
        String query = "select * from user where user_name = ?  and pass =  sha2(?,256) ";
        //los simbolos de interrogacion son para evitar la inyeccion de codigo Sql

        try{
            //conectarme a la base de datos
            Connection con = DatabaseConnectionManager.getConnection();
            //me prepara la consulta para ser ejecutada
            PreparedStatement ps = con.prepareStatement(query);
            //voy a definir los parametros de Query (los "?")
            ps.setString(1, user_name);
            ps.setString(2, pass);
            //ejecutar una consulta
            ResultSet rs = ps.executeQuery();
            //obtener el informacion del resultset
            if(rs.next()){
                //que el usuario si existe en la base de datos
                user.setUser_name(rs.getString("user_name"));
                user.setPass(rs.getString("pass"));
                user.setEmail(rs.getString("email"));
                user.setCody(rs.getString("cody"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }
}
