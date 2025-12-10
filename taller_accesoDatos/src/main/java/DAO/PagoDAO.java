
package DAO;

import DAO.interfaces.IPagoDAO;
import Excepciones.PersistenciaException;
import conexion.Conexion;
import entidades.Pago;
import entidades.Presupuesto;
import entidades.Venta;
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
        return guardarPago(pago);
    }

    @Override
    public Pago guardarPago(Pago pago) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion(); 
        try {
            em.getTransaction().begin();

            if (pago.getPresupuesto() != null && pago.getPresupuesto().getId() != null) {
                Long idPresupuesto = pago.getPresupuesto().getId();
                Presupuesto presupuestoReal = em.find(Presupuesto.class, idPresupuesto);

                if (presupuestoReal == null) {
                    throw new PersistenciaException("No se encontro el presupuesto con ID: " + idPresupuesto);
                }

                presupuestoReal.setEstado(true); 
                pago.setPresupuesto(presupuestoReal);
                pago.setVenta(null); 
            } 
            else if (pago.getVenta() != null && pago.getVenta().getId() != null) {
                Long idVenta = pago.getVenta().getId();
                Venta ventaReal = em.find(Venta.class, idVenta);

                if (ventaReal == null) {
                    throw new PersistenciaException("No se encontro la venta con ID: " + idVenta);
                }

                pago.setVenta(ventaReal);
                pago.setPresupuesto(null);
            } 
            else {
                pago.setPresupuesto(null);
                pago.setVenta(null);
            }

            em.persist(pago);
            em.getTransaction().commit();

            return pago;

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace(); // Agregado para ver errores en consola
            throw new PersistenciaException("Error al registrar el pago: " + e.getMessage(), e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
