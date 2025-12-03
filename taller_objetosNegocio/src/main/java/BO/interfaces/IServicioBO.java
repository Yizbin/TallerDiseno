/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BO.interfaces;

import dto.ServicioDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Pride Factor Black
 */
public interface IServicioBO {
   
    public ServicioDTO crearServicio(ServicioDTO dto) throws NegocioException;

    public ServicioDTO actualizarServicio(ServicioDTO dto) throws NegocioException;

    public ServicioDTO eliminarServicio(Long id) throws NegocioException;

    public List<ServicioDTO> obtenerTodos() throws NegocioException;
}
