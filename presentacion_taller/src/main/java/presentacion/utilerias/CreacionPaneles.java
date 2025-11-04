/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.utilerias;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Abraham Coronel
 */
public class CreacionPaneles implements ICreacionPaneles {

    private static CreacionPaneles instancia;

    private CreacionPaneles() {
    }

    public static CreacionPaneles getInstancia() {
        if (instancia == null) {
            instancia = new CreacionPaneles();
        }
        return instancia;
    }

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
}
