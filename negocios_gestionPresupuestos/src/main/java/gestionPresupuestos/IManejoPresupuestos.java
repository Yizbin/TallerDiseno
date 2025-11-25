/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package gestionPresupuestos;

import dto.PresupuestoDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public interface IManejoPresupuestos {
    public List<PresupuestoDTO> obtenerPresupuestosNoPagados() throws NegocioException;
}
