/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAO.interfaces.ITareaDAO;
import Excepciones.EntidadNoEncontradaException;
import Excepciones.PersistenciaException;
import conexion.Conexion;
import entidades.Empleado;
import entidades.Tarea;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Abraham Coronel
 */
public class TareaDAO implements ITareaDAO {

    private static ITareaDAO instancia;

    private TareaDAO() {
    }

    public static ITareaDAO getInstancia() {
        if (instancia == null) {
            instancia = new TareaDAO();
        }
        return instancia;
    }

    @Override
    public Tarea crearTarea(Tarea tarea) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();

            em.persist(tarea);
            em.getTransaction().commit();
            return tarea;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al guardar el tarea: " + e.getMessage(), e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Tarea actualizarTarea(Tarea tarea) throws EntidadNoEncontradaException, PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();

            validarTareaExistente(em, tarea.getId());

            Tarea tareaActualizar = em.merge(tarea);
            em.getTransaction().commit();
            return tareaActualizar;
        } catch (EntidadNoEncontradaException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al actualizar el tarea: " + e.getMessage(), e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void eliminarTarea(Long id) throws EntidadNoEncontradaException, PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();

            Tarea tarea = validarTareaExistente(em, id);

            em.remove(tarea);
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
            throw new PersistenciaException("Error al eliminar el tarea: " + e.getMessage(), e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Tarea> buscarTodasLasTareas() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            TypedQuery<Tarea> query = em.createQuery("SELECT t FROM Tarea t", Tarea.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener todas las tareas: " + e.getMessage(), e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Tarea> buscarTareaPorPresupuesto(Long idPresupuesto) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            TypedQuery<Tarea> query = em.createQuery("SELECT t FROM Tarea t WHERE t.presupuesto.id_presupuesto = :idPresupuesto", Tarea.class);
            query.setParameter("idPresupuesto", idPresupuesto);
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener todas las tareas: " + e.getMessage(), e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    private Tarea validarTareaExistente(EntityManager em, Long id) throws EntidadNoEncontradaException {
        if (id == null) {
            throw new EntidadNoEncontradaException("El ID de la tarea no puede ser nulo.");
        }
        Tarea tarea = em.find(Tarea.class, id);
        if (tarea == null) {
            throw new EntidadNoEncontradaException("Tarea no encontrada con ID: " + id);
        }
        return tarea;
    }

    @Override
    public List<Tarea> buscarTareasPorEmpleado(Long idEmpleado) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            TypedQuery<Tarea> query = em.createQuery(
                    "SELECT t FROM Tarea t WHERE t.empleado.id_empleado = :idEmpleado AND t.estado <> 'Completada'",
                    Tarea.class
            );
            query.setParameter("idEmpleado", idEmpleado);
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar tareas del empleado: " + e.getMessage(), e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Tarea buscarTareaPorId(Long id) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            return em.find(Tarea.class, id);
        } catch (Exception e) {
            throw new PersistenciaException("Error buscando tarea por ID: " + e.getMessage(), e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Tarea> obtenerTareas() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            return em.createQuery("SELECT t FROM Tarea t", Tarea.class).getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener tareas: " + e.getMessage(), e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public boolean asignarTareaAMecanico(Long idTarea, Long idMecanico) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();

            Tarea tarea = em.find(Tarea.class, idTarea);
            if (tarea == null) {
                throw new PersistenciaException("No se encontró la tarea con ID: " + idTarea);
            }

            Empleado mecanico = em.find(Empleado.class, idMecanico);
            if (mecanico == null) {
                throw new PersistenciaException("No se encontró el mecánico con ID: " + idMecanico);
            }

            tarea.setEmpleado(mecanico);
            tarea.setEstado("Asignada");

            em.merge(tarea);
            em.getTransaction().commit();
            return true;

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al asignar tarea al mecánico: " + e.getMessage(), e);
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }

    @Override
    public List<Tarea> buscarTareasSinAsignar() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            TypedQuery<Tarea> query = em.createQuery(
                    "SELECT DISTINCT t FROM Tarea t "
                    + "LEFT JOIN FETCH t.presupuesto p "
                    + "LEFT JOIN FETCH p.orden o "
                    + "LEFT JOIN FETCH o.vehiculo v "
                    + "WHERE t.empleado IS NULL "
                    + "AND LOWER(TRIM(t.estado)) = 'por realizar'",
                    Tarea.class
            );
            List<Tarea> listaTareas = query.getResultList(); // [Corregido] Solo una llamada aquí

            System.out.println("DAO → Tareas sin asignar encontradas: " + listaTareas.size());

            return listaTareas; // [Corregido] Retorna la lista
        } catch (Exception e) {
            throw new PersistenciaException("Error: " + e.getMessage(), e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
