/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO.interfaces;

import Excepciones.EntidadNoEncontradaException;
import Excepciones.PersistenciaException;
import entidades.Tarea;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public interface ITareaDAO {

    public Tarea crearTarea(Tarea tarea) throws PersistenciaException;

    public Tarea actualizarTarea(Tarea tarea) throws EntidadNoEncontradaException, PersistenciaException;

    public void eliminarTarea(Long id) throws EntidadNoEncontradaException, PersistenciaException;

    public List<Tarea> buscarTodasLasTareas() throws PersistenciaException;

    public List<Tarea> buscarTareaPorPresupuesto(Long idPresupuesto) throws PersistenciaException;

    public List<Tarea> buscarTareasPorEmpleado(Long idEmpleado) throws PersistenciaException;

    public Tarea buscarTareaPorId(Long id) throws PersistenciaException;

    boolean asignarTareaAMecanico(Long idTarea, Long idMecanico) throws PersistenciaException;

    List<Tarea> obtenerTareas() throws PersistenciaException;

    List<Tarea> buscarTareasSinAsignar() throws PersistenciaException;
    
    List<Tarea> buscarTareasCompletadasPorEmpleado(Long idEmpleado)throws PersistenciaException;


}
