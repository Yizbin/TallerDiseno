/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAO.interfaces.IRefaccionDAO;
import Excepciones.EntidadNoEncontradaException;
import Excepciones.PersistenciaException;
import conexion.Conexion;
import entidades.Refaccion;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Abraham Coronel
 */
public class RefaccionDAO implements IRefaccionDAO {

    private static IRefaccionDAO instancia;

    private RefaccionDAO() {
    }

    public static IRefaccionDAO getInstancia() {
        if (instancia == null) {
            instancia = new RefaccionDAO();
        }
        return instancia;
    }

    @Override
    public Refaccion crearRefaccion(Refaccion refaccion) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();

            em.persist(refaccion);
            em.getTransaction().commit();
            return refaccion;

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al guardar la refacción: " + e.getMessage(), e);

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Refaccion actualizarRefaccion(Refaccion refaccion) throws EntidadNoEncontradaException, PersistenciaException {
        EntityManager em = Conexion.crearConexion();

        try {
            em.getTransaction().begin();

            // Validar que la refacción existe
            validarRefaccionExistente(em, refaccion.getId());

            // Actualizar (merge)
            Refaccion refActualizada = em.merge(refaccion);

            em.getTransaction().commit();

            return refActualizada;

        } catch (EntidadNoEncontradaException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al actualizar la refacción: " + e.getMessage(), e);

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Refaccion> buscarTodasLasRefacciones() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            TypedQuery<Refaccion> query
                    = em.createQuery("SELECT r FROM Refaccion r", Refaccion.class);

            return query.getResultList();

        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener todas las refacciones: " + e.getMessage(), e);

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Refaccion buscarRefaccionPorId(Long id) throws EntidadNoEncontradaException, PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            Refaccion refaccion = em.find(Refaccion.class, id);

            if (refaccion == null) {
                throw new EntidadNoEncontradaException("Refacción no encontrada con ID: " + id);
            }
            return refaccion;

        } catch (EntidadNoEncontradaException e) {
            throw e;

        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar la refacción por ID: " + e.getMessage(), e);

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    private Refaccion validarRefaccionExistente(EntityManager em, Long id) throws EntidadNoEncontradaException {

        if (id == null) {
            throw new EntidadNoEncontradaException("El ID de la refacción no puede ser nulo.");
        }

        Refaccion ref = em.find(Refaccion.class, id);

        if (ref == null) {
            throw new EntidadNoEncontradaException("Refacción no encontrada con ID: " + id);
        }

        return ref;
    }

}
