/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package presentacion.controles;

import dto.TareaDTO;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public interface IControlTareas {

    public List<TareaDTO> consultarTareasPendientes(String usuarioLogueado);
    
    public Boolean completarTarea(String idTarea);
    
    public List<TareaDTO> buscarTareasDisponibles();

    public Boolean asignarTareaAMecanico(String idTarea, String idEmpleado);
}
