/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.controles;

import BO.PresupuestoBO;
import BO.interfaces.IPresupuestoBO;
import dto.ClienteDTO;
import dto.PresupuestoDTO;
import dto.PresupuestoRefaccionDTO;
import dto.ServicioPresupuestoDTO;
import excepciones.EntidadDuplicadaNegocioException;
import excepciones.EntidadNoEncontradaNegocioException;
import excepciones.NegocioException;
import gestionTaller.IGestorTaller;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Abraham Coronel
 */
public class ControlPresupuestos implements IControlPresupuestos {

    private final IGestorTaller taller;

    public ControlPresupuestos(IGestorTaller taller) {
        this.taller = taller;
    }

    @Override
    public PresupuestoDTO crearPresupuesto(PresupuestoDTO presupuesto) {
       try {
            PresupuestoDTO nuevo = taller.crearPresupuesto(presupuesto);

            if (nuevo != null && presupuesto.getRefacciones() != null) {
                descontarStock(presupuesto.getRefacciones());
            }
            return nuevo;

        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(null, "Error al crear presupuesto: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error inesperado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    @Override
    public PresupuestoDTO buscarPresupuestoPorOrden(String idOrden) {
        try {
            return taller.buscarPresupuestoPorOrden(idOrden);
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<PresupuestoDTO> buscarPresupuestosPendientes() {
        try {
            return taller.buscarPresupuestosPendientes();
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public PresupuestoDTO crearPresupuestoConCliente(ClienteDTO cliente) {
        try {
        
        PresupuestoDTO presupuesto = new PresupuestoDTO();
        presupuesto.setCliente(cliente);
        
        
       
        IPresupuestoBO bo = PresupuestoBO.getInstancia();
        return taller.crearPresupuesto(presupuesto);
    } catch (Exception ex) {
        
        JOptionPane.showMessageDialog(null,
                "Error inesperado al crear presupuesto: " + ex.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        return null;
    }
  }

    @Override
    public PresupuestoDTO actualizarPresupuesto(PresupuestoDTO presupuestoDTO) {
        try {
            return taller.actualizarPresupuesto(presupuestoDTO);
        } catch (EntidadNoEncontradaNegocioException ex) {
            Logger.getLogger(ControlPresupuestos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NegocioException ex) {
            Logger.getLogger(ControlPresupuestos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<PresupuestoDTO> buscarTodosLosPresupuestos() {
        try {
            return taller.buscarTodosLosPresupuestos();
        } catch (EntidadDuplicadaNegocioException ex) {
            Logger.getLogger(ControlPresupuestos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NegocioException ex) {
            Logger.getLogger(ControlPresupuestos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public PresupuestoDTO buscarPresupuestoPorId(String id) {
        try {
            return taller.buscarPresupuestoPorId(id);
        } catch (EntidadNoEncontradaNegocioException ex) {
            Logger.getLogger(ControlPresupuestos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NegocioException ex) {
            Logger.getLogger(ControlPresupuestos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<PresupuestoDTO> buscarPresupuestosNoPagados() {
        try {
            return taller.buscarPresupuestosNoPagados();
        } catch (NegocioException ex) {
            Logger.getLogger(ControlPresupuestos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<ServicioPresupuestoDTO> buscarPorIdPresupuesto(String idPresupuesto) throws NegocioException {
        return taller.buscarPorIdPresupuesto(idPresupuesto);
    }

    @Override
    public List<PresupuestoRefaccionDTO> buscarPorIdPresupuestoPR(String idPresupuesto) throws NegocioException {
       return taller.buscarPorIdPresupuestoPR(idPresupuesto);
    }
    
    private void descontarStock(List<PresupuestoRefaccionDTO> items) {
        if (items == null) return; 

        for (PresupuestoRefaccionDTO item : items) {
            try {
                String idRef = item.getIdRefaccion();

                dto.RefaccionDTO refEnBD = taller.buscarRefaccionPorId(idRef);

                if (refEnBD != null) {
                    int stockActual = refEnBD.getStock();
                    int cantidadUsada = item.getCantidad();

                    // 3. Calcular el nuevo stock (evitando números negativos)
                    int nuevoStock = stockActual - cantidadUsada;
                    if (nuevoStock < 0) nuevoStock = 0;
                        refEnBD.setStock(nuevoStock);
                        taller.actualizarRefaccion(refEnBD);
                    }
            } catch (Exception ex) {
                System.err.println("Error descontando stock de la refacción ID " + item.getIdRefaccion() + ": " + ex.getMessage());
            }
        }
    }
}
