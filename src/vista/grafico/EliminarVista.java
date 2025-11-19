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

public class EliminarVista extends JFrame {
	// Componentes gráficos
	private static final long serialVersionUID = 1L;
	private JTextField tfNombre;
	private JTextField tfNivel;
	private JTextField tfPuntaje;
	private JTextField tfID;
	private JButton btnEliminar;
	private JButton btnCancelar;

	// Main (Pruebas)
	public static void main(String[] args) {
		EliminarVista vista = new EliminarVista();
	}

	// Constructor
	public EliminarVista() {
		initComponents();
		
        setTitle("Usuario | CRUD");
        setSize(300, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(false);
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
        
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(36, 354, 186, 27);
        getContentPane().add(btnEliminar);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(36, 393, 186, 27);
        getContentPane().add(btnCancelar);
	}
	
	// Getters
	public JButton getBtnEliminar() {
		return btnEliminar;
	}
	
	public JButton getBtnCancelar() {
		return btnCancelar;
	}
	
	public int getID() {
		return Integer.parseInt(tfID.getText());
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
		this.btnEliminar.addActionListener(escuchador);
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
