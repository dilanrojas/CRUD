package vista.grafico;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JButton;
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

public class ActualizarUsuarioVista extends JFrame {
	// Componentes gráficos
	private static final long serialVersionUID = 1L;
	private JTextField tfNombre;
	private JTextField tfNivel;
	private JTextField tfPuntaje;
	private JTextField tfID;
	private JTextField tfNuevaContrasena;
	private JButton btnCambiar;
	private JButton btnCancelar;

	// Main (Pruebas)
	public static void main(String[] args) {
		ActualizarUsuarioVista vista = new ActualizarUsuarioVista();
	}

	// Constructor
	public ActualizarUsuarioVista() {
		initComponents();
		
        setTitle("Usuario | CRUD");
        setSize(300, 520);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
	}
	
	// Inicializar componentes
	public void initComponents() {
		getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(36, 46, 75, 17);
        getContentPane().add(lblNombre);
        
        tfNombre = new JTextField();
        tfNombre.setEditable(false);
        tfNombre.setBounds(36, 71, 186, 21);
        getContentPane().add(tfNombre);
        tfNombre.setColumns(10);
        
        tfNivel = new JTextField();
        tfNivel.setEditable(false);
        tfNivel.setColumns(10);
        tfNivel.setBounds(36, 143, 186, 21);
        getContentPane().add(tfNivel);
        
        JLabel lblN = new JLabel("Nivel");
        lblN.setBounds(36, 118, 75, 17);
        getContentPane().add(lblN);
        
        tfPuntaje = new JTextField();
        tfPuntaje.setEditable(false);
        tfPuntaje.setColumns(10);
        tfPuntaje.setBounds(36, 227, 186, 21);
        getContentPane().add(tfPuntaje);
        
        JLabel lblPuntaje = new JLabel("Puntaje");
        lblPuntaje.setBounds(36, 202, 75, 17);
        getContentPane().add(lblPuntaje);
        
        JLabel lblId = new JLabel("ID");
        lblId.setBounds(36, 277, 75, 17);
        getContentPane().add(lblId);
        
        tfID = new JTextField();
        tfID.setEditable(false);
        tfID.setColumns(10);
        tfID.setBounds(36, 302, 186, 21);
        getContentPane().add(tfID);
        
        tfNuevaContrasena = new JTextField();
        tfNuevaContrasena.setText("Nueva contraseña");
        tfNuevaContrasena.setBounds(36, 358, 186, 34);
        getContentPane().add(tfNuevaContrasena);
        tfNuevaContrasena.setColumns(10);
        
        btnCambiar = new JButton("Cambiar");
        btnCambiar.setBounds(36, 404, 186, 27);
        getContentPane().add(btnCambiar);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(36, 443, 186, 27);
        getContentPane().add(btnCancelar);
	}
	
	// Getters
	public JButton getBtnCambiar() {
		return btnCambiar;
	}
	
	public JButton getBtnCancelar() {
		return btnCancelar;
	}
	
	public String getNuevaContrasena() {
		return tfNuevaContrasena.getText();
	}
	
	public String getID() {
		return tfID.getText();
	}

	// Setters
	public void setTfNombre(String nombre) {
		this.tfNombre.setText(nombre);;
	}

	public void setTfNivel(int nivel) {
		this.tfNivel.setText("" + nivel);;
	}

	public void setTfPuntaje(int puntaje) {
		this.tfPuntaje.setText("" + puntaje);;
	}
	
	public void setTfID(int id) {
		this.tfID.setText("" + id);;
	}
	
	@Override
	public void setVisible(boolean value) {
	    super.setVisible(value);
	}
	
	// Escuchadores
	public void setEscuchadores(ActionListener escuchador) {
		this.btnCambiar.addActionListener(escuchador);
		this.btnCancelar.addActionListener(escuchador);
	}

	// Método mostrar mensaje
	public void mostrarMsj(String msg) {
		JOptionPane.showMessageDialog(this, msg, "CRUD", JOptionPane.INFORMATION_MESSAGE);
    }
	
	// Método cerrar
	public void cerrar() {
		dispose();
	}
}
