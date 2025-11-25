/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import BO.interfaces.IPagoBO;
import DAO.PagoDAO;
import DAO.interfaces.IPagoDAO;
import Excepciones.PersistenciaException;
import Mappers.PagoMapper;
import Mappers.interfaces.IPagoMapper;
import dto.PagoDTO;
import entidades.Pago;
import excepciones.NegocioException;

/**
 *
 * @author Abraham Coronel
 */
public class PagoBO implements IPagoBO {

    private static IPagoBO instancia;
    private final IPagoDAO pagoDAO = PagoDAO.getInstancia();
    private final IPagoMapper pagoMapper = new PagoMapper();

    private PagoBO() {
    }

    public static IPagoBO getInstancia() {
        if (instancia == null) {
            instancia = new PagoBO();
        }
        return instancia;
    }

    @Override
    public PagoDTO registrarPago(PagoDTO pago) throws NegocioException {
        try {
            Pago pagoEntidad = pagoMapper.toEntity(pago);

            Pago pagoRegistrado = pagoDAO.registrarPago(pagoEntidad);

            return pagoMapper.toDTO(pagoRegistrado);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al registrar el pago: " + e.getMessage());
        }
    }
}
