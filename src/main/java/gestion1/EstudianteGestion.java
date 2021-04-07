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
import model.estudiante;

/**
 *
 * @author Fernando
 */
public class EstudianteGestion {
    private static final String SQL_SELECT_TOTAL = "SELECT * FROM estudiante;";
    private static final String SQL_SELECT_FILTRADO = "SELECT * FROM estudiante where id_estudiante=? ";
    private static final String SQL_UPDATE_GENERAL = "UPDATE estudiante SET nombre = ?,email = ?,fecha_nacimiento = ?, contrasena = ?,desc_estudiante = ?,nombre_carrera = ?,identificacion = ? WHERE id_estudiante = ? ;";
    private static final String SQL_DELETE_PARCIAL  = "DELETE FROM estudiante where id_estudiante=?";
    private static final String SQL_INSERT = "INSERT INTO estudiante (  nombre,  email,  fecha_nacimiento,  contrasena,  desc_estudiante,  nombre_carrera,  identificacion) VALUES  (    ?,    ?,    ?,    ?,    ?,    ?,    ?  ) ;";
    
    
    
     public static ArrayList<estudiante> getEstudiantes() {
        ArrayList<estudiante> lista = new ArrayList<>();
        try {
            PreparedStatement sentencia = Conexion.getConexion()
                    .prepareStatement(SQL_SELECT_TOTAL);
            ResultSet rs = sentencia.executeQuery();
            while (rs != null && rs.next()) {
                lista.add(new estudiante(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                        
                ));
            }

        } catch (SQLException ex) {
            Logger.getLogger(EstudianteGestion.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return lista;

    }
     
     //Metodo encargado de traer un estudiante
    public static estudiante getEstudiante(int id) {
        estudiante estudiante_ = null;
        try {
            PreparedStatement sentencia = Conexion.getConexion()
                    .prepareStatement(SQL_SELECT_FILTRADO);
            sentencia.setInt(1, id);
            
            ResultSet rs = sentencia.executeQuery();
            while (rs != null && rs.next()) {
                estudiante_ = new estudiante(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                );
            }

        } catch (SQLException ex) {
            Logger.getLogger(EstudianteGestion.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return estudiante_;

    }
    
    
    public static boolean update(estudiante estudiante_) {
        try {
            PreparedStatement sentencia = Conexion.getConexion()
                    .prepareStatement(SQL_UPDATE_GENERAL);
            sentencia.setString(1, estudiante_.getNombre());
            sentencia.setString(2, estudiante_.getEmail());
            sentencia.setString(3, estudiante_.getFecha_nacimiento());
            sentencia.setString(4, estudiante_.getContrasena());
            sentencia.setString(5, estudiante_.getDesc_estudiante());
            sentencia.setString(6, estudiante_.getNombre_carrera());
            sentencia.setString(7, estudiante_.getIdenticacion());
            sentencia.setInt(8, estudiante_.getId_estudiante());
            
            System.out.println(estudiante_.getId_estudiante());
            System.out.println(estudiante_.getNombre());
            System.out.println(estudiante_.getFecha_nacimiento());
            System.out.println(estudiante_.getContrasena());
            System.out.println(estudiante_.getIdenticacion());
            System.out.println(sentencia.executeUpdate());
            
            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(EstudianteGestion.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean delete(estudiante estudiante_) {
        try {

//            DELETE FROM estudiante where id=? and idEstudiante=?
            PreparedStatement sentencia = Conexion.getConexion()
                    .prepareStatement(SQL_DELETE_PARCIAL);
            sentencia.setInt(1, estudiante_.getId_estudiante());
           
            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteGestion.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static boolean insert(estudiante estudiante_) {
        try {

//            DELETE FROM estudiante where id=? and idEstudiante=?
            PreparedStatement sentencia = Conexion.getConexion()
                    .prepareStatement(SQL_INSERT);
            
            sentencia.setString(1, estudiante_.getNombre());
            sentencia.setString(2, estudiante_.getEmail());
            sentencia.setString(3, estudiante_.getFecha_nacimiento());
            sentencia.setObject(4, estudiante_.getContrasena());
            sentencia.setObject(5, estudiante_.getDesc_estudiante());
            sentencia.setObject(6, estudiante_.getNombre_carrera());
            sentencia.setObject(7, estudiante_.getIdenticacion());
            
           
            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteGestion.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
