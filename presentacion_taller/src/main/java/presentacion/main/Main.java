/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package presentacion.main;

import presentacion.IniciarSesion;
import presentacion.controles.IControlAutenticacion;
import presentacion.controles.IControlMensajes;
import presentacion.controles.IControlNavegacion;
import presentacion.controles.IControlValidaciones;

/**
 *
 * @author Abraham Coronel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ContenedorDependencias contenedor = new ContenedorDependencias();

        IControlNavegacion controlNavegacion = contenedor.getControlNavegacion();
        IControlValidaciones controlValidacion = contenedor.getControlValidaciones();
        IControlMensajes controlMensajes = contenedor.getControlMensajes();
        IControlAutenticacion controlAutenticacion = contenedor.getControlAutenticacion();

        java.awt.EventQueue.invokeLater(() -> {
            new IniciarSesion(controlNavegacion,
                    controlValidacion,
                    controlMensajes,
                    controlAutenticacion).setVisible(true);
        });
    }

}
