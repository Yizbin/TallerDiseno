/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionPresupuestos;

import BO.PresupuestoBO;
import BO.PresupuestoRefaccionBO;
import BO.ServicioPresupuestoBO;
import BO.interfaces.IPresupuestoBO;
import BO.interfaces.IPresupuestoRefaccionBO;
import BO.interfaces.IServicioPresupuestoBO;
import dto.PresupuestoDTO;
import dto.PresupuestoRefaccionDTO;
import dto.ServicioPresupuestoDTO;
import excepciones.EntidadDuplicadaNegocioException;
import excepciones.EntidadNoEncontradaNegocioException;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public class ManejoPresupuestos implements IManejoPresupuestos {

    private static IManejoPresupuestos instancia;
    private final IPresupuestoBO presupuestoBO = PresupuestoBO.getInstancia();
    private final IServicioPresupuestoBO servicioPresupuestoBO = ServicioPresupuestoBO.getInstancia();
    private final IPresupuestoRefaccionBO presupuestoRefaccionBO = PresupuestoRefaccionBO.getInstancia();

    private ManejoPresupuestos() {
    }

    public static IManejoPresupuestos getInstancia() {
        if (instancia == null) {
            instancia = new ManejoPresupuestos();
        }
        return instancia;
    }

    @Override
    public List<PresupuestoDTO> obtenerPresupuestosNoPagados() throws NegocioException {
        return presupuestoBO.buscarPresupuestosNoPagados();
    }

    @Override
    public PresupuestoDTO buscarPresupuestoPorOrden(String idOrden) throws NegocioException {
        return presupuestoBO.buscarPresupuestoPorOrden(idOrden);
    }

    @Override
    public PresupuestoDTO crearPresupuesto(PresupuestoDTO presupuestoDTO) throws EntidadDuplicadaNegocioException, NegocioException {
        return presupuestoBO.crearPresupuesto(presupuestoDTO);
    }

    @Override
    public PresupuestoDTO actualizarPresupuesto(PresupuestoDTO presupuestoDTO) throws EntidadNoEncontradaNegocioException, NegocioException {
        return presupuestoBO.actualizarPresupuesto(presupuestoDTO);
    }

    @Override
    public List<PresupuestoDTO> buscarTodosLosPresupuestos() throws EntidadDuplicadaNegocioException, NegocioException {
        return presupuestoBO.buscarTodosLosPresupuestos();
    }

    @Override
    public PresupuestoDTO buscarPresupuestoPorId(String id) throws EntidadNoEncontradaNegocioException, NegocioException {
        return presupuestoBO.buscarPresupuestoPorId(id);
    }

    @Override
    public List<PresupuestoDTO> buscarPresupuestosNoPagados() throws NegocioException {
        return presupuestoBO.buscarPresupuestosNoPagados();
    }

    @Override
    public List<ServicioPresupuestoDTO> buscarPorIdPresupuesto(String idPresupuesto) throws NegocioException {
        return servicioPresupuestoBO.buscarPorIdPresupuesto(idPresupuesto);
    }

    @Override
    public List<PresupuestoRefaccionDTO> buscarPorIdPresupuestoPR(String idPresupuesto) throws NegocioException {
        return presupuestoRefaccionBO.buscarPorIdPresupuesto(idPresupuesto);
    }

    
}
