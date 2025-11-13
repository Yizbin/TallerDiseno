/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.controles;

import javax.swing.JOptionPane;

/**
 *
 * @author Abraham Coronel
 */
public class ControlMensajes implements IControlMensajes {

    @Override
    public void mostrarErrorCampos(String mensajeError) {
        JOptionPane.showMessageDialog(null, mensajeError, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
