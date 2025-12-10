/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import BO.interfaces.IPresupuestoRefaccionBO;
import DAO.PresupuestoRefaccionDAO;
import DAO.interfaces.IPresupuestoRefaccionDAO;
import Excepciones.PersistenciaException;
import Mappers.PresupuestoRefaccionMapper;
import dto.PresupuestoRefaccionDTO;
import entidades.PresupuestoRefaccion;
import excepciones.NegocioException;
import java.util.List;


/**
 *
 * @author Pride Factor Black
 */
public class PresupuestoRefaccionBO implements IPresupuestoRefaccionBO{
    private static IPresupuestoRefaccionBO instancia;
    private final IPresupuestoRefaccionDAO dao;
    private final PresupuestoRefaccionMapper mapper;

    private PresupuestoRefaccionBO() {
        this.dao = PresupuestoRefaccionDAO.getInstancia();
        this.mapper = new PresupuestoRefaccionMapper();
    }

    public static IPresupuestoRefaccionBO getInstancia() {
        if (instancia == null) {
            instancia = new PresupuestoRefaccionBO();
        }
        return instancia;
    }

    @Override
    public List<PresupuestoRefaccionDTO> buscarPorIdPresupuesto(String idPresupuesto) throws NegocioException {
        try {
            Long id = Long.valueOf(idPresupuesto);
            List<PresupuestoRefaccion> lista = dao.buscarPorIdPresupuesto(id);
            return mapper.toListDTO(lista);
        } catch (NumberFormatException e) {
            throw new NegocioException("ID de presupuesto inválido.");
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }
}
