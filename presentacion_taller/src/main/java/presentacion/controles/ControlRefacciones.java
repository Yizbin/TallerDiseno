/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.controles;

import dto.RefaccionDTO;
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
public class ControlRefacciones implements IControlRefacciones{
    
    private final IGestorTaller gestorTaller;

    
    public ControlRefacciones(IGestorTaller gestorTaller) {
        this.gestorTaller = gestorTaller;
    }

    @Override
    public RefaccionDTO crearRefaccion(RefaccionDTO refaccionDTO) {
        try {
            return gestorTaller.crearRefaccion(refaccionDTO);
            
        } catch (NegocioException ex) {
            Logger.getLogger(ControlRefacciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EntidadDuplicadaNegocioException ex) {
            Logger.getLogger(ControlRefacciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public RefaccionDTO actualizarRefaccion(RefaccionDTO refaccionDTO) {
        try {
            return gestorTaller.actualizarRefaccion(refaccionDTO);
        } catch (NegocioException ex) {
            Logger.getLogger(ControlRefacciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EntidadNoEncontradaNegocioException ex) {
            Logger.getLogger(ControlRefacciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<RefaccionDTO> buscarTodasLasRefacciones() {
        try {
            return gestorTaller.buscarTodasLasRefacciones();
        } catch (NegocioException ex) {
            Logger.getLogger(ControlRefacciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EntidadDuplicadaNegocioException ex) {
            Logger.getLogger(ControlRefacciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public RefaccionDTO buscarRefaccionPorId(String id) {
        try {
            return gestorTaller.buscarRefaccionPorId(id);
        } catch (NegocioException ex) {
            Logger.getLogger(ControlRefacciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EntidadNoEncontradaNegocioException ex) {
            Logger.getLogger(ControlRefacciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
}
