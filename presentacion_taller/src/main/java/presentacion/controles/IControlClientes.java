/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package presentacion.controles;

import dto.ClienteDTO;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public interface IControlClientes {

    public List<ClienteDTO> buscarTodosLosClientesActivos();
}
