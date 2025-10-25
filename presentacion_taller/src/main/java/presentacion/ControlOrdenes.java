/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import dto.OrdenDTO;
import gestionOrdenes.IManejoOrdenes;
import gestionOrdenes.ManejoOrdenes;
/**
 *
 * @author Abraham Coronel
 */
public class ControlOrdenes implements IControlOrdenes {

    private final IManejoOrdenes manejo = ManejoOrdenes.getInstancia();

    //Singleton
    private static ControlOrdenes instancia;

    private ControlOrdenes() {
    }

    public static ControlOrdenes getInstancia() {
        if (instancia == null) {
            instancia = new ControlOrdenes();
        }
        return instancia;
    }

    @Override
    public void crear0rden(OrdenDTO orden) {
        manejo.crearOrden(orden);
    }

    // METODOS DE NAVEGACION DE PANTALLAS
    @Override
    public void mostrarMenuPrincipal() {
        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
        
    }

    @Override
    public void mostrarDatosCliente() {
        PantallaDatosCliente datosCliente = new PantallaDatosCliente();
        datosCliente.setVisible(true);
    }
    
    @Override
    public void mostrarDatosOrden(OrdenDTO orden) {
        PantallaDatosOrden datosOrden = new PantallaDatosOrden(orden);
        datosOrden.setVisible(true);
    }

    @Override
    public void mostrarDatosVehiculo(OrdenDTO orden) {
        PantallaDatosVehiculo datosVehiculo = new PantallaDatosVehiculo(orden);
        datosVehiculo.setVisible(true);
    }


}
