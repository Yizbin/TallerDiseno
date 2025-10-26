/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package presentacion;

import dto.OrdenDTO;

public interface IControlOrdenes {

    public void crearOrden(OrdenDTO orden);
    
    public Boolean autenticarUsuario(String usuario, String contrasena);

    // METODOS DE NAVEGACION DE PANTALLAS
    public void mostrarMenuPrincipal();

    public void mostrarDatosCliente();
    
    public void mostrarDatosVehiculo(OrdenDTO orden);

    public void mostrarDatosOrden(OrdenDTO orden);
}
