/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package presentacion.controles;

import dto.RefaccionDTO;

import java.util.List;

/**
 *
 * @author Pride Factor Black
 */
public interface IControlRefacciones {
    
    public RefaccionDTO crearRefaccion(RefaccionDTO refaccionDTO);
       
    public RefaccionDTO actualizarRefaccion(RefaccionDTO refaccionDTO);
        
    public List<RefaccionDTO> buscarTodasLasRefacciones();
       
    public RefaccionDTO buscarRefaccionPorId(String id);
}
