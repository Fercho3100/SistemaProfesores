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
import model.curso;
import model.carreras;


/**
 *
 * @author Fernando
 */
public class CursosGestion extends CarreraGestion {
    
    
    private static final String SELECT_ALL = "SELECT * FROM curso cu INNER JOIN carreras ca ON cu.id_carrera = ca.id_carrera;";
    private static final String SELECT_FILTER = "SELECT * FROM curso cu INNER JOIN carreras ca ON cu.id_carrera = ca.id_carrera WHERE cu.id_curso = ?;";
    private static final String UPDATE_FILTER = "UPDATE curso SET id_carrera=?,nombre_curso = ?,  duracion_curso = ?,  descripcion_curso = ? WHERE id_curso = ? ;";
    private static final String INSERT = "INSERT INTO curso (  id_carrera,  nombre_curso,  duracion_curso,  descripcion_curso) VALUES  (    ?,    ?,    ?,    ?  ) ;";
   
    
    public static ArrayList<curso> getCurso() {
        ArrayList<curso> lista = new ArrayList<>();
        try {
            PreparedStatement sentencia = Conexion.getConexion()
                    .prepareStatement(SELECT_ALL);
            ResultSet rs = sentencia.executeQuery();
            while (rs != null && rs.next()) {
                lista.add(new curso(
                        rs.getInt(1),// id_curso
                        rs.getString(3),//nombre curso
                        rs.getString(5),//descripcion
                        rs.getString(4),// duracion
                        rs.getInt(6),//id_carrera
                        rs.getInt(9),//Creditos
                        rs.getString(7),//Nombre Carrera
                        rs.getString(8),//codigo
                        rs.getString(10)//fecha ingreso
                ));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CarreraGestion.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
     public static ArrayList<curso> getCarrerasSelect() {
        ArrayList<curso> lista = new ArrayList<>();
        try {
            PreparedStatement sentencia = Conexion.getConexion()
                    .prepareStatement(SELECT2);
            ResultSet rs = sentencia.executeQuery();
            while (rs != null && rs.next()) {
                lista.add(new curso(
                        rs.getInt(1),// id_curso
                        rs.getString(2)//nombre curso    
                ));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CarreraGestion.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public static curso getCurso(int id) {
        curso curso_ = null;
        try {
            PreparedStatement sentencia = Conexion.getConexion()
                    .prepareStatement(SELECT_FILTER);
            sentencia.setInt(1, id);
            
            ResultSet rs = sentencia.executeQuery();
            while (rs != null && rs.next()) {
                curso_ = new curso(
                        rs.getInt(1),// id_curso
                        rs.getString(3),//nombre curso
                        rs.getString(5),//descripcion
                        rs.getString(4),// duracion
                        rs.getInt(6),//id_carrera
                        rs.getInt(9),//Creditos
                        rs.getString(7),//Nombre Carrera
                        rs.getString(8),//codigo
                        rs.getString(10)//fecha ingreso
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(CarreraGestion.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return curso_;

    }
     
    public static boolean update(curso curso_) {
        try {
            PreparedStatement sentencia = Conexion.getConexion()
                    .prepareStatement(UPDATE_FILTER);
            sentencia.setInt(1, curso_.getId_carrera());
            sentencia.setString(2, curso_.getNombre_curso());
            sentencia.setString(3, curso_.getDuracion_curso());
            sentencia.setString(4, curso_.getDescripcion_curso());
            sentencia.setInt(5, curso_.getId_curso());

            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(CursosGestion.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return false;
    }
     
    public static boolean insert(curso curso_) {
        try { 
//            DELETE FROM estudiante where id=? and idEstudiante=?
            PreparedStatement sentencia = Conexion.getConexion()
                    .prepareStatement(INSERT);
            System.out.println(curso_.getId_curso());
            sentencia.setInt(1, curso_.getId_carrera());
            sentencia.setString(2, curso_.getNombre_curso());
            sentencia.setString(3, curso_.getDuracion_curso());
            sentencia.setString(4, curso_.getDescripcion_curso());

            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CursosGestion.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
