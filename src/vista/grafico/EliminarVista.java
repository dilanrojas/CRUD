package vista.grafico;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


import javax.swing.JButton;
import java.awt.Color;
import java.awt.EventQueue;

public class EliminarVista extends JFrame{

	private static final long serialVersionUID = 1L;
	private JLabel lblUsuario;
	private JTextField txtUsuario;
	private JButton btnBuscar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EliminarVista frame = new EliminarVista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public EliminarVista() {
		getContentPane().setBackground(new Color(240, 128, 128));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("\\\\\\Eliminar Usuario///");
		setSize(400, 250);
		setResizable(true);
		setLocationRelativeTo(null);
		
		initComponent();
		}
	
	public void initComponent() {
		getContentPane().setLayout(null);
		
		lblUsuario = new JLabel("BUSCAR USUARIO");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setBounds(140, 40, 120, 25);
		getContentPane().add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsuario.setText("Nombre de usuario");
		txtUsuario.setBounds(100, 80, 200, 30);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(150, 130, 100, 25);
		getContentPane().add(btnBuscar);
	}
	
	public JTextField getTxtUsuario() {
		return txtUsuario;
	}
	
	public void cerrar() {
		dispose();
	}
	
	public void mostrarMensaje(String msg) {
		JOptionPane.showMessageDialog(this, msg);
		
	}
	
	public void actionListener(ActionListener listener) {
		txtUsuario.addActionListener(listener);
	}

	
}