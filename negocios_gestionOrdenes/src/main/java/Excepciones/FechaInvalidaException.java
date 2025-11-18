/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 *
 * @author Abraham Coronel
 */
public class FechaInvalidaException extends Exception {

    public FechaInvalidaException() {
    }

    public FechaInvalidaException(String message) {
        super(message);
    }

    public FechaInvalidaException(String message, Throwable cause) {
        super(message, cause);
    }

}
