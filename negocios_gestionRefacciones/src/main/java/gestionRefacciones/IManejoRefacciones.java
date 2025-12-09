/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestionRefacciones;


import dto.RefaccionDTO;
import excepciones.EntidadDuplicadaNegocioException;
import excepciones.EntidadNoEncontradaNegocioException;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Pride Factor Black
 */
public interface IManejoRefacciones {
    
    public RefaccionDTO crearRefaccion(RefaccionDTO refaccionDTO) throws NegocioException, EntidadDuplicadaNegocioException;
    
    public RefaccionDTO actualizarRefaccion(RefaccionDTO refaccionDTO) throws NegocioException, EntidadNoEncontradaNegocioException;
    
    public List<RefaccionDTO> buscarTodasLasRefacciones() throws NegocioException,EntidadDuplicadaNegocioException;
    
    public RefaccionDTO buscarRefaccionPorId(String id) throws NegocioException,  EntidadNoEncontradaNegocioException;
}
