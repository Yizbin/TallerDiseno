/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BO.interfaces;

import dto.TareaDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public interface ITareaBO {

    List<TareaDTO> obtenerTareasPorMecanico(String idMecanico) throws NegocioException;

    public void completarTarea(String idTarea) throws NegocioException;

    List<TareaDTO> obtenerTareasParaTabla() throws NegocioException;

    boolean asignarTareaAMecanico(Long idTarea, Long idMecanico) throws NegocioException;

    List<TareaDTO> obtenerTareasSinAsignar() throws NegocioException;

}
