/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package presentacion.controles;

import dto.OrdenDTO;

/**
 *
 * @author Abraham Coronel
 */
public interface IControlNavegacion {

    public void mostrarMenuPrincipal();

    public void mostrarDatosCliente();

    public void mostrarDatosVehiculo(OrdenDTO orden);

    public void mostrarDatosOrden(OrdenDTO orden);

    public void mostrarClientesRegistrados();
}
