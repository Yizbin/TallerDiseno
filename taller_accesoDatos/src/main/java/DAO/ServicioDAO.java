/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAO.interfaces.IServicioDAO;
import Excepciones.PersistenciaException;
import conexion.Conexion;
import entidades.Servicio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Pride Factor Black
 */
public class ServicioDAO implements IServicioDAO{
    
    private static IServicioDAO instancia;

    public ServicioDAO() {
    }

    public static IServicioDAO getInstancia() {
        if (instancia==null) {
            instancia = new ServicioDAO();
        }
        return instancia;
    }

    @Override
    public Servicio crearServicio(Servicio servicio) throws PersistenciaException {
          EntityManager em = Conexion.crearConexion();

        try {
            em.getTransaction().begin();
            em.persist(servicio);
            em.getTransaction().commit();
            return servicio;

        } catch (Exception ex) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw new PersistenciaException("Error al crear servicio: " + ex.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public Servicio actualizarServicio(Servicio servicio) throws PersistenciaException {
       EntityManager em = Conexion.crearConexion();

        try {
            em.getTransaction().begin();
            Servicio actualizado = em.merge(servicio);
            em.getTransaction().commit();
            return actualizado;

        } catch (Exception ex) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw new PersistenciaException("Error al actualizar servicio: " + ex.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public Servicio eliminarServicio(Long id) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();

        try {
            em.getTransaction().begin();

            Servicio s = em.find(Servicio.class, id);
            if (s == null)
                throw new PersistenciaException("Servicio con ID " + id + " no existe.");

            em.remove(s);
            em.getTransaction().commit();
            return s;

        } catch (PersistenciaException ex) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw new PersistenciaException("Error al eliminar servicio: " + ex.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public Servicio buscarPorId(Long id) throws PersistenciaException {
       EntityManager em = Conexion.crearConexion();
        try {
            return em.find(Servicio.class, id);
        } catch (Exception ex) {
            throw new PersistenciaException("Error al buscar servicio: " + ex.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public List<Servicio> obtenerTodos() throws PersistenciaException {
       EntityManager em = Conexion.crearConexion();
        try {
            TypedQuery<Servicio> query = em.createQuery("SELECT s FROM Servicio s", Servicio.class);
            return query.getResultList();
        } catch (Exception ex) {
            throw new PersistenciaException("Error al obtener servicios: " + ex.getMessage());
        } finally {
            em.close();
        }
    }
    
}
    
    

