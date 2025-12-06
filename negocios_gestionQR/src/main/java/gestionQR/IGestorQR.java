/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestionQR;

import java.awt.image.BufferedImage;

/**
 *
 * @author Abraham Coronel
 */
public interface IGestorQR {

    BufferedImage generarCodigoQR(String texto, int ancho, int alto);
}
