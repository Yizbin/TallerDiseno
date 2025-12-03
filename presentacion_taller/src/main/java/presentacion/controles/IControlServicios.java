/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package presentacion.controles;

import dto.ServicioDTO;
import java.util.List;

/**
 *
 * @author Pride Factor Black
 */
public interface IControlServicios {
    
    public ServicioDTO crearServicio(ServicioDTO dto);

    public ServicioDTO actualizarServicio(ServicioDTO dto);

    public ServicioDTO eliminarServicio(String id);

    public List<ServicioDTO> obtenerTodos();
    
}
