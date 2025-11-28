/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestionEmpleados;

import dto.EmpleadoDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public interface IManejoEmpleados {

    public Boolean autenticarUsuario(String usuario, String contrasena) throws NegocioException;
    
    EmpleadoDTO obtenerDatosUsuario(String usuario) throws NegocioException;
    
    List<EmpleadoDTO> buscarTodosLosMecanicosActivos() throws NegocioException;
    
    EmpleadoDTO seleccionarMecanico(String idEmpleado) throws NegocioException;
}
