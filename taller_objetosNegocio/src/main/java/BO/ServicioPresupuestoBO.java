/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import BO.interfaces.IServicioPresupuestoBO;
import DAO.ServicioPresupuestoDAO;
import DAO.interfaces.IServicioPresupuestoDAO;
import Excepciones.PersistenciaException;
import Mappers.ServicioPresupuestoMapper;
import dto.ServicioPresupuestoDTO;
import entidades.ServicioPresupuesto;
import excepciones.NegocioException;
import java.util.List;



/**
 *
 * @author Pride Factor Black
 */
public class ServicioPresupuestoBO implements IServicioPresupuestoBO{
    private static IServicioPresupuestoBO instancia;
    private final IServicioPresupuestoDAO dao;
    private final ServicioPresupuestoMapper mapper;

    private ServicioPresupuestoBO() {
        this.dao = ServicioPresupuestoDAO.getInstancia();
        this.mapper = new ServicioPresupuestoMapper();
    }

    public static IServicioPresupuestoBO getInstancia() {
        if (instancia == null) {
            instancia = new ServicioPresupuestoBO();
        }
        return instancia;
    }

    @Override
    public List<ServicioPresupuestoDTO> buscarPorIdPresupuesto(String idPresupuesto) throws NegocioException {
        try {
            Long id = Long.valueOf(idPresupuesto);
            List<ServicioPresupuesto> lista = dao.buscarPorIdPresupuesto(id);
            return mapper.toListDTO(lista);
        } catch (NumberFormatException e) {
            throw new NegocioException("ID de presupuesto inválido.");
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }
}

