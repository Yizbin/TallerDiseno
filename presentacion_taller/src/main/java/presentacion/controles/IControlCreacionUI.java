/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package presentacion.controles;

import dto.ServicioDTO;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Abraham Coronel
 */
public interface IControlCreacionUI {

    public JPanel crearPanelCliente(String nombreCliente);

    public JPanel crearPanelVehiculo(String vehiculo);

    public JPanel crearPanelOrden(String textoOrden);

    public JPanel crearPanelTitulo(String titulo);

    public JPanel crearPanelInformativo(String texto, Boolean esDestacado);

    public JPanel crearSeparador(int altura);
    
    public void aplicarEstiloTabla(JScrollPane scrollpane, JTable tabla);
    
    public JPanel crearPanelServicio(String nombre, double precio, String descripcion);
    
    public JPanel crearPanelRefaccion(String nombre, double precio, int stock);
}
