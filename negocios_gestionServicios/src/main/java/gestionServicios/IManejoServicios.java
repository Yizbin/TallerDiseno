/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestionServicios;

import dto.ServicioDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Pride Factor Black
 */
public interface IManejoServicios {
    public ServicioDTO crearServicio(ServicioDTO servicio) throws NegocioException;

    public ServicioDTO actualizarServicio(ServicioDTO servicio) throws NegocioException;

    public ServicioDTO eliminarServicio(String id) throws NegocioException;

    public List<ServicioDTO> obtenerTodos() throws NegocioException;
}
