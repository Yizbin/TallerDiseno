/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import BO.interfaces.IEmpleadoBO;
import DAO.EmpleadoDAO;
import DAO.interfaces.IEmpleadoDAO;
import Mappers.interfaces.IEmpleadoMapper;

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

}
