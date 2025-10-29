/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestionOrdenes;

import dto.OrdenDTO;

/**
 *
 * @author Abraham Coronel
 */
public interface IManejoOrdenes {

    public Boolean crearOrden(OrdenDTO orden);
    public Boolean autenticarUsuario(String usuario, String contrasena);
}
