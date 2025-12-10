/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAO.interfaces.IServicioPresupuestoDAO;
import Excepciones.PersistenciaException;
import conexion.Conexion;
import entidades.ServicioPresupuesto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Pride Factor Black
 */
    public class ServicioPresupuestoDAO implements IServicioPresupuestoDAO{
        private static IServicioPresupuestoDAO instancia;

        private ServicioPresupuestoDAO() {
        }

        public static IServicioPresupuestoDAO getInstancia() {
            if (instancia == null) {
                instancia = new ServicioPresupuestoDAO();
            }
            return instancia;
        }

    @Override
    public List<ServicioPresupuesto> buscarPorIdPresupuesto(Long idPresupuesto) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            String jpql = "SELECT sp FROM ServicioPresupuesto sp WHERE sp.presupuesto.id_presupuesto = :id";
            TypedQuery<ServicioPresupuesto> query = em.createQuery(jpql, ServicioPresupuesto.class);
            query.setParameter("id", idPresupuesto);
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar servicios del presupuesto: " + e.getMessage(), e);
        } finally {
            if (em != null) em.close();
        }
    }
}
