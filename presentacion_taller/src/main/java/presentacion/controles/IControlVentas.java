/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package presentacion.controles;

import dto.VentaDTO;
import dto.VentaRefaccionDTO;
import java.util.List;

/**
 *
 * @author Pride Factor Black
 */
public interface IControlVentas {
    
    public VentaDTO crearVenta(List<VentaRefaccionDTO> detalles);
    public VentaDTO buscarVentaPorId(Long id);
    public List<VentaDTO> buscarTodasLasVentas();
}
