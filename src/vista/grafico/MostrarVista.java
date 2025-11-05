package vista.grafico;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

/**
 * @author Dilan Rojas
 * @date Nov 5, 2025
 * @version 1.0
 * @description description
 */

public class MostrarVista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField tfBuscarInput;
	private JButton btnBuscar;
	private JList listaUsuarios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MostrarVista frame = new MostrarVista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MostrarVista() {
		initComponents();
        setTitle("Mostrar | CRUD");
        setSize(750, 400);
        setResizable(false);
        setLocationRelativeTo(null);
	}

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
        
        listaUsuarios = new JList();
        listaUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaUsuarios.setBounds(111, 118, 506, 176);
        getContentPane().add(listaUsuarios);
        setVisible(true);
	}
	
	public String getTfBuscarInput() {
		return tfBuscarInput.getText();
	}

	public void setListaUsuarios(JList listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public void mostrarMsj(String msg) {
	    JOptionPane.showMessageDialog(this, msg, "CRUD", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void setEscuchadores(ActionListener escuchador) {
		btnBuscar.addActionListener(escuchador);
	}
	
	public void cerrar() {
		dispose();
	}
}
