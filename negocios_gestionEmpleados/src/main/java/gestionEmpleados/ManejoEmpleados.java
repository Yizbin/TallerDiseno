/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEmpleados;

import BO.EmpleadoBO;
import BO.interfaces.IEmpleadoBO;
import dto.EmpleadoDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public class ManejoEmpleados implements IManejoEmpleados {

    private static IManejoEmpleados instancia;
    private final IEmpleadoBO empleadoBO = EmpleadoBO.getInstancia();

    private ManejoEmpleados() {
    }

    public static IManejoEmpleados getInstancia() {
        if (instancia == null) {
            instancia = new ManejoEmpleados();
        }
        return instancia;
    }

    @Override
    public Boolean autenticarUsuario(String usuario, String contrasena) throws NegocioException {
        if (usuario == null || usuario.trim().isEmpty()) {
            throw new NegocioException("El usuario no puede estar vacío");
        }

        if (contrasena == null || contrasena.trim().isEmpty()) {
            throw new NegocioException("La contraseña no puede estar vacía");
        }

        return empleadoBO.autenticarEmpleado(usuario, contrasena);
    }

    @Override
    public EmpleadoDTO obtenerDatosUsuario(String usuario) throws NegocioException {
        return empleadoBO.obtenerEmpleadoPorUsuario(usuario);
    }

    @Override
    public List<EmpleadoDTO> obtenerMecanicosParaTabla() throws NegocioException {
        return empleadoBO.obtenerMecanicosParaTabla();
    }

    @Override
    public Boolean autenticarEmpleado(String usuario, String contrasena) throws NegocioException {
        if (usuario == null || usuario.trim().isEmpty()) {
            throw new NegocioException("El usuario no puede estar vacío");
        }

        if (contrasena == null || contrasena.trim().isEmpty()) {
            throw new NegocioException("La contraseña no puede estar vacía");
        }

        return empleadoBO.autenticarEmpleado(usuario, contrasena);
    }

    @Override
    public EmpleadoDTO obtenerEmpleadoPorUsuario(String usuario) throws NegocioException {
        if (usuario == null || usuario.trim().isEmpty()) {
            throw new NegocioException("El usuario no puede estar vacío");
        }

        return empleadoBO.obtenerEmpleadoPorUsuario(usuario);
    }

    @Override
    public EmpleadoDTO actualizarEstadoEmpleado(String idEmpleado, Boolean activo) throws NegocioException {
        if (idEmpleado == null || idEmpleado.trim().isEmpty()) {
            throw new NegocioException("El ID del empleado no puede estar vacío");
        }

        if (activo == null) {
            throw new NegocioException("El estado activo/inactivo no puede ser nulo");
        }

        return empleadoBO.actualizarEstadoEmpleado(idEmpleado, activo);
    }

    @Override
    public EmpleadoDTO buscarPorId(String idEmpleado) throws NegocioException {
        if (idEmpleado == null || idEmpleado.trim().isEmpty()) {
            throw new NegocioException("El ID del empleado no puede estar vacío");
        }

        return empleadoBO.buscarPorId(idEmpleado);
    }
}
