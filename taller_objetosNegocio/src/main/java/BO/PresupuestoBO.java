/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import BO.interfaces.IPresupuestoBO;
import DAO.interfaces.IPresupuestoDAO;
import Mappers.interfaces.IPresupuestoMapper;

/**
 *
 * @author Abraham Coronel
 */
public class PresupuestoBO implements IPresupuestoBO {

    private final IPresupuestoDAO presupuestoDAO;
    private final IPresupuestoMapper mapper;

    public PresupuestoBO(IPresupuestoDAO presupuestoDAO, IPresupuestoMapper mapper) {
        this.presupuestoDAO = presupuestoDAO;
        this.mapper = mapper;
    }

}
