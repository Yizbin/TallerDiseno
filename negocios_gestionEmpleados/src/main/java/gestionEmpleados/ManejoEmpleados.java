/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEmpleados;

import BO.EmpleadoBO;
import BO.interfaces.IEmpleadoBO;
import excepciones.NegocioException;

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
            throw new NegocioException("El usuario no puede estar vacio");
        }

        if (contrasena == null || contrasena.trim().isEmpty()) {
            throw new NegocioException("La contrasena no puede estar vacio");
        }

        return empleadoBO.autenticarEmpleado(usuario, contrasena);
    }

}
