/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.controles;

import gestionTaller.IGestorTaller;

/**
 *
 * @author Abraham Coronel
 */
public class ControlAutenticacion implements IControlAutenticacion {

    private final IGestorTaller taller;

    public ControlAutenticacion(IGestorTaller taller) {
        this.taller = taller;
    }

    @Override
    public Boolean autenticarUsuario(String usuario, String contrasena) {
        return taller.autenticarUsuario(usuario, contrasena);
    }

}
