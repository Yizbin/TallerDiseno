/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package presentacion.controles;

import dto.EmpleadoDTO;

/**
 *
 * @author Abraham Coronel
 */
public interface IControlAutenticacion {

    public Boolean autenticarUsuario(String usuario, String contrasena);
    
    public EmpleadoDTO obtenerDatosEmpleado(String usuario);
}
