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
    
    public List<EmpleadoDTO> buscarTodosLosMecanicosActivos();
    
    public EmpleadoDTO seleccionarMecanico(String idEmpleado);
    
}
