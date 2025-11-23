/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BO.interfaces;

import Excepciones.EntidadNoEncontradaException;
import Excepciones.PersistenciaException;
import dto.RefaccionDTO;
import excepciones.EntidadDuplicadaNegocioException;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public interface IRefaccionBO {

    public RefaccionDTO crearRefaccion(RefaccionDTO refaccionDTO) throws EntidadDuplicadaNegocioException, NegocioException;

    public RefaccionDTO actualizarRefaccion(RefaccionDTO refaccionDTO) throws EntidadNoEncontradaException, PersistenciaException;

    public List<RefaccionDTO> buscarTodasLasRefacciones() throws EntidadDuplicadaNegocioException, NegocioException;

    public RefaccionDTO buscarRefaccionPorId(Long id) throws EntidadNoEncontradaException, PersistenciaException;

}
