/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionOrdenes;

import dto.OrdenDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public class ManejoOrdenes implements IManejoOrdenes {

    public List<OrdenDTO> listaOrdenes;

    private static ManejoOrdenes instancia;

    public static ManejoOrdenes getInstancia() {
        if (instancia == null) {
            instancia = new ManejoOrdenes();
        }
        return instancia;
    }

    private ManejoOrdenes() {
        this.listaOrdenes = new ArrayList<>();
    }

    public List<OrdenDTO> getOrdenesCreadas() {
        return this.listaOrdenes;
    }

    @Override
    public Boolean crearOrden(OrdenDTO orden) {
        if (orden != null) {
            this.listaOrdenes.add(orden);
            System.out.println("Orden correcta");
            return true;
        } else {
            System.out.println("Orden nula");
            return false;
        }
    }

    @Override
    public Boolean autenticarUsuario(String usuario, String contrasena) {
        return "pepe".equals(usuario) && "123".equals(contrasena);
    }

}
