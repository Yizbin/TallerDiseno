/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import BO.interfaces.IVentaRefaccionBO;
import DAO.interfaces.IVentaRefaccionDAO;
import dto.VentaRefaccionDTO;
import DAO.VentaRefaccionDAO;
import DAO.RefaccionDAO;
import DAO.interfaces.IRefaccionDAO;
import Excepciones.EntidadDuplicadaException;
import Excepciones.EntidadNoEncontradaException;
import Excepciones.PersistenciaException;
import Mappers.VentaRefaccionMapper;
import Mappers.interfaces.IVentaRefaccionMapper;
import entidades.Refaccion;
import entidades.VentaRefaccion;
import excepciones.EntidadDuplicadaNegocioException;
import excepciones.EntidadNoEncontradaNegocioException;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Pride Factor Black
 */
public class VentaRefaccionBO implements IVentaRefaccionBO{

    private static  IVentaRefaccionBO instancia;
    private final IVentaRefaccionDAO ventaRefaccionDAO = VentaRefaccionDAO.getInstancia();
    private final IRefaccionDAO refaccionDAO = RefaccionDAO.getInstancia();
    private final IVentaRefaccionMapper mapper;

    public VentaRefaccionBO() {
        this.mapper= new VentaRefaccionMapper();
    }

    public static IVentaRefaccionBO getInstancia() {
        if (instancia == null) {
            instancia = new VentaRefaccionBO();
        }
      return instancia;
}
    
    
    @Override
    public VentaRefaccionDTO crearVentaRefaccion(VentaRefaccionDTO dto) throws EntidadDuplicadaNegocioException, NegocioException {
       try {

            Long idRef = Long.valueOf(dto.getId_refaccion());
            Refaccion ref = refaccionDAO.buscarRefaccionPorId(idRef);

            VentaRefaccion entidad = mapper.toEntity(dto, ref);

            VentaRefaccion nueva = ventaRefaccionDAO.crearVentaRefaccion(entidad);

            return mapper.toDTO(nueva);

        } catch (EntidadDuplicadaException e) {
            throw new EntidadDuplicadaNegocioException(e.getMessage());

        } catch (EntidadNoEncontradaException e) {
            throw new NegocioException("No se encontró la refacción: " + e.getMessage());

        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public VentaRefaccionDTO actualizarVentaRefaccion(VentaRefaccionDTO dto) throws EntidadNoEncontradaNegocioException, NegocioException {
         try {
            Long idRef = Long.valueOf(dto.getId_refaccion());
            Refaccion ref = refaccionDAO.buscarRefaccionPorId(idRef);

            VentaRefaccion entidad = mapper.toEntity(dto, ref);

            VentaRefaccion actualizada = ventaRefaccionDAO.actualizarVentaRefaccion(entidad);

            return mapper.toDTO(actualizada);

        } catch (EntidadNoEncontradaException e) {
            throw new EntidadNoEncontradaNegocioException(e.getMessage());

        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public VentaRefaccionDTO buscarVentaRefaccionPorId(String id) throws EntidadNoEncontradaNegocioException, NegocioException {
        try {

            Long idLong = Long.valueOf(id);

            VentaRefaccion entidad =
                    ventaRefaccionDAO.buscarVentaRefaccionPorId(idLong);

            return mapper.toDTO(entidad);

        } catch (EntidadNoEncontradaException e) {
            throw new EntidadNoEncontradaNegocioException(e.getMessage());

        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public List<VentaRefaccionDTO> buscarPorIdVenta(String idVenta) throws NegocioException {
        try {
            Long idLong = Long.valueOf(idVenta);

            List<VentaRefaccion> lista =
                    ventaRefaccionDAO.buscarPorIdVenta(idLong);

            return lista.stream()
                    .map(mapper::toDTO)
                    .toList();

        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    
    }
    
}
