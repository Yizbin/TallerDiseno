/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import dto.OrdenDTO;
import gestionOrdenes.IManejoOrdenes;

/**
 *
 * @author Abraham Coronel
 */
public class ControlOrdenes implements IControlOrdenes {

    private IManejoOrdenes manejo;
    
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

}
