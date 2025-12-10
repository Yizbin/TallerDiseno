/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAO.interfaces.IPresupuestoRefaccionDAO;
import Excepciones.PersistenciaException;
import conexion.Conexion;
import entidades.PresupuestoRefaccion;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Pride Factor Black
 */
public class PresupuestoRefaccionDAO implements IPresupuestoRefaccionDAO{

   private static IPresupuestoRefaccionDAO instancia;

    private PresupuestoRefaccionDAO() {
    }

    public static IPresupuestoRefaccionDAO getInstancia() {
        if (instancia == null) {
            instancia = new PresupuestoRefaccionDAO();
        }
        return instancia;
    }

    @Override
    public List<PresupuestoRefaccion> buscarPorIdPresupuesto(Long idPresupuesto) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            String jpql = "SELECT pr FROM PresupuestoRefaccion pr WHERE pr.presupuesto.id_presupuesto = :id";
            TypedQuery<PresupuestoRefaccion> query = em.createQuery(jpql, PresupuestoRefaccion.class);
            query.setParameter("id", idPresupuesto);
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar refacciones del presupuesto: " + e.getMessage(), e);
        } finally {
            if (em != null) em.close();
        }
    }
}
