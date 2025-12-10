/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import BO.interfaces.IPagoBO;
import DAO.PagoDAO;
import DAO.interfaces.IPagoDAO;
import Excepciones.PersistenciaException;
import Mappers.PagoMapper;
import Mappers.interfaces.IPagoMapper;
import dto.PagoDTO;
import entidades.Pago;
import excepciones.NegocioException;

/**
 *
 * @author Abraham Coronel
 */
public class PagoBO implements IPagoBO {

    private static IPagoBO instancia;
    private final IPagoDAO pagoDAO = PagoDAO.getInstancia();
    private final IPagoMapper pagoMapper = new PagoMapper();

    private PagoBO() {
    }

    public static IPagoBO getInstancia() {
        if (instancia == null) {
            instancia = new PagoBO();
        }
        return instancia;
    }

    @Override
    public PagoDTO registrarPago(PagoDTO pago) throws NegocioException {
        // Redirigimos a guardarPago para centralizar las validaciones
        return guardarPago(pago);
    }

    @Override
   public PagoDTO guardarPago(PagoDTO pagoDTO) throws NegocioException {
        try {
            if (pagoDTO == null) {
                throw new NegocioException("La información del pago no puede ser nula.");
            }
            if (pagoDTO.getMonto() == null || pagoDTO.getMonto() <= 0) {
                throw new NegocioException("El monto del pago debe ser mayor a 0.");
            }

            Pago pagoEntidad = pagoMapper.toEntity(pagoDTO);

            boolean tieneVenta = pagoEntidad.getVenta() != null && pagoEntidad.getVenta().getId() != null;
            boolean tienePresupuesto = pagoEntidad.getPresupuesto() != null && pagoEntidad.getPresupuesto().getId() != null;
            boolean esVentaRefaccionesEnProceso = pagoDTO.getIdPresupuesto() != null && pagoDTO.getIdPresupuesto().startsWith("ORD-");

            if (!tieneVenta && !tienePresupuesto && !esVentaRefaccionesEnProceso) {
                throw new NegocioException("El pago debe estar asociado a una Venta o a un Presupuesto existente.");
            }
            
            if (tieneVenta && tienePresupuesto) {
                pagoEntidad.setPresupuesto(null); 
            }

            Pago pagoGuardado = pagoDAO.guardarPago(pagoEntidad);

            return pagoMapper.toDTO(pagoGuardado);

        } catch (Exception e) {
            e.printStackTrace(); 
            throw new NegocioException("Error inesperado al guardar el pago: " + e.getMessage());
        }
    }
}
