/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import dto.ClienteDTO;
import dto.OrdenDTO;
import gestionOrdenes.IManejoOrdenes;
import gestionOrdenes.ManejoOrdenes;
import javax.swing.JOptionPane;
import presentacion.validaciones.IValidacionesPresentacion;
import presentacion.validaciones.ValidacionException;
import presentacion.validaciones.ValidacionesPresentacion;

/**
 *
 * @author Abraham Coronel
 */
public class ControlOrdenes implements IControlOrdenes {

    private final IManejoOrdenes manejo;
    private final IValidacionesPresentacion validacion;
    private static ControlOrdenes instancia;

    private ControlOrdenes(IManejoOrdenes manejo, IValidacionesPresentacion validacion) {
        this.manejo = manejo;
        this.validacion = validacion;
    }

    public static ControlOrdenes getInstancia() {
        if (instancia == null) {
            IManejoOrdenes manejoServicio = ManejoOrdenes.getInstancia();
            IValidacionesPresentacion validacionServicio = ValidacionesPresentacion.getInstancia();
            instancia = new ControlOrdenes(manejoServicio, validacionServicio);
        }
        return instancia;
    }

    @Override
    public Boolean crearOrden(OrdenDTO orden) {
        Boolean exito = manejo.crearOrden(orden);

        if (exito) {
            JOptionPane.showMessageDialog(null, "Orden creada correctamente", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo crear la orden", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }

    @Override
    public Boolean autenticarUsuario(String usuario, String contrasena) {
        return manejo.autenticarUsuario(usuario, contrasena);
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

    // METODOS INFORMATIVOS
    @Override
    public void mostrarErrorCampos(String mensajeError) {
        JOptionPane.showMessageDialog(null, mensajeError, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
