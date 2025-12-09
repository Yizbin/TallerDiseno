/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import BO.interfaces.IVentaBO;
import DAO.VentaDAO;
import DAO.interfaces.IVentaDAO;
import Mappers.VentaMapper;
import Mappers.interfaces.IVentaMapper;
import dto.VentaDTO;
import dto.VentaRefaccionDTO;
import entidades.Venta;
import excepciones.NegocioException;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Pride Factor Black
 */
public class VentaBO implements IVentaBO{

    private static IVentaBO instancia;
    private final IVentaDAO ventaDAO = VentaDAO.getInstancia();
    private final IVentaMapper mapper;

    public VentaBO() {
        this.mapper = new VentaMapper();
    }

    public static IVentaBO getInstancia() {
        return instancia;
    }
     
 
    @Override
     public VentaDTO crearVenta(List<VentaRefaccionDTO> detalles) throws NegocioException {
        try {
            if (detalles == null || detalles.isEmpty()) {
                throw new NegocioException("La venta debe incluir al menos una refacción.");
            }

            VentaDTO dto = new VentaDTO();
            dto.setFecha(LocalDateTime.now());
            dto.setRefacciones(detalles);

            double total = detalles.stream()
                    .mapToDouble(vr -> vr.getPrecioUnitario() * vr.getCantidad())
                    .sum();

            dto.setTotal(total);

            Venta entidad = mapper.toEntity(dto);

            Venta nueva = ventaDAO.crearVenta(entidad);

            return mapper.toDTO(nueva);

        } catch (Exception e) {
            throw new NegocioException("Error al crear la venta: " + e.getMessage());
        }
   
    }

    @Override
    public VentaDTO buscarVentaPorId(Long id) throws NegocioException {
        try {
            Venta venta = ventaDAO.buscarVentaPorId(id);
            return mapper.toDTO(venta);

        } catch (Exception e) {
            throw new NegocioException("Error al buscar la venta: " + e.getMessage());
        }
    }


    @Override
   public List<VentaDTO> buscarTodasLasVentas() throws NegocioException {
        try {
            List<Venta> lista = ventaDAO.buscarTodasLasVentas();
            return lista.stream()
                    .map(mapper::toDTO)
                    .toList();

        } catch (Exception e) {
            throw new NegocioException("Error al obtener las ventas: " + e.getMessage());
        }
    }
    
    
}
