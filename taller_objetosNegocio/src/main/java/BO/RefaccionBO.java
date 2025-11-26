/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import BO.interfaces.IRefaccionBO;
import DAO.RefaccionDAO;
import DAO.interfaces.IRefaccionDAO;
import Excepciones.EntidadDuplicadaException;
import Excepciones.EntidadNoEncontradaException;
import Excepciones.PersistenciaException;
import Mappers.RefaccionMapper;
import Mappers.interfaces.IRefaccionMapper;
import dto.RefaccionDTO;
import entidades.Refaccion;
import excepciones.EntidadDuplicadaNegocioException;
import excepciones.EntidadNoEncontradaNegocioException;
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
        try {
            Refaccion refaccionEntidad = this.refaccionMapper.toEntity(refaccionDTO);

            Refaccion refaccionNueva = this.refaccionDAO.crearRefaccion(refaccionEntidad);

            return this.refaccionMapper.toDTO(refaccionNueva);

        } catch (EntidadDuplicadaException e) {
            throw new EntidadDuplicadaNegocioException(e.getMessage());
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public RefaccionDTO actualizarRefaccion(RefaccionDTO refaccionDTO) throws EntidadNoEncontradaNegocioException, NegocioException {
        try {
            Refaccion refaccionEntidad = this.refaccionMapper.toEntity(refaccionDTO);

            Refaccion refaccionActualizada = this.refaccionDAO.actualizarRefaccion(refaccionEntidad);

            return this.refaccionMapper.toDTO(refaccionActualizada);

        } catch (EntidadNoEncontradaException e) {
            throw new EntidadNoEncontradaNegocioException(e.getMessage());
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public List<RefaccionDTO> buscarTodasLasRefacciones() throws EntidadDuplicadaNegocioException, NegocioException {
        try {

            List<Refaccion> lista = this.refaccionDAO.buscarTodasLasRefacciones();
            return this.refaccionMapper.toListDTO(lista);

        } catch (EntidadDuplicadaException e) {
            throw new EntidadDuplicadaNegocioException(e.getMessage());

        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public RefaccionDTO buscarRefaccionPorId(String id) throws EntidadNoEncontradaNegocioException, NegocioException {
        try {
            Long idLong = Long.valueOf(id);

            Refaccion ref = this.refaccionDAO.buscarRefaccionPorId(idLong);

            return this.refaccionMapper.toDTO(ref);

        } catch (EntidadNoEncontradaException e) {
            throw new EntidadNoEncontradaNegocioException(e.getMessage());
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

}
