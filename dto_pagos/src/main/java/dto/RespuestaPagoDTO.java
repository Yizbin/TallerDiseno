/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Abraham Coronel
 */
public class RespuestaPagoDTO {

    private Boolean exito;
    private String mensaje;
    private String Idtransaccion;

    public RespuestaPagoDTO() {
    }

    public RespuestaPagoDTO(Boolean exito, String mensaje, String Idtransaccion) {
        this.exito = exito;
        this.mensaje = mensaje;
        this.Idtransaccion = Idtransaccion;
    }

    public Boolean getExito() {
        return exito;
    }

    public void setExito(Boolean exito) {
        this.exito = exito;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getIdtransaccion() {
        return Idtransaccion;
    }

    public void setIdtransaccion(String Idtransaccion) {
        this.Idtransaccion = Idtransaccion;
    }

}
