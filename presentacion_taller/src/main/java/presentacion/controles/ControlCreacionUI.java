/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.controles;

import javax.swing.JPanel;
import presentacion.utilerias.ICreacionPaneles;

/**
 *
 * @author Abraham Coronel
 */
public class ControlCreacionUI implements IControlCreacionUI {

    private final ICreacionPaneles creacionPaneles;

    public ControlCreacionUI(ICreacionPaneles creacionPaneles) {
        this.creacionPaneles = creacionPaneles;
    }

    @Override
    public JPanel crearPanelCliente(String nombreCliente) {
        return creacionPaneles.crearPanelCliente(nombreCliente);
    }

    @Override
    public JPanel crearPanelVehiculo(String vehiculo) {
        return creacionPaneles.crearPanelVehiculo(vehiculo);
    }

    @Override
    public JPanel crearPanelOrden(String textoOrden) {
        return creacionPaneles.crearPanelOrden(textoOrden);
    }

    @Override
    public JPanel crearPanelTitulo(String titulo) {
        return creacionPaneles.crearPanelTitulo(titulo);
    }

    @Override
    public JPanel crearPanelInformativo(String texto, Boolean esDestacado) {
        return creacionPaneles.crearPanelInformativo(texto, esDestacado);
    }

    @Override
    public JPanel crearSeparador(int altura) {
        return creacionPaneles.crearSeparador(altura);
    }
}
