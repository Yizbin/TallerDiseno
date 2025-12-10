/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.controles;

import dto.VentaDTO;
import dto.VentaRefaccionDTO;
import excepciones.EntidadDuplicadaNegocioException;
import excepciones.EntidadNoEncontradaNegocioException;
import excepciones.NegocioException;
import gestionTaller.IGestorTaller;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pride Factor Black
 */
public class ControlVentas implements IControlVentas{
 
    private final IGestorTaller taller;

    public ControlVentas(IGestorTaller taller) {
        this.taller = taller;
    }
    
    
    @Override
    public VentaDTO crearVenta(List<VentaRefaccionDTO> detalles) {
        try {
            return taller.crearVenta(detalles);
        } catch (NegocioException ex) {
            Logger.getLogger(ControlVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public VentaDTO buscarVentaPorId(Long id) {
        try {
            return taller.buscarVentaPorId(id);
        } catch (NegocioException ex) {
            Logger.getLogger(ControlVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<VentaDTO> buscarTodasLasVentas() {
        try {
            return taller.buscarTodasLasVentas();
        } catch (NegocioException ex) {
            Logger.getLogger(ControlVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public VentaRefaccionDTO crearVentaRefaccion(VentaRefaccionDTO dto) {
        try {
            return taller.crearVentaRefaccion(dto);
        } catch (EntidadDuplicadaNegocioException ex) {
            Logger.getLogger(ControlVentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NegocioException ex) {
            Logger.getLogger(ControlVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public VentaRefaccionDTO actualizarVentaRefaccion(VentaRefaccionDTO dto) {
        try {
            taller.actualizarVentaRefaccion(dto);
        } catch (EntidadNoEncontradaNegocioException ex) {
            Logger.getLogger(ControlVentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NegocioException ex) {
            Logger.getLogger(ControlVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public VentaRefaccionDTO buscarVentaRefaccionPorId(String id) {
        try {
            return taller.buscarVentaRefaccionPorId(id);
        } catch (EntidadNoEncontradaNegocioException ex) {
            Logger.getLogger(ControlVentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NegocioException ex) {
            Logger.getLogger(ControlVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<VentaRefaccionDTO> buscarPorIdVenta(String idVenta) {
        
        try {
            return taller.buscarPorIdVenta(idVenta);
        } catch (NegocioException ex) {
            Logger.getLogger(ControlVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
