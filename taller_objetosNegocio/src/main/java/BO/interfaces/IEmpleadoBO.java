/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package BO.interfaces;

import dto.EmpleadoDTO;
import excepciones.NegocioException;

/**
 *
 * @author Abraham Coronel
 */
public interface IEmpleadoBO {
    public Boolean autenticarEmpleado(String usuario, String contrasena) throws NegocioException;
    
    public EmpleadoDTO obtenerEmpleadoPorUsuario(String usuario) throws NegocioException;
}
