package juego.vista.grafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * @author AnaGonzalezC5F593
 * @date 19 nov 2025
 * @version 1.0
 * @description TODO
 */

public class MenuJuegoVista extends JFrame {

	private static final long serialVersionUID = 1L;

	public MenuJuegoVista() {
		initComponents();
        setTitle("Menu de juego");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        setVisible(true);
	}
	private void initComponents() {
		
	}

}

