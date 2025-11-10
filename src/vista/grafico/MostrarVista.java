package vista.grafico;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import modelo.Usuario;

import javax.swing.JInternalFrame;

/**
 * @author Dilan Rojas
 * @date Nov 5, 2025
 * @version 1.0
 * @description description
 */

public class MostrarVista extends JFrame {
	// Componentes gráficos
	private static final long serialVersionUID = 1L;
	private JTextField tfBuscarInput;
	private JButton btnBuscar;
	private JList<Usuario> listaUsuarios;
	private DefaultListModel<Usuario> modeloUsuarios;

	// Main (Pruebas)
	public static void main(String[] args) {
		MostrarVista vista = new MostrarVista();
	}

	// Constructor
	public MostrarVista() {
		initComponents();
        setTitle("Mostrar | CRUD");
        setSize(750, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
	}

	// Inicializar componentes
	public void initComponents() {
		getContentPane().setLayout(null);
		
        tfBuscarInput = new JTextField();
        tfBuscarInput.setToolTipText("");
        tfBuscarInput.setBounds(111, 52, 409, 38);
        getContentPane().add(tfBuscarInput);
        tfBuscarInput.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("Nombre | Nivel | Puntaje");
        lblNewLabel.setBounds(285, 23, 154, 17);
        getContentPane().add(lblNewLabel);
        
        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(532, 52, 85, 37);
        getContentPane().add(btnBuscar);
        
        modeloUsuarios = new DefaultListModel<>();
        listaUsuarios = new JList<Usuario>(modeloUsuarios);
        listaUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaUsuarios.setBounds(111, 125, 506, 206);
        getContentPane().add(listaUsuarios);
	}
	
	// Setters & Getters
	public String getTfBuscarInput() {
		return tfBuscarInput.getText();
	}

	public void setListaUsuarios(Usuario[] lista) {
		modeloUsuarios.clear();
		for (Usuario usuario : lista) {
			modeloUsuarios.addElement(usuario);
		}
	}
	
	// Obtener la lista de usuarios de la búsqueda
	public JList<Usuario> getListaUsuarios() {
	    return listaUsuarios;
	}
	
	// Configurar escuchadores
	public void setEscuchadores(ActionListener escuchador) {
		btnBuscar.addActionListener(escuchador);
		
	}
	
	public void setEscuchadorLista(MouseListener escuchador) {
		listaUsuarios.addMouseListener(escuchador);
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
