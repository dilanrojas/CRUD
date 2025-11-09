package vista.grafico;
/**
 * @author Ana
 * @date Nov 5, 2025
 * @version 1.0
 * @description Clase vista-actualizar para crear la vista grafica del actualizar datos
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ActualizarVista extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTextField txtBuscar;
	private JButton btnBuscar, btnSeleccionar, btnCerrar;
	private JList<String> listaUsuarios; 
	private JButton btnRegresar;

	// Main para pruebas
	public static void main(String[] args) {
		ActualizarVista vista = new ActualizarVista();
	}

	// Constructor
	public ActualizarVista() {
		setTitle("Actualizar");
		setSize(500, 450);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents();
		setVisible(true);
	}

	public void initComponents() {
		getContentPane().setLayout(null);

		JLabel lblBuscar = new JLabel("Buscar usuario:");
		lblBuscar.setFont(new Font("Monospaced", Font.BOLD, 14));
		lblBuscar.setBounds(10, 55, 150, 25);
		getContentPane().add(lblBuscar);

		txtBuscar = new JTextField();
		txtBuscar.setBounds(170, 56, 180, 25);
		getContentPane().add(txtBuscar);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(376, 56, 100, 25);
		getContentPane().add(btnBuscar);
		
		JScrollPane scrollLista = new JScrollPane();
		scrollLista.setBounds(26, 123, 400, 150);
		getContentPane().add(scrollLista);

		listaUsuarios = new JList<>();
		scrollLista.setViewportView(listaUsuarios);

		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setBounds(93, 304, 100, 25);
		getContentPane().add(btnSeleccionar);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(241, 304, 100, 25);
		getContentPane().add(btnCerrar);
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.setBounds(170, 357, 93, 25);
		getContentPane().add(btnRegresar);
	}

	// Getters
	public JTextField getTxtBuscar() {
		return txtBuscar;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public JButton getBtnSeleccionar() {
		return btnSeleccionar;
	}

	public JButton getBtnCerrar() {
		return btnCerrar;
	}

	public JButton getBtnRegresar() {
		return btnRegresar;
	}

	public JList<String> getListaUsuarios() {
		return listaUsuarios;
	}

	// Mostrar mensajes
	public void mostrarMsj(String msj) {
		JOptionPane.showMessageDialog(this, msj);
	}

	// Escuchadores
	public void setEscuchadores(ActionListener e) {
		btnBuscar.addActionListener(e);
		btnSeleccionar.addActionListener(e);
		btnCerrar.addActionListener(e);
		btnRegresar.addActionListener(e);
	}

	public void cerrar() {
		dispose();
	}
}
