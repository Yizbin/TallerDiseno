/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestionCorreos;

/**
 *
 * @author Abraham Coronel
 */
public interface IGestorCorreo {

    public void enviarCorreoConAdjunto(String destinatario, String asunto, String mensaje, byte[] archivoAdjunto, String nombreArchivo);
    
    
}
