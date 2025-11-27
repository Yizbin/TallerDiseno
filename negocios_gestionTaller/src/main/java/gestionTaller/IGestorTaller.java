package gestionTaller;

import Excepciones.DatosFaltantesEnOrdenException;
import Excepciones.FechaInvalidaException;
import dto.ClienteDTO;
import dto.EmpleadoDTO;
import dto.OrdenDTO;
import dto.PresupuestoDTO;
import dto.TareaDTO;
import dto.VehiculoDTO;
import excepciones.NegocioException;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
/**
 *
 * @author Abraham Coronel
 */
public interface IGestorTaller {

    public OrdenDTO crearOrden(OrdenDTO orden) throws DatosFaltantesEnOrdenException, FechaInvalidaException, NegocioException;

    public Boolean autenticarUsuario(String usuario, String contrasena);

    public List<ClienteDTO> buscarTodosLosClientesActivos() throws NegocioException;

    public List<VehiculoDTO> obtenerVehiculosPorCliente(String idCliente);

    public EmpleadoDTO obtenerDatosUsuario(String usuario);

    public List<PresupuestoDTO> buscarPresupuestosPendientes() throws NegocioException;
    
    public PresupuestoDTO buscarPresupuestoPorOrden(String idOrden) throws NegocioException;
    
    public List<TareaDTO> obtenerTareasDeMecanico(String usuario) throws NegocioException;
    
    public void completarTareaMecanico(String idTarea) throws NegocioException;
}
