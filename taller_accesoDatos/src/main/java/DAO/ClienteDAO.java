/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAO.interfaces.IClienteDAO;
import Excepciones.EntidadDuplicadaException;
import Excepciones.EntidadInactivaException;
import Excepciones.EntidadNoEncontradaException;
import Excepciones.PersistenciaException;
import conexion.Conexion;
import entidades.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author Abraham Coronel
 */
public class ClienteDAO implements IClienteDAO {

    private static IClienteDAO instancia;

    private ClienteDAO() {
    }

    public static IClienteDAO getInstancia() {
        if (instancia == null) {
            instancia = new ClienteDAO();
        }
        return instancia;
    }

    @Override
    public Cliente crearCliente(Cliente cliente) throws EntidadDuplicadaException, PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();

            validarClienteDuplicado(em, cliente.getCorreo());

            cliente.setActivo(true);
            em.persist(cliente);
            em.getTransaction().commit();
            return cliente;
        } catch (EntidadDuplicadaException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al guardar el cliente: " + e.getMessage(), e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) throws EntidadNoEncontradaException, EntidadInactivaException, PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();

            validarClienteParaActualizar(em, cliente.getId());

            Cliente clienteActualizado = em.merge(cliente);
            em.getTransaction().commit();
            return clienteActualizado;
        } catch (EntidadNoEncontradaException | EntidadInactivaException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al actualizar el cliente: " + e.getMessage(), e);
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }

    @Override
    public void desactivarCliente(Long id) throws EntidadNoEncontradaException, PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();

            Cliente cliente = validarClienteExistente(em, id);

            cliente.setActivo(false);
            em.merge(cliente);
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
            throw new PersistenciaException("Error al desactivar el cliente: " + e.getMessage(), e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Cliente> buscarTodosLosClientes() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            TypedQuery<Cliente> query = em.createQuery("SELECT c FROM Cliente c", Cliente.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener los clientes: " + e.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Cliente> buscarTodosLosClientesActivos() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            TypedQuery<Cliente> query = em.createQuery("SELECT c FROM Cliente c WHERE c.activo = true", Cliente.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener los clientes: " + e.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    private void validarClienteDuplicado(EntityManager em, String correo) throws EntidadDuplicadaException {
        try {
            TypedQuery<Long> query = em.createQuery(
                    "SELECT COUNT(c) FROM Cliente c WHERE c.correo = :correo", Long.class);
            query.setParameter("correo", correo);

            if (query.getSingleResult() > 0) {
                throw new EntidadDuplicadaException("Ya existe un cliente con el correo: " + correo);
            }
        } catch (NoResultException e) {
        }
    }

    private void validarClienteParaActualizar(EntityManager em, Long id) throws EntidadNoEncontradaException, EntidadInactivaException {
        Cliente cliente = em.find(Cliente.class, id);
        if (cliente == null) {
            throw new EntidadNoEncontradaException("No se puede actualizar: Cliente con ID " + id + " no existe.");
        }
        if (cliente.getActivo() == null || !cliente.getActivo()) {
            throw new EntidadInactivaException("No se puede actualizar: El cliente con ID " + id + " está inactivo.");
        }
    }

    private Cliente validarClienteExistente(EntityManager em, Long id) throws EntidadNoEncontradaException {
        Cliente cliente = em.find(Cliente.class, id);
        if (cliente == null) {
            throw new EntidadNoEncontradaException("Cliente no encontrado con ID: " + id);
        }
        return cliente;
    }

}
