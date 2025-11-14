/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Abraham Coronel
 */
@Entity
@Table(name = "Empleado")
public class Empleado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_empleado;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidoP")
    private String apellidoP;

    @Column(name = "apellidoM")
    private String apellidoM;

    @Column(name = "rol")
    private String rol;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "contrasenia")
    private String contrasenia;

    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Tarea> tareas;

    public Empleado() {
    }

    public Empleado(Long id, String nombre, String apellidoP, String apellidoM, String rol, String usuario, String contrasenia, List<Tarea> tareas) {
        this.id_empleado = id;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.rol = rol;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.tareas = tareas;
    }

    public Empleado(String nombre, String apellidoP, String apellidoM, String rol, String usuario, String contrasenia, List<Tarea> tareas) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.rol = rol;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.tareas = tareas;
    }

    public Long getId() {
        return id_empleado;
    }

    public void setId(Long id) {
        this.id_empleado = id;
    }

    public Long getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(Long id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }

}
