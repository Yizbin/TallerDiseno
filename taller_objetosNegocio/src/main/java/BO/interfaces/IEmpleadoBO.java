/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BO.interfaces;

import dto.EmpleadoDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public interface IEmpleadoBO {

    public Boolean autenticarEmpleado(String usuario, String contrasena) throws NegocioException;

    public EmpleadoDTO obtenerEmpleadoPorUsuario(String usuario) throws NegocioException;

    List<EmpleadoDTO> obtenerMecanicosParaTabla() throws NegocioException;

    public EmpleadoDTO actualizarEstadoEmpleado(String idEmpleado, Boolean activo) throws NegocioException;

    EmpleadoDTO buscarPorId(String idEmpleado) throws NegocioException;

}
