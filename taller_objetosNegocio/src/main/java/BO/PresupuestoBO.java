/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import BO.interfaces.IPresupuestoBO;
import DAO.PresupuestoDAO;
import DAO.interfaces.IPresupuestoDAO;
import Excepciones.PersistenciaException;
import Mappers.PresupuestoMapper;
import Mappers.interfaces.IPresupuestoMapper;
import dto.PresupuestoDTO;
import entidades.Presupuesto;
import excepciones.EntidadDuplicadaNegocioException;
import excepciones.EntidadNoEncontradaNegocioException;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public class PresupuestoBO implements IPresupuestoBO {

    private static IPresupuestoBO instancia;
    private final IPresupuestoDAO presupuestoDAO = PresupuestoDAO.getInstancia();
    private final IPresupuestoMapper mapper;

    private PresupuestoBO() {
        this.mapper = new PresupuestoMapper();
    }

    public static IPresupuestoBO getInstancia() {
        if (instancia == null) {
            instancia = new PresupuestoBO();
        }
        return instancia;
    }

    @Override
    public PresupuestoDTO crearPresupuesto(PresupuestoDTO presupuestoDTO) throws EntidadDuplicadaNegocioException, NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PresupuestoDTO actualizarPresupuesto(PresupuestoDTO presupuestoDTO) throws EntidadNoEncontradaNegocioException, NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<PresupuestoDTO> buscarTodosLosPresupuestos() throws EntidadDuplicadaNegocioException, NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PresupuestoDTO buscarPresupuestoPorId(String id) throws EntidadNoEncontradaNegocioException, NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<PresupuestoDTO> buscarPresupuestosNoPagados() throws NegocioException {
        try {
            List<Presupuesto> entidades = presupuestoDAO.buscarPresupuestoNoPagados();
            return mapper.toListDTO(entidades);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error recuperando presupuestos pendientes: " + e.getMessage());
        }
    }

}
