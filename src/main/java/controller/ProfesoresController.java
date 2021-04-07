/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gestion1.ProfesoresGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.profesores;

/**
 *
 * @author User
 */
@Named(value = "profesoresController")
@SessionScoped
public class ProfesoresController extends profesores implements Serializable {

    /**
     * Creates a new instance of EstudianteController
     */
    public ProfesoresController() {
    }

    //Metodo encargado de traer todos los estudiantes
    public List<profesores> getProfesores() {
        return ProfesoresGestion.getEstudiantes();
    }

    //Metodo encargado de mandar el parametro para la busqueda de un estudiante y 
    //mostrarlo en edita.xhtml
    public String editaProfesor(int id) {
        profesores profesore = ProfesoresGestion.getProfesor(id);
        if (profesore != null) {
            
            this.setId_profesor(profesore.getId_profesor());
            this.setNombre(profesore.getNombre());
            this.setIdentificacion(profesore.getIdentificacion());
            this.setEstado(profesore.isEstado());
            this.setEmail(profesore.getEmail());
            
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

    public String updateProfesor() {
        if (ProfesoresGestion.updateProfesor(this)) {
            return "list.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Ocurrio un error al modificar el estudiante");
            FacesContext.getCurrentInstance().addMessage("editaEstudianteForm:identificacion", msg);
            return "edita.xhtml";

        }
    }

    public String deleteProfesor() {
        if (ProfesoresGestion.deleteProfesor(this)) {
            return "list.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Ocurrio un error al eliminar el estudiante");
            FacesContext.getCurrentInstance().addMessage("editaEstudianteForm:identificacion", msg);
            return "edita.xhtml";
        }
    }
    
    public String InsertarProfesor() {
        if (ProfesoresGestion.insertProfesor(this)) {
            return "list.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Ocurrio un error al agregar el profesor");
            FacesContext.getCurrentInstance().addMessage("editaEstudianteForm:identificacion", msg);
            return "list.xhtml";
        }
    }
    public void clean(){
        this.setEmail("");
        this.setId_profesor(0);
        this.setIdentificacion("");
        this.setEstado(true);
    }
     public String InsertaProfesor() {
       this.clean();
       return "inserta.xhtml";
    }

}
