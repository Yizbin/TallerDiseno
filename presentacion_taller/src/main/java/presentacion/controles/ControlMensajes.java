/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.controles;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Abraham Coronel
 */
public class ControlMensajes implements IControlMensajes {

    public ControlMensajes() {
    }

    @Override
    public void mostrarErrorCamposConPadre(Component padre, String mensajeError) {
        JOptionPane.showMessageDialog(padre, mensajeError, "Error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void mostrarMensajeInformativo(Component padre, String mensaje, String titulo) {
        JOptionPane.showMessageDialog(padre, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void mostrarErrorCampos(String mensajeError) {
        JOptionPane.showMessageDialog(null, mensajeError, "Error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void mostrarExito(String mensajeExito) {
        JOptionPane.showMessageDialog(null, mensajeExito, "Exito", JOptionPane.INFORMATION_MESSAGE);
    }

}
