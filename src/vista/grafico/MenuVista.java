package vista.grafico;

/**
 * @author Ana
 * @date Nov 5, 2025
 * @version 1.0
 * @description description
 */

import javax.swing.*;
import java.awt.event.ActionListener;

public class MenuVista extends JFrame {
	// Componentes gráficos
	private static final long serialVersionUID = 1L;
	private JMenuItem jM_Actualizar;
	private JMenuItem jM_Insertar;
	private JMenuItem jM_Eliminar;
	private JMenuItem jM_Mostrar;
	private JMenuItem jM_Config;
	private JMenuItem jM_Salir;

	// Main (Pruebas)
	public static void main(String[] args) {
		MenuVista menu = new MenuVista();
	}
	
	// Constructor
	public MenuVista() {
		initComponents();
		setTitle("MENÚ PRINCIPAL");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setVisible(true);
	}

	// Inicializar componentes
	private void initComponents() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuPrincipal = new JMenu("Opciones");
		menuBar.add(menuPrincipal);

		jM_Actualizar = new JMenuItem("Actualizar");
		menuPrincipal.add(jM_Actualizar);

		jM_Insertar = new JMenuItem("Insertar");
		menuPrincipal.add(jM_Insertar);

		jM_Eliminar = new JMenuItem("Eliminar");
		menuPrincipal.add(jM_Eliminar);

		jM_Mostrar = new JMenuItem("Mostrar");
		menuPrincipal.add(jM_Mostrar);

		jM_Config = new JMenuItem("Configuraciones");
		menuPrincipal.add(jM_Config);
		
		jM_Salir = new JMenuItem("Salir");
		menuPrincipal.add(jM_Salir);
	}

	// Setters & Getters
	public JMenuItem getjM_Actualizar() {
		return jM_Actualizar;
	}

	public JMenuItem getjM_Insertar() {
		return jM_Insertar;
	}

	public JMenuItem getjM_Eliminar() {
		return jM_Eliminar;
	}

	public JMenuItem getjM_Mostrar() {
		return jM_Mostrar;
	}

	public JMenuItem getjM_Config() {
		return jM_Config;
	}
	public JMenuItem getjM_Salir() {
		return jM_Salir;
	}

	// Configurar escuchadores
	public void setActionListener(ActionListener listener) {
		jM_Actualizar.addActionListener(listener);
		jM_Insertar.addActionListener(listener);
		jM_Eliminar.addActionListener(listener);
		jM_Mostrar.addActionListener(listener);
		jM_Config.addActionListener(listener);
		jM_Salir.addActionListener(listener);

		System.out.println("Vista - Menú listo para escuchar eventos");
	}

	// Método mostrar mensaje
	public void mostrarMsj(String msj) {
		JOptionPane.showMessageDialog(this, msj);
	}
	
	// Método cerrar
	public void cerrar() {
		System.out.println("CERRAR - Vista de Menú");
		dispose();
	}

}
