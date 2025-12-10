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
    private IVentaDAO ventaDAO;
    private final IVentaMapper mapper;

    private VentaBO() {
        this.mapper = new VentaMapper();
        this.ventaDAO = VentaDAO.getInstancia();
    }

    public static IVentaBO getInstancia() {
        if (instancia==null) {
           instancia = new VentaBO();
        }
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
            
            // Calculamos el total
            double total = detalles.stream()
                    .mapToDouble(vr -> vr.getPrecioUnitario() * vr.getCantidad())
                    .sum();
            dto.setTotal(total);
            
            // Asignamos los detalles al DTO
            dto.setRefacciones(detalles);

            // 1. Convertimos a Entidad (Aquí se crea la Venta y la lista de VentaRefaccion)
            Venta entidad = mapper.toEntity(dto);

            // =================================================================
            // CORRECCIÓN CLAVE: VINCULACIÓN BIDIRECCIONAL
            // =================================================================
            // Recorremos los detalles para decirles: "Esta es su venta padre"
            if (entidad.getRefacciones() != null) {
                for (var detalle : entidad.getRefacciones()) {
                    // Esto llena el campo 'id_venta' en la base de datos
                    detalle.setVenta(entidad); 
                }
            }
            // =================================================================

            // 2. Ahora sí, al guardar, JPA sabe que esos hijos pertenecen a esta venta
            // Asegúrate de que tu VentaDAO tenga CascadeType.ALL configurado en JPA
            // o que guarde la venta y luego los detalles.
            Venta nueva = ventaDAO.crearVenta(entidad);

            return mapper.toDTO(nueva);

        } catch (Exception e) {
            e.printStackTrace(); // Agrega esto para ver errores en consola
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
