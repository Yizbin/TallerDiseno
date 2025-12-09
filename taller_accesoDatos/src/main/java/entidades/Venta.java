
package entidades;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Pride Factor Black
 */

@Entity
@Table(name = "venta")
public class Venta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "total", nullable = false)
    private Double total;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VentaRefaccion> refacciones;

    public Venta() {
    }

    public Venta(Long id, LocalDateTime fecha, Double total, List<VentaRefaccion> refacciones) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
        this.refacciones = refacciones;
        asignarVentaARefacciones();
    }

    public Venta(LocalDateTime fecha, Double total, List<VentaRefaccion> refacciones) {
        this.fecha = fecha;
        this.total = total;
        this.refacciones = refacciones;
        asignarVentaARefacciones();
    }

    private void asignarVentaARefacciones() {
        if (refacciones != null) {
            for (VentaRefaccion vr : refacciones) {
                vr.setVenta(this);
            }
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<VentaRefaccion> getRefacciones() {
        return refacciones;
    }

    public void setRefacciones(List<VentaRefaccion> refacciones) {
        this.refacciones = refacciones;
        asignarVentaARefacciones();
    }
}
