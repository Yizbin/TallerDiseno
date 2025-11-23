/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import BO.interfaces.IRefaccionBO;
import DAO.RefaccionDAO;
import DAO.interfaces.IRefaccionDAO;
import Excepciones.EntidadNoEncontradaException;
import Excepciones.PersistenciaException;
import Mappers.RefaccionMapper;
import Mappers.interfaces.IRefaccionMapper;
import dto.RefaccionDTO;
import excepciones.EntidadDuplicadaNegocioException;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public class RefaccionBO implements IRefaccionBO {

    private static IRefaccionBO instancia;
    private final IRefaccionDAO refaccionDAO = RefaccionDAO.getInstancia();
    private final IRefaccionMapper refaccionMapper;

    private RefaccionBO() {
        this.refaccionMapper = new RefaccionMapper();
    }

    public static IRefaccionBO getInstancia() {
        if (instancia == null) {
            instancia = new RefaccionBO();
        }
        return instancia;
    }

    @Override
    public RefaccionDTO crearRefaccion(RefaccionDTO refaccionDTO) throws EntidadDuplicadaNegocioException, NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public RefaccionDTO actualizarRefaccion(RefaccionDTO refaccionDTO) throws EntidadNoEncontradaException, PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<RefaccionDTO> buscarTodasLasRefacciones() throws EntidadDuplicadaNegocioException, NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public RefaccionDTO buscarRefaccionPorId(Long id) throws EntidadNoEncontradaException, PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



}
