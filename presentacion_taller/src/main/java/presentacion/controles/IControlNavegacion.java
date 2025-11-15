/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package presentacion.controles;

import dto.OrdenDTO;
import dto.enums.NavegacionOrigen;

/**
 *
 * @author Abraham Coronel
 */
public interface IControlNavegacion {

    public void mostrarMenuPrincipal();

    public void mostrarDatosCliente();

    public void mostrarDatosVehiculo(OrdenDTO orden, NavegacionOrigen origen);

    public void mostrarDatosOrden(OrdenDTO orden, NavegacionOrigen origenPantalla, NavegacionOrigen origenCliente);

    public void mostrarClientesRegistrados();
    
    public void mostrarVehiculosRegistrados(OrdenDTO orden, NavegacionOrigen origen);
    
    public void regresarDatosOrden(NavegacionOrigen origen, OrdenDTO orden, NavegacionOrigen origenCliente);
    
    public void regresarVehiculosRegistrados(NavegacionOrigen origen);
    
    public void mostrarOrdenesPendientes();
    
    public void mostrarTareasMecanico();
    
}
