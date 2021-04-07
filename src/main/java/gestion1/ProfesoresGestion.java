/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conexion;
import model.profesores;

/**
 *
 * @author Fernando
 */
public class ProfesoresGestion {
    private static final String SQL_GetProfesores = "SELECT * FROM profesores;";
    private static final String SQL_GETOneProfesor = "SELECT * FROM profesores where id_profesor=? ";
    private static final String SQL_UPDATEProfesor = "UPDATE profesores SET nombre = ?, identificacion = ?, email = ?, estado = ?  WHERE id_profesor = ? ;";
    private static final String SQL_DELETProfesor  = "DELETE FROM profesores where id_profesor=?";
    private static final String SQL_INSERTProfesor = "INSERT INTO profesores (nombre,identificacion,email,estado) VALUES (?, ?, ?, ?);";
    
    
    
     public static ArrayList<profesores> getEstudiantes() {
        ArrayList<profesores> lista = new ArrayList<>();
        try {
            PreparedStatement sentencia = Conexion.getConexion()
                    .prepareStatement(SQL_GetProfesores);
            ResultSet rs = sentencia.executeQuery();
            while (rs != null && rs.next()) {
                lista.add(new profesores(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getBoolean(5)
                        
                ));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProfesoresGestion.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return lista;

    }
     
     //Metodo encargado de traer un estudiante
    public static profesores getProfesor(int id) {
        profesores profesore = null;
        try {
            PreparedStatement sentencia = Conexion.getConexion()
                    .prepareStatement(SQL_GETOneProfesor);
            sentencia.setInt(1, id);
            
            ResultSet rs = sentencia.executeQuery();
            while (rs != null && rs.next()) {
                profesore = new profesores(
                       rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getBoolean(5)
                );
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProfesoresGestion.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return profesore;

    }
    
    
    public static boolean updateProfesor(profesores profesor) {
        try {
            PreparedStatement sentencia = Conexion.getConexion()
                    .prepareStatement(SQL_UPDATEProfesor);
            sentencia.setString(1, profesor.getNombre());
            sentencia.setString(2, profesor.getIdentificacion());
            sentencia.setString(3, profesor.getEmail());
            sentencia.setObject(4, profesor.isEstado());
            sentencia.setObject(5, profesor.getId_profesor());
            
            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ProfesoresGestion.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean deleteProfesor(profesores profesor) {
        try {

//            DELETE FROM estudiante where id=? and idEstudiante=?
            PreparedStatement sentencia = Conexion.getConexion()
                    .prepareStatement(SQL_DELETProfesor);
            sentencia.setInt(1, profesor.getId_profesor());
           
            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ProfesoresGestion.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static boolean insertProfesor(profesores profesor) {
        try {

//            DELETE FROM estudiante where id=? and idEstudiante=?
            PreparedStatement sentencia = Conexion.getConexion()
                    .prepareStatement(SQL_INSERTProfesor);
            sentencia.setString(1, profesor.getNombre());
            sentencia.setString(2, profesor.getIdentificacion());
            sentencia.setString(3, profesor.getEmail());
            sentencia.setBoolean(4, profesor.isEstado());
           
            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ProfesoresGestion.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
