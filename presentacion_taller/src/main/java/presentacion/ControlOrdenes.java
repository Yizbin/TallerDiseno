/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import dto.ClienteDTO;
import dto.OrdenDTO;
import gestionOrdenes.IManejoOrdenes;
import gestionOrdenes.ManejoOrdenes;
import presentacion.validaciones.IValidacionesPresentacion;
import presentacion.validaciones.ValidacionException;
import presentacion.validaciones.ValidacionesPresentacion;


/**
 *
 * @author Abraham Coronel
 */
public class ControlOrdenes implements IControlOrdenes {

    private final IManejoOrdenes manejo = ManejoOrdenes.getInstancia();
    private IValidacionesPresentacion validacion = ValidacionesPresentacion.getInstancia();

    //Singleton
    private static ControlOrdenes instancia;

    private ControlOrdenes() {
    }

    public static ControlOrdenes getInstancia() {
        if (instancia == null) {
            instancia = new ControlOrdenes();
        }
        return instancia;
    }

    @Override
    public void crearOrden(OrdenDTO orden) {
        manejo.crearOrden(orden);
    }

    @Override
    public Boolean autenticarUsuario(String usuario, String contrasena) {
        return manejo.autenticarUsuario(usuario, contrasena);
    }

    @Override
    public void validarCampoVacio(String texto, String nombreCampo) throws ValidacionException {
        validacion.validarCampoVacio(texto, nombreCampo);
    }

    @Override
    public void validarRegex(String texto, String regex, String mensajeError) throws ValidacionException {
        validacion.validarRegex(texto, regex, mensajeError);
    }

    @Override
    public void validarObjetoNull(Object object, String nombreCampo) throws ValidacionException {
        validacion.validarObjetoNull(object, nombreCampo);
    }

    @Override
    public void validarEmail(String email) throws ValidacionException {
        validacion.validarEmail(email);
    }

    @Override
    public void validarTelefono(String telefono) throws ValidacionException {
        validacion.validarTelefono(telefono);
    }

    @Override
    public void validarAnio(String anio) throws ValidacionException {
        validacion.validarAnio(anio);
    }

    @Override
    public void validarCampoNumerico(String texto, String nombreCampo) throws ValidacionException {
        validacion.validarCampoNumerico(texto, nombreCampo);
    }

    // METODOS DE NAVEGACION DE PANTALLAS
    @Override
    public void mostrarMenuPrincipal() {
        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);

    }

    @Override
    public void mostrarDatosCliente() {
        PantallaDatosCliente datosCliente = new PantallaDatosCliente();
        datosCliente.setVisible(true);
    }

    @Override
    public void mostrarDatosOrden(OrdenDTO orden) {
        PantallaDatosOrden datosOrden = new PantallaDatosOrden(orden);
        datosOrden.setVisible(true);
    }

    @Override
    public void mostrarDatosVehiculo(OrdenDTO orden) {
        PantallaDatosVehiculo datosVehiculo = new PantallaDatosVehiculo(orden);
        datosVehiculo.setVisible(true);
    }

    @Override
    public void mostrarClientesRegistrados(ClienteDTO cliente) {
        PantallaClientesRegistrados clientesRegistrados = new PantallaClientesRegistrados();
    }
}
