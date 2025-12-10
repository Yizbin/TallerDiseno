/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BO.interfaces;

import dto.ServicioPresupuestoDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Pride Factor Black
 */
public interface IServicioPresupuestoBO {
    List<ServicioPresupuestoDTO> buscarPorIdPresupuesto(String idPresupuesto) throws NegocioException;
}
