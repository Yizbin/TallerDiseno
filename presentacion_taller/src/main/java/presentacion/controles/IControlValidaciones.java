/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package presentacion.controles;

import presentacion.validaciones.ValidacionException;

/**
 *
 * @author Abraham Coronel
 */
public interface IControlValidaciones {

    public Boolean validarCampoVacio(String texto, String nombreCampo) throws ValidacionException;

    public Boolean validarRegex(String texto, String regex, String mensajeError) throws ValidacionException;

    public Boolean validarObjetoNull(Object object, String nombreCampo) throws ValidacionException;

    public Boolean validarEmail(String email) throws ValidacionException;

    public Boolean validarTelefono(String telefono) throws ValidacionException;

    public Boolean validarAnio(String anio) throws ValidacionException;

    public Boolean validarCampoNumerico(String texto, String nombreCampo) throws ValidacionException;

}
