/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.controles;

import dto.ClienteDTO;
import gestionTaller.IGestorTaller;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public class ControlClientes implements IControlClientes {

    private final IGestorTaller taller;

    public ControlClientes(IGestorTaller taller) {
        this.taller = taller;
    }

    @Override
    public List<ClienteDTO> obtenerClientesMock() {
        List<ClienteDTO> listaClientes = taller.obtenerClienteMock();
        return listaClientes;
    }

}
