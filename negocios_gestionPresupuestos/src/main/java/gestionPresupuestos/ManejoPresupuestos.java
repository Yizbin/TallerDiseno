/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionPresupuestos;

import BO.PresupuestoBO;
import BO.interfaces.IPresupuestoBO;
import dto.PresupuestoDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public class ManejoPresupuestos implements IManejoPresupuestos {

    private static IManejoPresupuestos instancia;
    private final IPresupuestoBO presupuestoBO = PresupuestoBO.getInstancia();

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

}
