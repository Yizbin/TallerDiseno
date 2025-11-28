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
    
    public List<TareaDTO> buscarTareasDisponibles() throws NegocioException;

    public void asignarTareaAMecanico(String idTarea, String idEmpleado) throws NegocioException;
}
