/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO.interfaces;

import Excepciones.EntidadDuplicadaException;
import Excepciones.EntidadInactivaException;
import Excepciones.EntidadNoEncontradaException;
import Excepciones.PersistenciaException;
import entidades.Empleado;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public interface IEmpleadoDAO {

    public Empleado crearEmpleado(Empleado empleado) throws EntidadDuplicadaException, PersistenciaException;

    public Empleado actualizarCliente(Empleado empleado) throws EntidadNoEncontradaException, EntidadInactivaException, PersistenciaException;

    public void desactivarEmpleado(Long id) throws EntidadNoEncontradaException, PersistenciaException;

    public List<Empleado> buscarTodosLosEmpleados() throws PersistenciaException;

    public List<Empleado> buscarTodosLosEmpleadosActivos() throws PersistenciaException;

    public Empleado autenticarEmpleado(String usuario, String contrasena) throws EntidadNoEncontradaException, PersistenciaException;

    Empleado buscarPorUsuario(String usuario) throws EntidadNoEncontradaException, PersistenciaException;

    List<Empleado> obtenerMecanicos() throws PersistenciaException;

    void actualizarEstadoEmpleado(Long idEmpleado, Boolean activo) throws EntidadNoEncontradaException, PersistenciaException;

    Empleado buscarPorId(Long idEmpleado) throws EntidadNoEncontradaException, PersistenciaException;

}
