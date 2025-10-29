/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.validaciones;

/**
 *
 * @author Abraham Coronel
 */
public class ValidacionesPresentacion implements IValidacionesPresentacion {

    private static ValidacionesPresentacion instancia;

    private ValidacionesPresentacion() {
    }

    public static ValidacionesPresentacion getInstancia() {
        if (instancia == null) {
            instancia = new ValidacionesPresentacion();
        }
        return instancia;
    }

    private static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
    private static final String TELEFONO_REGEX = "^[+]?[0-9]{10,13}$"; //Estariamos asumiendo que es de 10 digitos
    private static final String ANIO_REGEX = "^[0-9]{4}$";
    private static final String NUMERO_REGEX = "^[0-9]+$";

    @Override
    public void validarCampoVacio(String texto, String nombreCampo) throws ValidacionException {
        if (texto == null || texto.isBlank()) {
            throw new ValidacionException("El campo " + nombreCampo + " es obligatorio de llenar.");
        }
    }

    @Override
    public void validarRegex(String texto, String regex, String mensajeError) throws ValidacionException {
        if (!texto.matches(regex)) {
            throw new ValidacionException(mensajeError);
        }
    }

    @Override
    public void validarObjetoNull(Object object, String nombreCampo) throws ValidacionException {
        if (object == null) {
            throw new ValidacionException("El campo " + nombreCampo + " es obligatorio de llenar.");
        }
    }

    @Override
    public void validarEmail(String email) throws ValidacionException {
        validarCampoVacio(email, "Correo Electronico");
        validarRegex(email, EMAIL_REGEX, "El formato del correo electronico no es correcto.");
    }

    @Override
    public void validarTelefono(String telefono) throws ValidacionException {
        validarCampoVacio(telefono, "Telefono");
        validarRegex(telefono, TELEFONO_REGEX, "El formato del telefono no es correcto.");
    }

    @Override
    public void validarAnio(String anio) throws ValidacionException {
        validarCampoVacio(anio, "Año");
        validarRegex(anio, ANIO_REGEX, "El formato del año no es correcto.");
    }

    @Override
    public void validarCampoNumerico(String texto, String nombreCampo) throws ValidacionException {
        validarCampoVacio(texto, nombreCampo);
        validarRegex(texto, NUMERO_REGEX, "El campo " + nombreCampo + " solo debe contener numeros");
    }

    @Override
    public void validarPlaca(String placas) throws ValidacionException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
