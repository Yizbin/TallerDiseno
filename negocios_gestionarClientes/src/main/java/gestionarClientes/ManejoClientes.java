/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionarClientes;

import dto.ClienteDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author payde
 */
public class ManejoClientes implements IManejoClientes {

    private static ManejoClientes instancia;

    private ManejoClientes() {
    }

    public static ManejoClientes getInstancia() {
        if (instancia == null) {
            instancia = new ManejoClientes();
        }
        return instancia;
    }

    @Override
    public List<ClienteDTO> obtenerClientes() {
        List<ClienteDTO> clientes = new ArrayList<>();

        clientes.add(new ClienteDTO("Juan", "Perez", "Leyva", "6441563486", "juan@gmail.com", "calle what", "colonia 10", "743"));
        clientes.add(new ClienteDTO("Mordecai", "Lopez", "Garcia", "6443526373", "mordecai@gmail.com", "calle tes", "colonia 11", "543"));
        clientes.add(new ClienteDTO("Anais", "Gaxiola", "Mendivil", "6442659876", "anais@gmail.com", "calle ro", "colonia 12", "434"));
        clientes.add(new ClienteDTO("Carly", "shein", "Gomez", "6443697328", "carly@gmail.com", "calle bidi", "colonia 13", "632"));
        clientes.add(new ClienteDTO("Camila", "Suarez", "Mecias", "6544248730", "camila@gmail.com", "calle skibidi", "colonia 14", "242"));

        return clientes;
    }

}
