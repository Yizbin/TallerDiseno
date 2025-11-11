/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package presentacion.utilerias;

import javax.swing.JPanel;

/**
 *
 * @author Abraham Coronel
 */
public interface ICreacionPaneles {

    public JPanel crearPanelCliente(String nombreCliente);
    
    public JPanel crearPanelVehiculo(String vehiculo);

    public JPanel crearPanelOrden(String textoOrden);

    public JPanel crearPanelTitulo(String titulo);

    public JPanel crearPanelInformativo(String texto, Boolean esDestacado);

    public JPanel crearSeparador(int altura);

}
