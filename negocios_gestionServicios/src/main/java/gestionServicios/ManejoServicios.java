/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionServicios;

import BO.ServicioBO;
import BO.interfaces.IServicioBO;
import dto.ServicioDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Pride Factor Black este es
 */
public class ManejoServicios implements IManejoServicios{
    
    private static IManejoServicios instancia;
    private final IServicioBO servicioBO = ServicioBO.getInstancia();

    public ManejoServicios() {
    }

    public static IManejoServicios getInstancia() {
        if (instancia==null) {
            instancia = new ManejoServicios();
        }
        return instancia;
    }

    @Override
    public ServicioDTO crearServicio(ServicioDTO dto) throws NegocioException {
        return servicioBO.crearServicio(dto);
    }

    @Override
    public ServicioDTO actualizarServicio(ServicioDTO dto) throws NegocioException {
        return servicioBO.actualizarServicio(dto);
    }

    @Override
    public ServicioDTO eliminarServicio(String id) throws NegocioException {
        return servicioBO.eliminarServicio(Long.MIN_VALUE);
    }

    @Override
    public List<ServicioDTO> obtenerTodos() throws NegocioException {
        return servicioBO.obtenerTodos();
    }
}
