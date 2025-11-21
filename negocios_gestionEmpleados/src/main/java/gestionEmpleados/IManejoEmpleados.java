/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestionEmpleados;

import excepciones.NegocioException;

/**
 *
 * @author Abraham Coronel
 */
public interface IManejoEmpleados {

    public Boolean autenticarUsuario(String usuario, String contrasena) throws NegocioException;
}
