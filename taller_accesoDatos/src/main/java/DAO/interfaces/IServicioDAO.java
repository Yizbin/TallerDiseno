/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO.interfaces;

import Excepciones.PersistenciaException;
import entidades.Servicio;
import java.util.List;

/**
 *
 * @author Pride Factor Black
 */
public interface IServicioDAO {
    
    public Servicio crearServicio(Servicio servicio) throws PersistenciaException;
    
    public Servicio actualizarServicio(Servicio servicio) throws PersistenciaException;

    public Servicio eliminarServicio(Long id) throws PersistenciaException;

    public Servicio buscarPorId(Long id) throws PersistenciaException;

    public List<Servicio> obtenerTodos() throws PersistenciaException;
}
