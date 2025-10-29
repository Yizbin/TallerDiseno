/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

/**
 *
 * @author payde
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * * * @author payde
 */
public class clientePanel extends JPanel {

    public clientePanel(String nombreCliente) {
        
        setLayout(new BorderLayout(0, 0));
        setPreferredSize(new Dimension(280, 30));
        setMaximumSize(new Dimension(280, 30));
        setOpaque(false);

        JLabel lblNombre = new JLabel(nombreCliente, SwingConstants.LEFT);
        lblNombre.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        lblNombre.setForeground(Color.WHITE);

        lblNombre.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));

        add(lblNombre, BorderLayout.CENTER);

        setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
    }
}
