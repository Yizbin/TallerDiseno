/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionOrdenes;

import BO.OrdenBO;
import BO.interfaces.IOrdenBO;
import Excepciones.DatosFaltantesEnOrdenException;
import Excepciones.FechaInvalidaException;
import Excepciones.OrdenNoEncontradaException;
import dto.OrdenDTO;
import excepciones.NegocioException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public class ManejoOrdenes implements IManejoOrdenes {

    private static IManejoOrdenes instancia;
    private final IOrdenBO ordenes = OrdenBO.getInstancia();

    private ManejoOrdenes() {
    }

    public static IManejoOrdenes getInstancia() {
        if (instancia == null) {
            instancia = new ManejoOrdenes();
        }
        return instancia;
    }

    @Override
    public void crearOrden(OrdenDTO orden) throws DatosFaltantesEnOrdenException, FechaInvalidaException, NegocioException {
        if (orden == null) {
            throw new DatosFaltantesEnOrdenException("La orden (DTO) no puede ser nula.");
        }

        if (orden.getCliente() == null) {
            throw new DatosFaltantesEnOrdenException("El cliente de la orden es obligatorio.");
        }

        if (orden.getVehiculo() == null) {
            throw new DatosFaltantesEnOrdenException("El vehículo de la orden es obligatorio.");
        }

        if (orden.getFallaReportada() == null || orden.getFallaReportada().trim().isEmpty()) {
            throw new DatosFaltantesEnOrdenException("La falla reportada es obligatoria.");
        }

        if (orden.getServicioSolicitado() == null || orden.getServicioSolicitado().trim().isEmpty()) {
            throw new DatosFaltantesEnOrdenException("El servicio solicitado es obligatorio.");
        }

        if (orden.getFechaIngreso() == null) {
            throw new FechaInvalidaException("La fecha de ingreso de la orden es obligatoria.");
        }

        if (orden.getFechaIngreso().isBefore(LocalDate.now())) {
            throw new FechaInvalidaException("La fecha de ingreso no puede ser en el pasado.");
        }

        ordenes.crearOrden(orden);

    }

    @Override
    public OrdenDTO actualizarOrden(OrdenDTO orden) throws DatosFaltantesEnOrdenException, FechaInvalidaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarOrden(String id) throws OrdenNoEncontradaException, DatosFaltantesEnOrdenException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<OrdenDTO> buscarOrdenPorId(String id) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<OrdenDTO> buscarTodasLasOrdenes(String id) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<OrdenDTO> buscarTodasLasOrdenesPendientes(String id) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
