/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAO.interfaces.IVentaRefaccionDAO;
import Excepciones.EntidadDuplicadaException;
import Excepciones.EntidadNoEncontradaException;
import Excepciones.PersistenciaException;
import conexion.Conexion;
import entidades.VentaRefaccion;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Pride Factor Black
 */
public class VentaRefaccionDAO implements IVentaRefaccionDAO{
    
    public static IVentaRefaccionDAO instancia;

     public VentaRefaccionDAO() {
    }
     
    public static IVentaRefaccionDAO getInstancia() {
        if (instancia==null) {
            instancia = new VentaRefaccionDAO();
        }
        return instancia;
    }

   

    @Override
    public VentaRefaccion crearVentaRefaccion(VentaRefaccion ventaRefaccion) throws EntidadDuplicadaException, PersistenciaException {
         EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();

            em.persist(ventaRefaccion);
            em.getTransaction().commit();

            return ventaRefaccion;

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException(
                "Error al guardar la venta-refacción: " + e.getMessage(), e
            );

        } finally {
            if (em != null) em.close();
        }
    }

    @Override
    public VentaRefaccion actualizarVentaRefaccion(VentaRefaccion ventaRefaccion) throws EntidadNoEncontradaException, PersistenciaException {
        EntityManager em = Conexion.crearConexion();

        try {
            em.getTransaction().begin();

            validarVentaRefaccionExistente(em, ventaRefaccion.getId());

            VentaRefaccion actualizada = em.merge(ventaRefaccion);

            em.getTransaction().commit();

            return actualizada;

        } catch (EntidadNoEncontradaException e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;

        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw new PersistenciaException(
                "Error al actualizar la venta-refacción: " + e.getMessage(), e
            );

        } finally {
            if (em != null) em.close();
        }
    }

    @Override
    public VentaRefaccion buscarVentaRefaccionPorId(Long id) throws EntidadNoEncontradaException, PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            VentaRefaccion vr = em.find(VentaRefaccion.class, id);

            if (vr == null) {
                throw new EntidadNoEncontradaException(
                    "VentaRefaccion no encontrada con ID: " + id
                );
            }

            return vr;

        } catch (EntidadNoEncontradaException e) {
            throw e;

        } catch (Exception e) {
            throw new PersistenciaException(
                "Error al buscar venta-refacción por ID: " + e.getMessage(), e
            );

        } finally {
            if (em != null) em.close();
        }
    }

    @Override
    public List<VentaRefaccion> buscarTodasLasVentaRefacciones() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();

        try {
            TypedQuery<VentaRefaccion> query =
                em.createQuery("SELECT vr FROM VentaRefaccion vr", VentaRefaccion.class);

            return query.getResultList();

        } catch (Exception e) {
            throw new PersistenciaException(
                "Error al obtener todas las venta-refacciones: " + e.getMessage(), e
            );

        } finally {
            if (em != null) em.close();
        }
    }

    @Override
    public List<VentaRefaccion> buscarPorIdVenta(Long idVenta) throws PersistenciaException {
         EntityManager em = Conexion.crearConexion();

        try {
            TypedQuery<VentaRefaccion> query =
                em.createQuery("SELECT vr FROM VentaRefaccion vr WHERE vr.venta.id = :idVenta",
                        VentaRefaccion.class);

            query.setParameter("idVenta", idVenta);

            return query.getResultList();

        } catch (Exception e) {
            throw new PersistenciaException(
                "Error al buscar venta-refacciones por idVenta: " + e.getMessage(), e
            );

        } finally {
            if (em != null) em.close();
        }
    }
    
    private VentaRefaccion validarVentaRefaccionExistente(EntityManager em, Long id)
            throws EntidadNoEncontradaException {

        if (id == null) {
            throw new EntidadNoEncontradaException("El ID no puede ser nulo.");
        }

        VentaRefaccion vr = em.find(VentaRefaccion.class, id);

        if (vr == null) {
            throw new EntidadNoEncontradaException(
                "VentaRefaccion no encontrada con ID: " + id
            );
        }

        return vr;
    }
    
}
