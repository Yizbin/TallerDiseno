/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BO.interfaces;

import dto.RefaccionDTO;
import excepciones.EntidadDuplicadaNegocioException;
import excepciones.EntidadNoEncontradaNegocioException;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public interface IRefaccionBO {

    public RefaccionDTO crearRefaccion(RefaccionDTO refaccionDTO) throws EntidadDuplicadaNegocioException, NegocioException;

    public RefaccionDTO actualizarRefaccion(RefaccionDTO refaccionDTO) throws EntidadNoEncontradaNegocioException, NegocioException;

    public List<RefaccionDTO> buscarTodasLasRefacciones() throws EntidadDuplicadaNegocioException, NegocioException;

    public RefaccionDTO buscarRefaccionPorId(String id) throws EntidadNoEncontradaNegocioException, NegocioException;

}
