/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Pride Factor Black
 */
public class VentaDTO {
    private String id;
    private LocalDateTime fecha;
    private Double total;
    private List<VentaRefaccionDTO> refacciones;

    public VentaDTO() {
    }

    
    public VentaDTO(String id, LocalDateTime fecha, Double total, List<VentaRefaccionDTO> refacciones) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
        this.refacciones = refacciones;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<VentaRefaccionDTO> getRefacciones() {
        return refacciones;
    }

    public void setRefacciones(List<VentaRefaccionDTO> refacciones) {
        this.refacciones = refacciones;
    }
    
    
}
