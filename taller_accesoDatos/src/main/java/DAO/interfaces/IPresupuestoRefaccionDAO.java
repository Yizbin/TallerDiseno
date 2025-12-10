/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO.interfaces;

import Excepciones.PersistenciaException;
import entidades.PresupuestoRefaccion;
import java.util.List;

/**
 *
 * @author Pride Factor Black
 */
public interface IPresupuestoRefaccionDAO {
    List<PresupuestoRefaccion> buscarPorIdPresupuesto(Long idPresupuesto) throws PersistenciaException;
}
