package vista;

import javax.swing.JFrame;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;

/**
 * @author AnaGonzalezC5F593
 * @date 19 nov 2025
 * @version 1.0
 * @description TODO
 */

public class BienvenidaVista extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel lblNombreJuego, lblAutores, lblNombres, lblRecords;
	private JButton btnInscribir;
	private JButton btnJugar;
	private JButton btnSalir;
	private JList<String> listaRecords;
	private DefaultListModel<String> modeloRecords;

	public BienvenidaVista() {
	        initComponents();
	        setTitle("Bienvenida");
	        setSize(500, 500);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setResizable(false);
	        setLocationRelativeTo(null);
	        getContentPane().setLayout(null);
	        setVisible(true);
	    }

	private void initComponents() {
		lblNombreJuego = new JLabel("¡Bienvenido a Geometry Wars! ");
		lblNombreJuego.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombreJuego.setBounds(118, 30, 241, 45);
		getContentPane().add(lblNombreJuego);

		lblAutores = new JLabel("Autores:");
		lblAutores.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAutores.setBounds(27, 68, 76, 22);
		getContentPane().add(lblAutores);

		lblNombres = new JLabel("Dilan Rojas - Ana González - Sebastián Castro");
		lblNombres.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombres.setBounds(99, 65, 293, 29);
		getContentPane().add(lblNombres);

		btnInscribir = new JButton("Inscribirse");
		btnInscribir.setBounds(182, 105, 120, 30);
		getContentPane().add(btnInscribir);

		btnJugar = new JButton("Ingresar al juego");
		btnJugar.setBounds(182, 150, 120, 30);
		getContentPane().add(btnJugar);

		btnSalir = new JButton("Salir");
		btnSalir.setBounds(182, 195, 120, 30);
		getContentPane().add(btnSalir);

		lblRecords = new JLabel("Los mejores récords");
		lblRecords.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRecords.setBounds(171, 240, 150, 31);
		getContentPane().add(lblRecords);

		modeloRecords = new DefaultListModel<String>();

		listaRecords = new JList<String>(modeloRecords);
		listaRecords.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaRecords.setEnabled(false);
		listaRecords.setBounds(118, 275, 250, 120);
		getContentPane().add(listaRecords);
	}

	public void setListaRecords(String[] lista) {
		modeloRecords.clear();
		for (String record : lista) {
			modeloRecords.addElement(record);
		}
	}

	public JButton getBtnInscribir() {
		return btnInscribir;
	}

	public JButton getBtnJugar() {
		return btnJugar;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public JList<String> getListaRecords() {
		return listaRecords;
	}

	public void setEscuchadores(ActionListener escuchador) {
		btnInscribir.addActionListener(escuchador);
		btnJugar.addActionListener(escuchador);
		btnSalir.addActionListener(escuchador);
	}

	public void cerrar() {
		dispose();
	}

	public static void main(String[] args) {
		BienvenidaVista vista = new BienvenidaVista();
	}
}
