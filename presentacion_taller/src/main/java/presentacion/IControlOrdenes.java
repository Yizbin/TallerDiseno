/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package presentacion;

import dto.ClienteDTO;
import dto.OrdenDTO;
import java.util.List;
import presentacion.validaciones.ValidacionException;

public interface IControlOrdenes {

    public Boolean crearOrden(OrdenDTO orden);
    
    public Boolean autenticarUsuario(String usuario, String contrasena);
    
    public Boolean validarCampoVacio(String texto, String nombreCampo) throws ValidacionException;
    
    public Boolean validarRegex(String texto, String regex, String mensajeError) throws ValidacionException;
    
    public Boolean validarObjetoNull(Object object, String nombreCampo) throws ValidacionException;
    
    public Boolean validarEmail(String email) throws ValidacionException;
    
    public Boolean validarTelefono(String telefono) throws ValidacionException;
    
    public Boolean validarAnio(String anio) throws ValidacionException;
    
    public Boolean validarCampoNumerico(String texto, String nombreCampo) throws ValidacionException;
    
    public List<ClienteDTO> obtenerClientesMock();

    // METODOS DE NAVEGACION DE PANTALLAS
    public void mostrarMenuPrincipal();

    public void mostrarDatosCliente();
    
    public void mostrarDatosVehiculo(OrdenDTO orden);

    public void mostrarDatosOrden(OrdenDTO orden);
    
    public void mostrarClientesRegistrados();
    
    // METODOS INFORMATIVOS
    public void mostrarErrorCampos(String mensajeError);
}
