/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package DAO.interfaces;

import Excepciones.PersistenciaException;
import entidades.Presupuesto;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public interface IPresupuestoDAO {
     
     public Presupuesto crearPresupuesto(Presupuesto presupuesto) throws PersistenciaException;
     
     public Presupuesto actualizarPresupuesto(Presupuesto presupuesto) throws PersistenciaException;
     
     public Presupuesto eliminarPresupuesto(Long id) throws PersistenciaException;
     
     public List<Presupuesto> buscarTodosLosPresupuestos() throws PersistenciaException;
      
     public List<Presupuesto> buscarPresupuestoPorId(Long id) throws PersistenciaException;
     
     public List<Presupuesto> buscarPresupuestoNoPagados() throws PersistenciaException;
     
     public Presupuesto buscarPresupuestoPorOrden(Long idOrden) throws PersistenciaException;
}
