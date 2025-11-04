/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.controles;

import dto.ClienteDTO;
import dto.OrdenDTO;
import gestionOrdenes.IManejoOrdenes;
import gestionOrdenes.ManejoOrdenes;
import gestionarClientes.IManejoClientes;
import gestionarClientes.ManejoClientes;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import presentacion.utilerias.CreacionPaneles;
import presentacion.utilerias.ICreacionPaneles;
import presentacion.validaciones.IValidacionesPresentacion;
import presentacion.validaciones.ValidacionException;
import presentacion.validaciones.ValidacionesPresentacion;

/**
 *
 * @author Abraham Coronel
 */
public class ControlOrdenes implements IControlOrdenes {

    private final IManejoOrdenes manejo;
    private final IManejoClientes clientes;
    private final IValidacionesPresentacion validacion;
    private final ICreacionPaneles creacionPaneles;
    private static ControlOrdenes instancia;

    private ControlOrdenes(IManejoOrdenes manejo, IValidacionesPresentacion validacion, IManejoClientes clientes, ICreacionPaneles creacionPaneles) {
        this.manejo = manejo;
        this.validacion = validacion;
        this.clientes = clientes;
        this.creacionPaneles = creacionPaneles;
    }

    public static ControlOrdenes getInstancia() {
        if (instancia == null) {
            IManejoOrdenes manejoServicio = ManejoOrdenes.getInstancia();
            IValidacionesPresentacion validacionServicio = ValidacionesPresentacion.getInstancia();
            IManejoClientes clientesServicio = ManejoClientes.getInstancia();
            ICreacionPaneles creacionPanelesServicio = CreacionPaneles.getInstancia();
            instancia = new ControlOrdenes(manejoServicio, validacionServicio, clientesServicio, creacionPanelesServicio);
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
    public OrdenDTO crearOrdenConCliente(ClienteDTO cliente) {
        OrdenDTO ordenNueva = new OrdenDTO();
        ordenNueva.setCliente(cliente);
        return ordenNueva;
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

    // METODOS DE CREACION UI
    @Override
    public JPanel crearPanelCliente(String nombreCliente) {
        return creacionPaneles.crearPanelCliente(nombreCliente);
    }

    @Override
    public JPanel crearPanelOrden(String textoOrden) {
        return creacionPaneles.crearPanelOrden(textoOrden);
    }

    @Override
    public JPanel crearPanelTitulo(String titulo) {
        return creacionPaneles.crearPanelTitulo(titulo);
    }

    @Override
    public JPanel crearPanelInformativo(String texto, Boolean esDestacado) {
        return creacionPaneles.crearPanelInformativo(texto, esDestacado);
    }

    @Override
    public JPanel crearSeparador(int altura) {
        return creacionPaneles.crearSeparador(altura);
    }

    @Override
    public List<ClienteDTO> obtenerClientesMock() {
        List<ClienteDTO> listaClientes = clientes.obtenerClientes();
        return listaClientes;
    }

    // METODOS INFORMATIVOS
    @Override
    public void mostrarErrorCampos(String mensajeError) {
        JOptionPane.showMessageDialog(null, mensajeError, "Error", JOptionPane.ERROR_MESSAGE);
    }

}
