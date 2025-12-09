/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionVentas;

import BO.VentaBO;
import BO.VentaRefaccionBO;
import BO.interfaces.IVentaBO;
import BO.interfaces.IVentaRefaccionBO;
import dto.VentaDTO;
import dto.VentaRefaccionDTO;
import excepciones.EntidadDuplicadaNegocioException;
import excepciones.EntidadNoEncontradaNegocioException;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Pride Factor Black
 */
public class ManejoVentas implements IManejoVentas{
    
    private static IManejoVentas instancia;
    private final IVentaBO ventaBO = VentaBO.getInstancia();
    private final IVentaRefaccionBO ventaRefaccionBO = VentaRefaccionBO.getInstancia();

    public ManejoVentas() {
    }

    public static IManejoVentas getInstacia() {
        if (instancia==null) {
            instancia = new ManejoVentas();
        }
        return instancia;
    }

    @Override
    public VentaDTO crearVenta(List<VentaRefaccionDTO> detalles) throws NegocioException {
        return ventaBO.crearVenta(detalles);
    }

    @Override
    public VentaDTO buscarVentaPorId(Long id) throws NegocioException {
        return ventaBO.buscarVentaPorId(id);
    }

    @Override
    public List<VentaDTO> buscarTodasLasVentas() throws NegocioException {
        return ventaBO.buscarTodasLasVentas();
    }
  
    //Venta refaccion

    @Override
    public VentaRefaccionDTO crearVentaRefaccion(VentaRefaccionDTO dto) throws EntidadDuplicadaNegocioException, NegocioException {
        return ventaRefaccionBO.crearVentaRefaccion(dto);
    }

    @Override
    public VentaRefaccionDTO actualizarVentaRefaccion(VentaRefaccionDTO dto) throws EntidadNoEncontradaNegocioException, NegocioException {
        return ventaRefaccionBO.actualizarVentaRefaccion(dto);
    }

    @Override
    public VentaRefaccionDTO buscarVentaRefaccionPorId(String id) throws EntidadNoEncontradaNegocioException, NegocioException {
        return ventaRefaccionBO.buscarVentaRefaccionPorId(id);
    }

    @Override
    public List<VentaRefaccionDTO> buscarPorIdVenta(String idVenta) throws NegocioException {
        return ventaRefaccionBO.buscarPorIdVenta(idVenta);
    }
}
