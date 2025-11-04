/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package presentacion.controles;

import dto.ClienteDTO;
import dto.OrdenDTO;
import dto.VehiculoDTO;
import java.util.List;
import javax.swing.JPanel;
import presentacion.validaciones.ValidacionException;

public interface IControlOrdenes {

    public Boolean crearOrden(OrdenDTO orden);
    
    public OrdenDTO crearOrdenConCliente(ClienteDTO cliente);
    
    public OrdenDTO crearOrdenConVehiculo(VehiculoDTO vehiculo);
    
    public Boolean autenticarUsuario(String usuario, String contrasena);
    
    public Boolean validarCampoVacio(String texto, String nombreCampo) throws ValidacionException;
    
    public Boolean validarRegex(String texto, String regex, String mensajeError) throws ValidacionException;
    
    public Boolean validarObjetoNull(Object object, String nombreCampo) throws ValidacionException;
    
    public Boolean validarEmail(String email) throws ValidacionException;
    
    public Boolean validarTelefono(String telefono) throws ValidacionException;
    
    public Boolean validarAnio(String anio) throws ValidacionException;
    
    public Boolean validarCampoNumerico(String texto, String nombreCampo) throws ValidacionException;
    
    public List<ClienteDTO> obtenerClientesMock();
    
    public List<VehiculoDTO> obtenerVehiculosMock();
    
    // METODOS DE CREACION UI
    public JPanel crearPanelCliente(String nombreCliente);
    
    public JPanel crearPanelVehiculo(String vehiculo);

    public JPanel crearPanelOrden(String textoOrden);

    public JPanel crearPanelTitulo(String titulo);

    public JPanel crearPanelInformativo(String texto, Boolean esDestacado);

    public JPanel crearSeparador(int altura);
    
    
    // METODOS INFORMATIVOS
    public void mostrarErrorCampos(String mensajeError);
}
