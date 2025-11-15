/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 *
 * @author Abraham Coronel
 */
public class EntidadInactivaException extends Exception {

    public EntidadInactivaException() {
    }

    public EntidadInactivaException(String message) {
        super(message);
    }

    public EntidadInactivaException(String message, Throwable cause) {
        super(message, cause);
    }

}
