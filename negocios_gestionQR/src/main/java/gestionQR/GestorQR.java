/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionQR;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.image.BufferedImage;

/**
 *
 * @author Abraham Coronel
 */
public class GestorQR implements IGestorQR {

    @Override
    public BufferedImage generarCodigoQR(String texto, int ancho, int alto) {
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(texto, BarcodeFormat.QR_CODE, ancho, alto);
            return MatrixToImageWriter.toBufferedImage(bitMatrix);
        } catch (WriterException e) {
            System.err.println("Error en el subsistema de generacion de QR: " + e.getMessage());
            return null;
        }
    }

}
