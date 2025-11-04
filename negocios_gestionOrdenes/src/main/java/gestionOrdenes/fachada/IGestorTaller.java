/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package gestionOrdenes.fachada;

import dto.ClienteDTO;
import dto.OrdenDTO;
import dto.VehiculoDTO;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public interface IGestorTaller {
    public Boolean crearOrden(OrdenDTO orden);
    public Boolean autenticarUsuario(String usuario, String contrasena);
    
    public List<ClienteDTO> obtenerClienteMock();
    
    public List<VehiculoDTO> obtenerVehiculosMock();
}
