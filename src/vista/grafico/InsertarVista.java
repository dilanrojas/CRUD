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
	private JLabel lblGameLevel;
	private JButton btnCrear;
	
	public static void main(String[] args) {
		InsertarVista vista = new InsertarVista();
	}
	public InsertarVista() {
		initComponents();
		// Cerrar app
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("CRUD | Insertar");
		setSize(400, 310);
		setResizable(true);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	public void initComponents() {
		getContentPane().setLayout(null);
		
		lblNickname = new JLabel("Ingrese Nickname");
		lblNickname.setBounds(136, 40, 110, 17);
		lblNickname.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNickname);
		
		txtNickname = new JTextField();
		txtNickname.setBackground(new Color(255, 255, 255));
		txtNickname.setBounds(105, 60, 186, 30);
		txtNickname.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(txtNickname);
		
		lblContrasena = new JLabel("Contraseña");
		lblContrasena.setBounds(136, 100, 110, 17);
		lblContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblContrasena);
		
		txtContrasena = new JTextField();
		txtContrasena.setBackground(new Color(255, 255, 255));
		txtContrasena.setBounds(105, 120, 186, 30);
		txtContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(txtContrasena);
		txtContrasena.setColumns(10);
		
		lblGameLevel = new JLabel("Nivel de juego");
		lblGameLevel.setBounds(136, 162, 100, 20);
		lblGameLevel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblGameLevel);
		
		txtGameLevel = new JTextField();
		txtGameLevel.setBackground(new Color(255, 255, 255));
		txtGameLevel.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtGameLevel.setBounds(105, 194, 186, 30);
		txtGameLevel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(txtGameLevel);
		txtGameLevel.setColumns(10);
		
		btnCrear = new JButton("Crear");
		btnCrear.setFont(new Font("Dialog", Font.BOLD, 12));
		btnCrear.setBackground(new Color(255, 255, 255));
		btnCrear.setBounds(105, 236, 186, 30);
		getContentPane().add(btnCrear);
	}

	public String getNickname() {
		return txtNickname.getText();
	}
	
	public String getContrasena() {
		return txtContrasena.getText();
	}

	public int getGameLevel() {
		return Integer.parseInt(txtGameLevel.getText());
	}

	public void cerrar() {
		dispose();
	}
	
	public void mostrarMsj(String msg) {
	      JOptionPane.showMessageDialog(this, msg);
	  }
	
	public void setEscuchadores(ActionListener escuchador) {
		btnCrear.addActionListener(escuchador);
	}
}