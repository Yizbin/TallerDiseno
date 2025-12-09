/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAO.interfaces.IVehiculoDAO;
import DAO.interfaces.IVentaDAO;
import Excepciones.PersistenciaException;
import conexion.Conexion;
import entidades.Venta;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Pride Factor Black
 */
public class VentaDAO implements IVentaDAO{
    
    private static IVentaDAO instancia;

    public static IVentaDAO getInstancia() {
        return instancia;
    }
    
    @Override
    public Venta crearVenta(Venta venta) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.persist(venta);
            em.getTransaction().commit();
            return venta;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw new PersistenciaException("Error al guardar la venta: " + e.getMessage(), e);
        } finally {
            if (em != null) em.close();
        }
    }

    @Override
    public Venta buscarVentaPorId(Long id) throws PersistenciaException {
         EntityManager em = Conexion.crearConexion();
        try {
            Venta v = em.find(Venta.class, id);
            return v;
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar venta por id: " + e.getMessage(), e);
        } finally {
            if (em != null) em.close();
        }
    }

    @Override
    public List<Venta> buscarTodasLasVentas() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            TypedQuery<Venta> query = em.createQuery("SELECT v FROM Venta v", Venta.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener ventas: " + e.getMessage(), e);
        } finally {
            if (em != null) em.close();
        }
    }
    
}
    

