/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package presentacion.controles;

import dto.ClienteDTO;
import dto.OrdenDTO;
import dto.VehiculoDTO;

public interface IControlOrdenes {

    public void crearOrden(OrdenDTO orden);
    
    public OrdenDTO crearOrdenConCliente(ClienteDTO cliente);
    
    public OrdenDTO crearOrdenConVehiculo(VehiculoDTO vehiculo);
    
}
