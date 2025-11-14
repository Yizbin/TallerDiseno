/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.controles;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import presentacion.utilerias.ICreacionPaneles;
import presentacion.utilerias.ICreacionTablas;

/**
 *
 * @author Abraham Coronel
 */
public class ControlCreacionUI implements IControlCreacionUI {

    private final ICreacionPaneles creacionPaneles;
    private final ICreacionTablas creacionTablas;

    public ControlCreacionUI(ICreacionPaneles creacionPaneles, ICreacionTablas creacionTablas) {
        this.creacionPaneles = creacionPaneles;
        this.creacionTablas = creacionTablas;
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

    @Override
    public void aplicarEstiloTabla(JScrollPane scrollpane, JTable tabla) {
        creacionTablas.aplicarEstiloTabla(scrollpane, tabla);
    }
}
