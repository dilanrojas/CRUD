package vista.grafico;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ActualizarVista extends JFrame {
	private static final long serialVersionUID = 1L;
	private JRadioButton rbtnNombre, rbtnNivel, rbtnPuntaje;
	private JTextField txtBuscar, txtNombre, txtNivel, txtPuntaje, txtNuevaContra;
	private JButton btnBuscar, btnActualizar, btnCerrar;

	public static void main(String[] args) {
		ActualizarVista ac = new ActualizarVista();
	}

	public ActualizarVista() {
		setTitle("Actualizar");
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents();
		setVisible(true);
	}

	public void initComponents() {
		getContentPane().setLayout(null);

		JLabel lblBuscarPor = new JLabel("Buscar por:");
		lblBuscarPor.setBounds(10, 11, 100, 25);
		getContentPane().add(lblBuscarPor);

		rbtnNombre = new JRadioButton("Nombre");
		rbtnNivel = new JRadioButton("Nivel");
		rbtnPuntaje = new JRadioButton("Puntaje");

		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rbtnNombre);
		grupo.add(rbtnNivel);
		grupo.add(rbtnPuntaje);

		rbtnNombre.setBounds(10, 40, 80, 25);
		rbtnNivel.setBounds(10, 72, 80, 25);
		rbtnPuntaje.setBounds(10, 110, 100, 25);

		getContentPane().add(rbtnNombre);
		getContentPane().add(rbtnNivel);
		getContentPane().add(rbtnPuntaje);

		JLabel lblBuscar = new JLabel("Busca aqui :");
		lblBuscar.setBounds(237, 40, 80, 25);
		getContentPane().add(lblBuscar);

		txtBuscar = new JTextField();
		txtBuscar.setBounds(204, 72, 150, 25);
		getContentPane().add(txtBuscar);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(226, 110, 100, 25);
		getContentPane().add(btnBuscar);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(30, 176, 100, 25);
		getContentPane().add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(134, 216, 150, 25);
		txtNombre.setEditable(false);
		getContentPane().add(txtNombre);

		JLabel lblNivel = new JLabel("Nivel:");
		lblNivel.setBounds(30, 216, 100, 25);
		getContentPane().add(lblNivel);

		txtNivel = new JTextField();
		txtNivel.setBounds(134, 176, 150, 25);
		txtNivel.setEditable(false);
		getContentPane().add(txtNivel);

		JLabel lblPuntaje = new JLabel("Puntaje:");
		lblPuntaje.setBounds(30, 252, 100, 25);
		getContentPane().add(lblPuntaje);

		txtPuntaje = new JTextField();
		txtPuntaje.setBounds(134, 252, 150, 25);
		txtPuntaje.setEditable(false);
		getContentPane().add(txtPuntaje);

		JLabel lblNuevaContra = new JLabel("Nueva contraseña:");
		lblNuevaContra.setBounds(30, 342, 150, 25);
		getContentPane().add(lblNuevaContra);

		txtNuevaContra = new JTextField();
		txtNuevaContra.setBounds(168, 342, 150, 25);
		getContentPane().add(txtNuevaContra);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(54, 378, 120, 25);
		getContentPane().add(btnActualizar);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(226, 378, 120, 25);
		getContentPane().add(btnCerrar);
	}

	// Getters
	public JTextField getTxtBuscar() {
		return txtBuscar;
	}

	public JTextField getTxtNuevaContra() {
		return txtNuevaContra;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public JButton getBtnActualizar() {
		return btnActualizar;
	}

	public JButton getBtnCerrar() {
		return btnCerrar;
	}

	public JRadioButton getRbtnNombre() {
		return rbtnNombre;
	}

	public JRadioButton getRbtnNivel() {
		return rbtnNivel;
	}

	public JRadioButton getRbtnPuntaje() {
		return rbtnPuntaje;
	}

	public void mostrarMsj(String msj) {
		JOptionPane.showMessageDialog(this, msj);
	}

	public void setEscuchadores(ActionListener e) {
		btnBuscar.addActionListener(e);
		btnActualizar.addActionListener(e);
		btnCerrar.addActionListener(e);
	}

	public void cerrar() {
		dispose();
	}
}
