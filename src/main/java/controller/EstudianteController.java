/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gestion1.EstudianteGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.estudiante;

/**
 *
 * @author User
 */
@Named(value = "estudianteController")
@SessionScoped
public class EstudianteController extends estudiante implements Serializable {

    /**
     * Creates a new instance of EstudianteController
     */
    public EstudianteController() {
    }

    //Metodo encargado de traer todos los estudiantes
    public List<estudiante> getEstudiante() {
        return EstudianteGestion.getEstudiantes();
    }

    //Metodo encargado de mandar el parametro para la busqueda de un estudiante y 
    //mostrarlo en edita.xhtml
    public String editaEstudiante(int id) {
        estudiante estudiante_ = EstudianteGestion.getEstudiante(id);
        if (estudiante_ != null) {
            
            this.setNombre(estudiante_.getNombre());
            this.setId_estudiante(estudiante_.getId_estudiante());
            this.setEmail(estudiante_.getEmail());
            this.setFecha_nacimiento(estudiante_.getFecha_nacimiento());
            this.setContrasena(estudiante_.getContrasena());
            this.setDesc_estudiante(estudiante_.getDesc_estudiante());
            this.setNombre_carrera(estudiante_.getNombre_carrera());
            this.setIdenticacion(estudiante_.getIdenticacion());
            
            return "edita.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Posiblemente el registro no exista");
            FacesContext.getCurrentInstance().addMessage("editaEstudianteForm:identificacion", msg);
            return "list.xhtml";
        }

    }
/*
    public String insertEstudiante() {
        if (EstudianteGestion.insertEstudiante(this)) {
            return "list.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Ocurrio un error al insertar un nuevo estudiante");
            FacesContext.getCurrentInstance().addMessage("editaEstudianteForm:identificacion", msg);
            return "edita.xhtml";

        }
    }*/

    public String updateEstudiante() {
        if (EstudianteGestion.update(this)) {
            return "list.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Ocurrio un error al modificar el estudiante");
            FacesContext.getCurrentInstance().addMessage("editaEstudianteForm:identificacion", msg);
            return "edita.xhtml";

        }
    }

    public String deleteEstudiante() {
        if (EstudianteGestion.delete(this)) {
            return "list.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Ocurrio un error al eliminar el estudiante");
            FacesContext.getCurrentInstance().addMessage("editaEstudianteForm:identificacion", msg);
            return "edita.xhtml";
        }
    }
    
    public String Insertarestudiante() {
        if (EstudianteGestion.insert(this)) {
            return "list.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Ocurrio un error al agregar el profesor");
            FacesContext.getCurrentInstance().addMessage("editaEstudianteForm:identificacion", msg);
            return "list.xhtml";
        }
    }
    
     public String inserta() {
      
       return "inserta.xhtml";
    }

}
