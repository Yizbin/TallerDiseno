/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package presentacion.controles;

import java.awt.Component;

/**
 *
 * @author Abraham Coronel
 */
public interface IControlMensajes {

    public void mostrarErrorCamposConPadre(Component padre, String mensajeError);
    
    public void mostrarErrorCampos(String mensajeError);
    
    public void mostrarMensajeInformativo(Component padre, String mensaje, String titulo);
    
    public void mostrarExito(String mensajeExito);
    
    public Boolean mostrarConfirmacion(Component padre, String mensaje, String titulo);
    
    void mostrarError(Component padre, String mensaje);
    
    
}
