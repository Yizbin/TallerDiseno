/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.utilerias;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author Abraham Coronel
 */
public class GeneradorQR {

    public static ImageIcon generarQR(String texto, int ancho, int alto) {
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(texto, BarcodeFormat.QR_CODE, ancho, alto);

            BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);

            return new ImageIcon(bufferedImage);
        } catch (WriterException e) {
            System.err.println("Error al generar el QR: " + e.getMessage());
            return null;
        }
    }
}
