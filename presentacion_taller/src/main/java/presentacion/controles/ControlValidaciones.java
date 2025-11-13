/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.controles;

import presentacion.validaciones.IValidacionesPresentacion;
import presentacion.validaciones.ValidacionException;

/**
 *
 * @author Abraham Coronel
 */
public class ControlValidaciones implements IControlValidaciones {

    private final IValidacionesPresentacion validacion;

    public ControlValidaciones(IValidacionesPresentacion validacion) {
        this.validacion = validacion;
    }

    @Override
    public Boolean validarCampoVacio(String texto, String nombreCampo) throws ValidacionException {
        try {
            validacion.validarCampoVacio(texto, nombreCampo);
            return true;
        } catch (ValidacionException ex) {
            throw new ValidacionException(ex.getMessage());
        }
    }

    @Override
    public Boolean validarRegex(String texto, String regex, String mensajeError) throws ValidacionException {
        try {
            validacion.validarRegex(texto, regex, mensajeError);
            return true;
        } catch (ValidacionException ex) {
            throw new ValidacionException(ex.getMessage());
        }
    }

    @Override
    public Boolean validarObjetoNull(Object object, String nombreCampo) throws ValidacionException {
        try {
            validacion.validarObjetoNull(object, nombreCampo);
            return true;
        } catch (ValidacionException ex) {
            throw new ValidacionException(ex.getMessage());
        }
    }

    @Override
    public Boolean validarEmail(String email) throws ValidacionException {
        try {
            validacion.validarEmail(email);
            return true;
        } catch (ValidacionException ex) {
            throw new ValidacionException(ex.getMessage());
        }
    }

    @Override
    public Boolean validarTelefono(String telefono) throws ValidacionException {
        try {
            validacion.validarTelefono(telefono);
            return true;
        } catch (ValidacionException ex) {
            throw new ValidacionException(ex.getMessage());
        }
    }

    @Override
    public Boolean validarAnio(String anio) throws ValidacionException {
        try {
            validacion.validarAnio(anio);
            return true;
        } catch (ValidacionException ex) {
            throw new ValidacionException(ex.getMessage());
        }
    }

    @Override
    public Boolean validarCampoNumerico(String texto, String nombreCampo) throws ValidacionException {
        try {
            validacion.validarCampoNumerico(texto, nombreCampo);
            return true;
        } catch (ValidacionException ex) {
            throw new ValidacionException(ex.getMessage());
        }
    }
}
