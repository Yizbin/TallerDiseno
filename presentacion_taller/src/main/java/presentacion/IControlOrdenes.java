/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package presentacion;

import dto.OrdenDTO;

public interface IControlOrdenes {

    public void crear0rden(OrdenDTO orden);

    // METODOS DE NAVEGACION DE PANTALLAS
    public void mostrarMenuPrincipal();

    public void mostrarDatosCliente();
    
    public void mostrarDatosVehiculo(OrdenDTO orden);

    public void mostrarDatosOrden(OrdenDTO orden);
}
