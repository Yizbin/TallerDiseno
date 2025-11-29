/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAO.interfaces.IPresupuestoDAO;
import Excepciones.EntidadNoEncontradaException;
import Excepciones.PersistenciaException;
import conexion.Conexion;
import entidades.Presupuesto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author Abraham Coronel
 */
public class PresupuestoDAO implements IPresupuestoDAO {

    private static IPresupuestoDAO instancia;

    private PresupuestoDAO() {
    }

    public static IPresupuestoDAO getInstancia() {
        if (instancia == null) {
            instancia = new PresupuestoDAO();
        }
        return instancia;
    }

    @Override
    public Presupuesto crearPresupuesto(Presupuesto presupuesto) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();

            em.persist(presupuesto);

            em.getTransaction().commit();
            return presupuesto;

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al guardar el presupuesto: " + e.getMessage(), e);

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Presupuesto actualizarPresupuesto(Presupuesto presupuesto) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();

        try {
            em.getTransaction().begin();

            validarPresupuestoExistente(em, presupuesto.getId());

            Presupuesto actualizado = em.merge(presupuesto);

            em.getTransaction().commit();
            return actualizado;

        } catch (EntidadNoEncontradaException e) {

            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException(e.getMessage(), e);

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            throw new PersistenciaException("Error al actualizar el presupuesto: " + e.getMessage(), e);

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Presupuesto eliminarPresupuesto(Long id) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();

            Presupuesto presupuesto = em.find(Presupuesto.class, id);

            if (presupuesto == null) {
                throw new PersistenciaException("No existe un presupuesto con ID: " + id);
            }

            em.remove(presupuesto);
            em.getTransaction().commit();

            return presupuesto;

        } catch (Exception e) {

            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            throw new PersistenciaException("Error al eliminar el presupuesto: " + e.getMessage(), e);

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Presupuesto buscarPresupuestoPorId(Long id) throws PersistenciaException {
         EntityManager em = Conexion.crearConexion();
         
          try {
        Presupuesto presupuesto = em.find(Presupuesto.class, id);

        if (presupuesto == null) {
            throw new EntidadNoEncontradaException("No existe presupuesto con ID: " + id);
        }

        return presupuesto;

    } catch (EntidadNoEncontradaException e) {
        throw new PersistenciaException("Error al obtener presupuesto por ID: " + e.getMessage(), e);

    } finally {
        if (em != null) {
            em.close();
        }
    }
    }

    @Override
    public List<Presupuesto> buscarTodosLosPresupuestos() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {

            TypedQuery<Presupuesto> query
                    = em.createQuery("SELECT p FROM Presupuesto p", Presupuesto.class);

            return query.getResultList();

        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener todos los presupuestos: " + e.getMessage(), e);

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Presupuesto> buscarPresupuestoNoPagados() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            String jpql = "SELECT p FROM Presupuesto p "
                    + "JOIN FETCH p.orden o "
                    + "JOIN FETCH o.cliente c "
                    + "JOIN FETCH o.vehiculo v "
                    + "WHERE p.estado = false OR p.estado IS NULL";

            TypedQuery<Presupuesto> query = em.createQuery(jpql, Presupuesto.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar presupuestos: " + e.getMessage(), e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Presupuesto buscarPresupuestoPorOrden(Long idOrden) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            String jpql = "SELECT p FROM Presupuesto p WHERE p.orden.id_orden = :idOrden";

            TypedQuery<Presupuesto> query = em.createQuery(jpql, Presupuesto.class);
            query.setParameter("idOrden", idOrden);

            return query.getSingleResult(); 
        } catch (NoResultException e) {
            return null; 
        } catch (Exception e) {
            throw new PersistenciaException("Error buscando presupuesto", e);
        } finally {
            em.close();
        }
    }

    private Presupuesto validarPresupuestoExistente(EntityManager em, Long id)
            throws EntidadNoEncontradaException {

        if (id == null) {
            throw new EntidadNoEncontradaException("El ID del presupuesto no puede ser nulo.");
        }

        Presupuesto p = em.find(Presupuesto.class, id);

        if (p == null) {
            throw new EntidadNoEncontradaException("Presupuesto no encontrado con ID: " + id);
        }

        return p;
    }

}
