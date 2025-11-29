/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package presentacion.controles;

import dto.EmpleadoDTO;
import java.util.List;

/**
 *
 * @author Angel Servin
 */
public interface IControlEmpleados {

    Boolean autenticarEmpleado(String usuario, String contrasena);

    EmpleadoDTO obtenerEmpleadoPorUsuario(String usuario);

    List<EmpleadoDTO> obtenerMecanicosParaTabla();

    EmpleadoDTO actualizarEstadoEmpleado(String idEmpleado, Boolean activo);

    EmpleadoDTO buscarPorId(String idEmpleado);

    boolean asignarTareaAMecanico(String idTarea, String idMecanico);

}
