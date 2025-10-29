/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package presentacion.validaciones;

/**
 *
 * @author Abraham Coronel
 */
public interface IValidacionesPresentacion {

    public void validarCampoVacio(String texto, String nombreCampo) throws ValidacionException;
    
    public void validarRegex(String texto, String regex, String mensajeError) throws ValidacionException;
    
    public void validarObjetoNull(Object object, String nombreCampo) throws ValidacionException;
    
    public void validarEmail(String email) throws ValidacionException;
    
    public void validarTelefono(String telefono) throws ValidacionException;
    
    public void validarAnio(String anio) throws ValidacionException;
    
    public void validarCampoNumerico(String texto, String nombreCampo) throws ValidacionException;
    
    public void validarPlaca(String placas)throws ValidacionException;
}
