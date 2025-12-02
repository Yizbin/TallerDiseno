/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestionarTareas;

import dto.TareaDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public interface IManejoTareas {

    public List<TareaDTO> buscarTareasAsignadas(String idMecanico) throws NegocioException;

    public void marcarTareaComoCompletada(String idTarea) throws NegocioException;

    public List<TareaDTO> obtenerTareasParaTabla() throws NegocioException;

    public boolean asignarTareaAMecanico(String idTarea, String idMecanico) throws NegocioException;
    
    List<TareaDTO> obtenerTareasSinAsignar() throws NegocioException;

    List<TareaDTO> obtenerTareasCompletadasPorMecanico(String idMecanico) throws NegocioException;

}
