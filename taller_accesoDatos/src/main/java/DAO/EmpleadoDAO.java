/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAO.interfaces.IEmpleadoDAO;
import Excepciones.EntidadDuplicadaException;
import Excepciones.EntidadInactivaException;
import Excepciones.EntidadNoEncontradaException;
import Excepciones.PersistenciaException;
import conexion.Conexion;
import entidades.Empleado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author Abraham Coronel
 */
public class EmpleadoDAO implements IEmpleadoDAO {

    private static IEmpleadoDAO instancia;

    private EmpleadoDAO() {
    }

    public static IEmpleadoDAO getInstancia() {
        if (instancia == null) {
            instancia = new EmpleadoDAO();
        }
        return instancia;
    }

    @Override
    public Empleado crearEmpleado(Empleado empleado) throws EntidadDuplicadaException, PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();

            validarEmpleadoDuplicado(em, empleado.getUsuario());

            empleado.setActivo(true);
            em.persist(empleado);
            em.getTransaction().commit();
            return empleado;
        } catch (EntidadDuplicadaException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al guardar el empleado: " + e.getMessage(), e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Empleado actualizarCliente(Empleado empleado) throws EntidadNoEncontradaException, EntidadInactivaException, PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();

            validarEmpleadoParaActualizar(em, empleado.getId());

            Empleado empleadoActualizar = em.merge(empleado);
            em.getTransaction().commit();
            return empleadoActualizar;
        } catch (EntidadNoEncontradaException | EntidadInactivaException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al actualizar el empleado: " + e.getMessage(), e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void desactivarEmpleado(Long id) throws EntidadNoEncontradaException, PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();

            Empleado empleado = validarEmpleadoExistente(em, id);

            empleado.setActivo(false);
            em.merge(empleado);
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
            throw new PersistenciaException("Error al desactivar el empleado: " + e.getMessage(), e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Empleado> buscarTodosLosEmpleados() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            TypedQuery<Empleado> query = em.createQuery("SELECT e FROM Empleado e", Empleado.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener los empleados: " + e.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Empleado> buscarTodosLosEmpleadosActivos() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            TypedQuery<Empleado> query = em.createQuery("SELECT e FROM Empleado e WHERE e.activo = true", Empleado.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener los empleados: " + e.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    private void validarEmpleadoDuplicado(EntityManager em, String usuario) throws EntidadDuplicadaException {
        try {
            TypedQuery<Long> query = em.createQuery(
                    "SELECT COUNT(e) FROM Empleado e WHERE e.usuario = :usuario", Long.class);
            query.setParameter("usuario", usuario);
            if (query.getSingleResult() > 0) {
                throw new EntidadDuplicadaException("Ya existe un empleado con el usuario: " + usuario);
            }
        } catch (NoResultException e) {
        }
    }

    private void validarEmpleadoParaActualizar(EntityManager em, Long id) throws EntidadNoEncontradaException, EntidadInactivaException {
        Empleado empleado = em.find(Empleado.class, id);
        if (empleado == null) {
            throw new EntidadNoEncontradaException("No se puede actualizar: Empleado con ID " + id + " no existe.");
        }
        if (empleado.getActivo() == null || !empleado.getActivo()) {
            throw new EntidadInactivaException("No se puede actualizar: El empleado con ID " + id + " está inactivo.");
        }
    }

    private Empleado validarEmpleadoExistente(EntityManager em, Long id) throws EntidadNoEncontradaException {
        Empleado empleado = em.find(Empleado.class, id);
        if (empleado == null) {
            throw new EntidadNoEncontradaException("Empleado no encontrado con ID: " + id);
        }
        return empleado;
    }

    @Override
    public Empleado autenticarEmpleado(String usuario, String contrasena) throws EntidadNoEncontradaException, PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            TypedQuery<Empleado> query = em.createQuery(
                    "SELECT e FROM Empleado e WHERE e.usuario = :usuario AND e.contrasenia = :contrasenia AND e.activo = true", Empleado.class);
            query.setParameter("usuario", usuario);
            query.setParameter("contrasenia", contrasena);

            return query.getSingleResult();
        } catch (NoResultException e) {
            throw new EntidadNoEncontradaException("Credenciales incorrectas o empleado inactivo.");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al autenticar empleado: " + e.getMessage(), e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Empleado buscarPorUsuario(String usuario) throws EntidadNoEncontradaException, PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            TypedQuery<Empleado> query = em.createQuery(
                    "SELECT e FROM Empleado e WHERE e.usuario = :usuario AND e.activo = true", Empleado.class);
            query.setParameter("usuario", usuario);
            return query.getSingleResult();
        } catch (NoResultException e) {
            throw new EntidadNoEncontradaException("No se encontro el usuario: " + usuario);
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar empleado: " + e.getMessage(), e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
