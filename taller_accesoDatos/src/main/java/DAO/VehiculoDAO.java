/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAO.interfaces.IVehiculoDAO;
import Excepciones.EntidadDuplicadaException;
import Excepciones.EntidadNoEncontradaException;
import Excepciones.PersistenciaException;
import conexion.Conexion;
import entidades.Vehiculo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author Abraham Coronel
 */
public class VehiculoDAO implements IVehiculoDAO {

    @Override
    public Vehiculo crearVehiculo(Vehiculo vehiculo) throws EntidadDuplicadaException, PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();

            validarVehiculoDuplicado(em, vehiculo.getPlacas());

            em.persist(vehiculo);
            em.getTransaction().commit();
            return vehiculo;
        } catch (EntidadDuplicadaException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al guardar el vehiculo: " + e.getMessage(), e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Vehiculo actualizarVehiculo(Vehiculo vehiculo) throws EntidadNoEncontradaException, PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();

            validarVehiculoExistente(em, vehiculo.getId());

            Vehiculo vehiculoActualizar = em.merge(vehiculo);
            em.getTransaction().commit();
            return vehiculoActualizar;
        } catch (EntidadNoEncontradaException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al actualizar el vehiculo: " + e.getMessage(), e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void eliminarVehiculo(Long id) throws EntidadNoEncontradaException, PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();

            Vehiculo vehiculo = validarVehiculoExistente(em, id);

            em.remove(vehiculo);
            em.getTransaction().commit();
        } catch (EntidadNoEncontradaException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al eliminar el vehiculo: " + e.getMessage(), e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Vehiculo> buscarTodosLosVehiculos() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            TypedQuery<Vehiculo> query = em.createQuery("SELECT v FROM Vehiculo v", Vehiculo.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener todas las vehiculo: " + e.getMessage(), e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Vehiculo> buscarVehiculoPorCliente(Long idCliente) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            TypedQuery<Vehiculo> query = em.createQuery("SELECT v FROM Vehiculo v WHERE v.cliente.id_cliente = :idCliente", Vehiculo.class);
            query.setParameter("idCliente", idCliente);
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener todas las vehiculo: " + e.getMessage(), e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    private void validarVehiculoDuplicado(EntityManager em, String placas) throws EntidadDuplicadaException {
        try {
            TypedQuery<Long> query = em.createQuery(
                    "SELECT COUNT(v) FROM Vehiculo v WHERE v.placas = :placas", Long.class);
            query.setParameter("placas", placas);
            if (query.getSingleResult() > 0) {
                throw new EntidadDuplicadaException("Ya existe un vehiculo con las placas: " + placas);
            }
        } catch (NoResultException e) {
        }
    }

    private Vehiculo validarVehiculoExistente(EntityManager em, Long id) throws EntidadNoEncontradaException {
        if (id == null) {
            throw new EntidadNoEncontradaException("El ID del vehiculo no puede ser nulo.");
        }
        Vehiculo vehiculo = em.find(Vehiculo.class, id);
        if (vehiculo == null) {
            throw new EntidadNoEncontradaException("Vehiculo no encontrado con ID: " + id);
        }
        return vehiculo;
    }
}
