/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionRefacciones;

import BO.RefaccionBO;
import BO.interfaces.IRefaccionBO;
import dto.RefaccionDTO;
import excepciones.EntidadDuplicadaNegocioException;
import excepciones.EntidadNoEncontradaNegocioException;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Pride Factor Black
 */
public class ManejoRefacciones implements IManejoRefacciones{
   
    private static IManejoRefacciones instancia;
    private final IRefaccionBO refaccionBO = RefaccionBO.getInstancia();

    public ManejoRefacciones() {
    }

    public static IManejoRefacciones getInstancia() {
        if (instancia==null) {
            instancia = new ManejoRefacciones();
        }
        return instancia;
    }

    @Override
    public RefaccionDTO crearRefaccion(RefaccionDTO refaccionDTO) throws NegocioException, EntidadDuplicadaNegocioException {
       return refaccionBO.crearRefaccion(refaccionDTO);
    }

    @Override
    public RefaccionDTO actualizarRefaccion(RefaccionDTO refaccionDTO) throws NegocioException, EntidadNoEncontradaNegocioException{
        return refaccionBO.actualizarRefaccion(refaccionDTO);
    }

    @Override
    public List<RefaccionDTO> buscarTodasLasRefacciones() throws NegocioException, EntidadDuplicadaNegocioException {
        return refaccionBO.buscarTodasLasRefacciones();
    }

    @Override
    public RefaccionDTO buscarRefaccionPorId(String id) throws NegocioException,  EntidadNoEncontradaNegocioException {
       return refaccionBO.buscarRefaccionPorId(id);
    }
    
    
}
