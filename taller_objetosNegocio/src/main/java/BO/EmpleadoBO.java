/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import BO.interfaces.IEmpleadoBO;
import DAO.EmpleadoDAO;
import DAO.interfaces.IEmpleadoDAO;
import Excepciones.EntidadNoEncontradaException;
import Excepciones.PersistenciaException;
import Mappers.interfaces.IEmpleadoMapper;
import excepciones.NegocioException;

/**
 *
 * @author Abraham Coronel
 */
public class EmpleadoBO implements IEmpleadoBO {

    private static IEmpleadoBO instancia;
    private final IEmpleadoDAO empleadoDAO = EmpleadoDAO.getInstancia();
    private IEmpleadoMapper mapper;

    private EmpleadoBO() {
    }

    public static IEmpleadoBO getInstancia() {
        if (instancia == null) {
            instancia = new EmpleadoBO();
        }
        return instancia;
    }

    @Override
    public Boolean autenticarEmpleado(String usuario, String contrasena) throws NegocioException {
        try {
            empleadoDAO.autenticarEmpleado(usuario, contrasena);
            return true;
        } catch (EntidadNoEncontradaException e) {
            return false;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error a la hora de autenticar: " + e.getMessage());
        }
    }

}
