/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.utilerias;

import dto.ServicioDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Abraham Coronel
 */
public class CreacionPaneles implements ICreacionPaneles {

    private static final Font FUENTE_TITULO = new Font("Century Gothic", Font.BOLD, 16);
    private static final Font FUENTE_NORMAL = new Font("Century Gothic", Font.PLAIN, 14);
    private static final Font FUENTE_PEQUENA = new Font("Century Gothic", Font.PLAIN, 12);

    private static final Color COLOR_TEXTO_PRIMARY = Color.WHITE;
    private static final Color COLOR_BORDE = Color.WHITE;

    @Override
    public JPanel crearPanelCliente(String nombreCliente) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(0, 0));
        panel.setPreferredSize(new Dimension(280, 30));
        panel.setMaximumSize(new Dimension(280, 30));
        panel.setOpaque(false);

        panel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JLabel lblNombre = new JLabel(nombreCliente, SwingConstants.LEFT);
        lblNombre.setFont(FUENTE_NORMAL);
        lblNombre.setForeground(COLOR_TEXTO_PRIMARY);
        lblNombre.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));

        panel.add(lblNombre, BorderLayout.CENTER);
        panel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, COLOR_BORDE));

        return panel;
    }

    @Override
    public JPanel crearPanelVehiculo(String vehiculo) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(0, 0));
        panel.setPreferredSize(new Dimension(260, 30));
        panel.setMaximumSize(new Dimension(260, 30));
        panel.setOpaque(false);

        panel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JLabel lblNombre = new JLabel(vehiculo, SwingConstants.LEFT);
        lblNombre.setFont(FUENTE_NORMAL);
        lblNombre.setForeground(COLOR_TEXTO_PRIMARY);
        lblNombre.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));

        panel.add(lblNombre, BorderLayout.CENTER);
        panel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, COLOR_BORDE));

        return panel;
    }

    @Override
    public JPanel crearPanelOrden(String textoOrden) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(5, 5));
        panel.setPreferredSize(new Dimension(300, 40));
        panel.setMaximumSize(new Dimension(300, 40));
        panel.setOpaque(false);

        JLabel lblOrden = new JLabel(textoOrden, SwingConstants.LEFT);
        lblOrden.setFont(FUENTE_NORMAL);
        lblOrden.setForeground(COLOR_TEXTO_PRIMARY);
        lblOrden.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        panel.add(lblOrden, BorderLayout.CENTER);
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(COLOR_BORDE, 1),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));

        return panel;
    }

    @Override
    public JPanel crearPanelTitulo(String titulo) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setOpaque(false);

        JLabel lblTitulo = new JLabel(titulo, SwingConstants.CENTER);
        lblTitulo.setFont(FUENTE_TITULO);
        lblTitulo.setForeground(COLOR_TEXTO_PRIMARY);
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(lblTitulo, BorderLayout.CENTER);

        return panel;
    }

    @Override
    public JPanel crearPanelInformativo(String texto, Boolean esDestacado) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setOpaque(false);

        JLabel lblTexto = new JLabel(texto, SwingConstants.LEFT);
        lblTexto.setFont(esDestacado ? FUENTE_TITULO : FUENTE_NORMAL);
        lblTexto.setForeground(COLOR_TEXTO_PRIMARY);
        lblTexto.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        panel.add(lblTexto, BorderLayout.CENTER);

        if (esDestacado) {
            panel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, COLOR_BORDE));
        }

        return panel;
    }
    
    

    @Override
    public JPanel crearSeparador(int altura) {
        JPanel separador = new JPanel();
        separador.setPreferredSize(new Dimension(1, altura));
        separador.setMaximumSize(new Dimension(Integer.MAX_VALUE, altura));
        separador.setOpaque(false);
        return separador;
    }

    public Font getFuenteTitulo() {
        return FUENTE_TITULO;
    }

    public Font getFuenteNormal() {
        return FUENTE_NORMAL;
    }

    public Font getFuentePequena() {
        return FUENTE_PEQUENA;
    }

    @Override
    public JPanel crearPanelServicio(String nombre, double precio, String descripcion) {
         JPanel panel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
           
            g.setColor(Color.WHITE);
            g.drawLine(0, 0, getWidth(), 0);
            g.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
        }
    };
        panel.setLayout(new BorderLayout());
        panel.setOpaque(false);
        panel.setPreferredSize(new Dimension(450, 90));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));


        JLabel lblNombre = new JLabel(nombre);
        lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblNombre.setForeground(Color.WHITE);

        JLabel lblDescripcion = new JLabel(descripcion);
        lblDescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblDescripcion.setForeground(Color.WHITE);

        JLabel lblPrecio = new JLabel("$" + precio);
        lblPrecio.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblPrecio.setForeground(Color.WHITE);


        JPanel panelTexto = new JPanel();
        panelTexto.setOpaque(false);
        panelTexto.setLayout(new GridLayout(3, 1));
        panelTexto.add(lblNombre);
        panelTexto.add(lblDescripcion);
        panelTexto.add(lblPrecio);

        JCheckBox chkSeleccion = new JCheckBox();
        chkSeleccion.setOpaque(false);
        chkSeleccion.setForeground(Color.WHITE); 

        panel.add(panelTexto, BorderLayout.CENTER);
        panel.add(chkSeleccion, BorderLayout.EAST);

        return panel;
    }

    @Override
    public JPanel crearPanelRefaccion(String nombre, double precio, int stock) {
        JPanel panel = new JPanel() {
       
            @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.WHITE);
            g.drawLine(0, 0, getWidth(), 0);
            g.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
        }
    };

        panel.setLayout(new BorderLayout());
        panel.setOpaque(false);
        panel.setPreferredSize(new Dimension(450, 90));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        JLabel lblNombre = new JLabel(nombre);
        lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblNombre.setForeground(Color.WHITE);

        JLabel lblPrecio = new JLabel("Precio: $" + precio);
        lblPrecio.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblPrecio.setForeground(Color.WHITE);

        JLabel lblStock = new JLabel("Stock: " + stock);
        lblStock.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblStock.setForeground(Color.WHITE);

        JPanel panelTexto = new JPanel();
        panelTexto.setOpaque(false);
        panelTexto.setLayout(new GridLayout(3, 1));
        panelTexto.add(lblNombre);
        panelTexto.add(lblPrecio);
        panelTexto.add(lblStock);

        JPanel panelDerecho = new JPanel();
        panelDerecho.setOpaque(false);
        panelDerecho.setLayout(new FlowLayout(FlowLayout.RIGHT));

        panel.add(panelTexto, BorderLayout.CENTER);
        panel.add(panelDerecho, BorderLayout.EAST);

        return panel;
    }
}
