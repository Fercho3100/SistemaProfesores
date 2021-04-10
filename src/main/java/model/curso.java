/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Fernando
 */
public class curso extends carreras {

    private int id_curso;
    private String nombre_curso, descripcion_curso, duracion_curso;

    public curso(int id_carrera, String nombre_carrera) {
        super(id_carrera, nombre_carrera);
    }

    public curso(int id_curso, String nombre_curso, String descripcion_curso, String duracion_curso) {
        this.id_curso = id_curso;
        this.nombre_curso = nombre_curso;
        this.descripcion_curso = descripcion_curso;
        this.duracion_curso = duracion_curso;
    }

    public curso(int id_curso, String nombre_curso, String descripcion_curso, String duracion_curso, int id_carrera, int creditos, String nombre_carrera, String codigo, String fecha_ingreso) {
        super(id_carrera, creditos, nombre_carrera, codigo, fecha_ingreso);
        this.id_curso = id_curso;
        this.nombre_curso = nombre_curso;
        this.descripcion_curso = descripcion_curso;
        this.duracion_curso = duracion_curso;
    }

    public curso() {
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public String getNombre_curso() {
        return nombre_curso;
    }

    public void setNombre_curso(String nombre_curso) {
        this.nombre_curso = nombre_curso;
    }

    public String getDescripcion_curso() {
        return descripcion_curso;
    }

    public void setDescripcion_curso(String descripcion_curso) {
        this.descripcion_curso = descripcion_curso;
    }

    public String getDuracion_curso() {
        return duracion_curso;
    }

    public void setDuracion_curso(String duracion_curso) {
        this.duracion_curso = duracion_curso;
    }

}
