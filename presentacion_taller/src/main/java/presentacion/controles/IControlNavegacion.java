/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package presentacion.controles;

import dto.OrdenDTO;
import presentacion.enums.NavegacionOrigen;

/**
 *
 * @author Abraham Coronel
 */
public interface IControlNavegacion {

    public void mostrarMenuPrincipal();

    public void mostrarDatosCliente();

    public void mostrarDatosVehiculo(OrdenDTO orden, NavegacionOrigen origen);

    public void mostrarDatosOrden(OrdenDTO orden, NavegacionOrigen origen);

    public void mostrarClientesRegistrados();
}
