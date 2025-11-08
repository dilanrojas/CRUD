package vista.grafico;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * @author Dilan Rojas
 * @date Nov 5, 2025
 * @version 1.0
 * @description description
 */

public class MostrarUsuarioVista extends JFrame {
	// Componentes gráficos
	private static final long serialVersionUID = 1L;
	private JTextField tfNombre;
	private JTextField tfNivel;
	private JTextField tfPuntaje;

	// Main (Pruebas)
	public static void main(String[] args) {
		MostrarUsuarioVista vista = new MostrarUsuarioVista();
	}

	// Constructor
	public MostrarUsuarioVista() {
        setTitle("Usuario | CRUD");
        setSize(250, 320);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
	}
	
	// Inicializar componentes
	public void initComponents() {
		getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(33, 12, 75, 17);
        getContentPane().add(lblNombre);
        
        tfNombre = new JTextField();
        tfNombre.setEditable(false);
        tfNombre.setBounds(33, 37, 114, 21);
        getContentPane().add(tfNombre);
        tfNombre.setColumns(10);
        
        tfNivel = new JTextField();
        tfNivel.setEditable(false);
        tfNivel.setColumns(10);
        tfNivel.setBounds(33, 109, 114, 21);
        getContentPane().add(tfNivel);
        
        JLabel lblN = new JLabel("Nivel");
        lblN.setBounds(33, 84, 75, 17);
        getContentPane().add(lblN);
        
        tfPuntaje = new JTextField();
        tfPuntaje.setEditable(false);
        tfPuntaje.setColumns(10);
        tfPuntaje.setBounds(33, 193, 114, 21);
        getContentPane().add(tfPuntaje);
        
        JLabel lblPuntaje = new JLabel("Puntaje");
        lblPuntaje.setBounds(33, 168, 75, 17);
        getContentPane().add(lblPuntaje);
	}

	// Setters
	public void setTfNombre(JTextField tfNombre) {
		this.tfNombre = tfNombre;
	}

	public void setTfNivel(JTextField tfNivel) {
		this.tfNivel = tfNivel;
	}


	public void setTfPuntaje(JTextField tfPuntaje) {
		this.tfPuntaje = tfPuntaje;
	};

	// Método mostrar mensaje
	public void mostrarMsj(String msg) {
		JOptionPane.showMessageDialog(this, msg, "CRUD", JOptionPane.INFORMATION_MESSAGE);
     }
	
	// Método cerrar
	public void cerrar() {
		dispose();
	}
}
