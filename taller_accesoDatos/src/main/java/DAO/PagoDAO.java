/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAO.interfaces.IPagoDAO;
import Excepciones.PersistenciaException;
import conexion.Conexion;
import entidades.Pago;
import entidades.Presupuesto;
import javax.persistence.EntityManager;

/**
 *
 * @author Abraham Coronel
 */
public class PagoDAO implements IPagoDAO {

    private static IPagoDAO instancia;

    private PagoDAO() {
    }

    public static IPagoDAO getInstancia() {
        if (instancia == null) {
            instancia = new PagoDAO();
        }
        return instancia;
    }

    @Override
    public Pago registrarPago(Pago pago) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.persist(pago);
            Presupuesto presupuesto = pago.getPresupuesto();
            if (presupuesto != null) {
                Presupuesto presupuestoGestionado = em.merge(presupuesto);
                presupuestoGestionado.setEstado(true); // true = Pagado
            }

            em.getTransaction().commit();
            return pago;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al registrar el pago: " + e.getMessage(), e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
