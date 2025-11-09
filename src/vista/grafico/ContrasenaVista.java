package vista.grafico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ContrasenaVista extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTextField txtNombre, txtNivel, txtPuntaje, txtID;
	private JTextField txtNuevaContra;
	private JLabel lblTitulo, lblNombre, lblNivel, lblPuntaje, lblNuevaContra, lblID;
	private JButton btnGuardar, btnCancelar;

	// Main (para pruebas)
	public static void main(String[] args) {
		ContrasenaVista vista = new ContrasenaVista();
	}

	public ContrasenaVista() {
		initComponents();
		setTitle("Modificar Contraseña");
		setSize(500, 350);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void initComponents() {
		lblTitulo = new JLabel("Actualizar Contraseña del Usuario");
		lblTitulo.setFont(new Font("Monospaced", Font.BOLD, 14));
		lblTitulo.setBounds(60, 20, 300, 25);
		getContentPane().add(lblTitulo);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(60, 70, 100, 25);
		getContentPane().add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(160, 70, 150, 25);
		txtNombre.setEditable(false);
		getContentPane().add(txtNombre);

		lblNivel = new JLabel("Nivel:");
		lblNivel.setBounds(60, 110, 100, 25);
		getContentPane().add(lblNivel);

		txtNivel = new JTextField();
		txtNivel.setBounds(160, 110, 150, 25);
		txtNivel.setEditable(false);
		getContentPane().add(txtNivel);

		lblPuntaje = new JLabel("Puntaje:");
		lblPuntaje.setBounds(60, 150, 100, 25);
		getContentPane().add(lblPuntaje);

		txtPuntaje = new JTextField();
		txtPuntaje.setBounds(160, 150, 150, 25);
		txtPuntaje.setEditable(false);
		getContentPane().add(txtPuntaje);

		lblID = new JLabel("ID:");
		lblID.setBounds(60, 190, 100, 25);
		getContentPane().add(lblID);

		txtID = new JTextField();
		txtID.setBounds(160, 190, 150, 25);
		txtID.setEditable(false);
		getContentPane().add(txtID);

		lblNuevaContra = new JLabel("Nueva Contraseña:");
		lblNuevaContra.setBounds(60, 230, 120, 25);
		getContentPane().add(lblNuevaContra);

		txtNuevaContra = new JTextField();
		txtNuevaContra.setBounds(190, 230, 150, 25);
		getContentPane().add(txtNuevaContra);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(90, 270, 100, 30);
		getContentPane().add(btnGuardar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(210, 270, 100, 30);
		getContentPane().add(btnCancelar);
	}

	// Getters
	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public JTextField getTxtNivel() {
		return txtNivel;
	}

	public JTextField getTxtPuntaje() {
		return txtPuntaje;
	}

	public JTextField getTxtID() {
		return txtID;
	}

	public JTextField getTxtNuevaContra() {
		return txtNuevaContra;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	// Método mostrar
	public void mostrarMsj(String msj) {
		JOptionPane.showMessageDialog(this, msj);
	}

	// Métodos para escuchar
	public void setEscuchadores(ActionListener e) {
		btnGuardar.addActionListener(e);
		btnCancelar.addActionListener(e);
	}

	public void cerrar() {
		dispose();
	}
}