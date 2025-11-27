/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionarTareas;

import BO.TareaBO;
import BO.interfaces.ITareaBO;
import dto.TareaDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public class ManejoTareas implements IManejoTareas {

    private static IManejoTareas instancia;
    private final ITareaBO tareaBO = TareaBO.getInstancia();

    private ManejoTareas() {
    }

    public static IManejoTareas getInstancia() {
        if (instancia == null) {
            instancia = new ManejoTareas();
        }
        return instancia;
    }

    @Override
    public List<TareaDTO> buscarTareasAsignadas(String idMecanico) throws NegocioException {
        try {
            return tareaBO.obtenerTareasPorMecanico(idMecanico);
        } catch (NumberFormatException e) {
            throw new NegocioException("ID de mecanico invalido");
        }
    }

    @Override
    public void marcarTareaComoCompletada(String idTarea) throws NegocioException {
        try {
            tareaBO.completarTarea(idTarea);
        } catch (NumberFormatException e) {
            throw new NegocioException("ID de tarea invalido");
        }
    }

}
