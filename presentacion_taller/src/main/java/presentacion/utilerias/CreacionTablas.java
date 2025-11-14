/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.utilerias;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Abraham Coronel
 */
public class CreacionTablas implements ICreacionTablas {

    private static final Color COLOR_FONDO_PRINCIPAL = new Color(142, 0, 0);
    private static final Color COLOR_TABLA = new Color(198, 40, 40);
    private static final Color COLOR_TEXTO = Color.WHITE;
    private static final Font FUENTE_DATOS = new Font("JetBrains Mono NL", Font.PLAIN, 14);
    private static final Font FUENTE_HEADER = new Font("JetBrains Mono NL ExtraBold", Font.BOLD, 16);

    @Override
    public void aplicarEstiloTabla(JScrollPane scrollPane, JTable tabla) {

        scrollPane.getViewport().setBackground(COLOR_FONDO_PRINCIPAL);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        tabla.setBackground(COLOR_TABLA);
        tabla.setForeground(COLOR_TEXTO);
        tabla.setGridColor(COLOR_FONDO_PRINCIPAL); 
        tabla.setRowHeight(30);
        tabla.setFont(FUENTE_DATOS);

        tabla.setSelectionBackground(Color.WHITE);
        tabla.setSelectionForeground(COLOR_FONDO_PRINCIPAL);

        JTableHeader header = tabla.getTableHeader();
        header.setBackground(COLOR_TABLA);
        header.setForeground(COLOR_TEXTO);
        header.setFont(FUENTE_HEADER);
        header.setPreferredSize(new Dimension(100, 40));

        header.setReorderingAllowed(false);
    }
}
