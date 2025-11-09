package vista.grafico;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

/**
 * @author Sebastian Castro Ulate
 * @date Nov 5, 2025
 * @version 1.0
 * @description description
 */

public class InsertarVista extends JFrame {
	
	
	private static final long serialVersionUID = 1L;
	private JTextField txtNickname;
	private JTextField txtContrasena;
	private JTextField txtGameLevel;
	private JLabel lblNickname;
	private JLabel lblContrasena;
	private JLabel lblPuntaje1;
	private JLabel lblPuntaje2;
	private JLabel lblGameLevel;
	private JLabel lblID;
	private JLabel lblIDIndicator;
	private JButton btnCrear;
	
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertarVista frame = new InsertarVista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public InsertarVista() {
		getContentPane().setBackground(new Color(153, 193, 241));
//		Cerrar app
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("[CREAR USUARIO]");
		setSize(475, 300);
		setResizable(true);
		setLocationRelativeTo(null);
		
		initComponent();
		
		setPreferredSize(new Dimension(475, 300));
		pack();
	}
	
	
	public void initComponent() {
		getContentPane().setLayout(null);
		
		
		lblNickname = new JLabel("Ingrese Nickname");
		lblNickname.setBounds(183, 40, 110, 17);
		lblNickname.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNickname);
		
		txtNickname = new JTextField();
		txtNickname.setForeground(new Color(255, 255, 255));
		txtNickname.setBackground(new Color(26, 95, 180));
		txtNickname.setBounds(183, 60, 110, 30);
		txtNickname.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(txtNickname);
		//txtNickname.setColumns(10);
		
		lblContrasena = new JLabel("Contraseña");
		lblContrasena.setBounds(183, 100, 110, 17);
		lblContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblContrasena);
		
		txtContrasena = new JTextField();
		txtContrasena.setForeground(new Color(255, 255, 255));
		txtContrasena.setBackground(new Color(26, 95, 180));
		txtContrasena.setBounds(183, 120, 110, 30);
		txtContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(txtContrasena);
		txtContrasena.setColumns(10);
		
		lblPuntaje1 = new JLabel("Puntaje");
		lblPuntaje1.setBounds(183, 160, 110, 17);
		lblPuntaje1.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblPuntaje1);
		
		lblPuntaje2 = new JLabel("{{0}}");
		lblPuntaje2.setBackground(new Color(255, 230, 0));
		lblPuntaje2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntaje2.setBounds(183, 180, 110, 30);
		getContentPane().add(lblPuntaje2);
		
		lblGameLevel = new JLabel("/Nivel de juego\\");
		lblGameLevel.setBounds(51, 50, 100, 20);
		lblGameLevel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblGameLevel);
		
		txtGameLevel = new JTextField();
		txtGameLevel.setForeground(new Color(255, 255, 255));
		txtGameLevel.setBackground(new Color(35, 39, 80));
		txtGameLevel.setFont(new Font("Dialog", Font.PLAIN, 30));
		txtGameLevel.setBounds(51, 80, 100, 100);
		txtGameLevel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(txtGameLevel);
		txtGameLevel.setColumns(10);
		
		lblID = new JLabel("ID:");
		lblID.setBounds(340, 240, 40, 10);
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblID);
		
		lblIDIndicator = new JLabel("-Numeros-");
		lblIDIndicator.setBounds(380, 240, 80, 10);
		lblIDIndicator.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblIDIndicator);
		
		btnCrear = new JButton("Crear");
		btnCrear.setFont(new Font("Dialog", Font.BOLD, 24));
		btnCrear.setForeground(new Color(255, 255, 255));
		btnCrear.setBackground(new Color(35, 39, 80));
		btnCrear.setBounds(340, 80, 100, 100);
		getContentPane().add(btnCrear);
		
		

	}

	public JTextField getTxtNickname() {
		return txtNickname;
	}
	
	public JTextField getTxtContrasena() {
		return txtContrasena;
	}

	public JTextField getTxtGameLevel() {
		return txtGameLevel;
	}
	
	public void setLblIDIndicator(String ID) {
		lblIDIndicator = new JLabel("{" + ID +"}");
	}
	
	public void setLblPuntaje2(int puntaje) {
		lblPuntaje2 = new JLabel("{{"+puntaje+"}}");
	}


	public void cerrar() {
		dispose();
	}
	
	public void mostrarMsj(String msg) {
	      JOptionPane.showMessageDialog(this, msg);
	  }
	
	public void setActionListener(ActionListener listener) {
		txtNickname.addActionListener(listener);
		txtContrasena.addActionListener(listener);
		txtGameLevel.addActionListener(listener);
		btnCrear.addActionListener(listener);
		
	}
}