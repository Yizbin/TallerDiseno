/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package presentacion;

import dto.ClienteDTO;
import dto.OrdenDTO;
import presentacion.validaciones.ValidacionException;

public interface IControlOrdenes {

    public void crearOrden(OrdenDTO orden);
    
    public Boolean autenticarUsuario(String usuario, String contrasena);
    
    public void validarCampoVacio(String texto, String nombreCampo) throws ValidacionException;
    
    public void validarRegex(String texto, String regex, String mensajeError) throws ValidacionException;
    
    public void validarObjetoNull(Object object, String nombreCampo) throws ValidacionException;
    
    public void validarEmail(String email) throws ValidacionException;
    
    public void validarTelefono(String telefono) throws ValidacionException;
    
    public void validarAnio(String anio) throws ValidacionException;
    
    public void validarCampoNumerico(String texto, String nombreCampo) throws ValidacionException;

    // METODOS DE NAVEGACION DE PANTALLAS
    public void mostrarMenuPrincipal();

    public void mostrarDatosCliente();
    
    public void mostrarDatosVehiculo(OrdenDTO orden);

    public void mostrarDatosOrden(OrdenDTO orden);
    
    public void mostrarClientesRegistrados(ClienteDTO clienteDTO);
}
