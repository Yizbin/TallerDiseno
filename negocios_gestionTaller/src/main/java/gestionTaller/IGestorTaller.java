package gestionTaller;

import dto.ClienteDTO;
import dto.OrdenDTO;
import dto.RespuestaPagoDTO;
import dto.SolicitudPagoDTO;
import dto.VehiculoDTO;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
/**
 *
 * @author Abraham Coronel
 */
public interface IGestorTaller {

    public Boolean crearOrden(OrdenDTO orden);

    public Boolean autenticarUsuario(String usuario, String contrasena);

    public List<ClienteDTO> obtenerClienteMock();

    public List<VehiculoDTO> obtenerVehiculosMock();
    
    public RespuestaPagoDTO procesarPago(SolicitudPagoDTO solicitud);
}
