/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO.interfaces;

import Excepciones.PersistenciaException;
import entidades.ServicioPresupuesto;
import java.util.List;

/**
 *
 * @author Pride Factor Black
 */
public interface IServicioPresupuestoDAO {
    List<ServicioPresupuesto> buscarPorIdPresupuesto(Long idPresupuesto) throws PersistenciaException;
}
