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
	private JTextField txtNivel;
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
		setSize(420, 400);
		setResizable(true);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	public void initComponents() {
        getContentPane().setLayout(null);
        
        lblNickname = new JLabel("Ingrese Nickname");
        lblNickname.setBounds(145, 30, 110, 20);
        lblNickname.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(lblNickname);
        
        txtNickname = new JTextField();
        txtNickname.setBackground(new Color(255, 255, 255));
        txtNickname.setBounds(110, 60, 180, 30);
        txtNickname.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(txtNickname);
        
        lblContrasena = new JLabel("Contraseña");
        lblContrasena.setBounds(145, 102, 110, 20);
        lblContrasena.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(lblContrasena);
        
        txtContrasena = new JTextField();
        txtContrasena.setBackground(new Color(255, 255, 255));
        txtContrasena.setBounds(110, 127, 180, 30);
        txtContrasena.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(txtContrasena);
        txtContrasena.setColumns(10);
        
        lblGameLevel = new JLabel("Nivel de juego");
        lblGameLevel.setBounds(145, 169, 110, 20);
        lblGameLevel.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(lblGameLevel);
        
        txtNivel = new JTextField();
        txtNivel.setBackground(new Color(255, 255, 255));
        txtNivel.setFont(new Font("Dialog", Font.PLAIN, 12));
        txtNivel.setBounds(110, 194, 180, 30);
        txtNivel.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(txtNivel);
        txtNivel.setColumns(10);
        
        btnCrear = new JButton("Crear");
        btnCrear.setFont(new Font("Dialog", Font.BOLD, 12));
        btnCrear.setBackground(new Color(255, 255, 255));
        btnCrear.setBounds(110, 239, 180, 30);
        getContentPane().add(btnCrear);
    }

	public String getNickname() {
		return txtNickname.getText();
	}
	
	public String getContrasena() {
		return txtContrasena.getText();
	}

	public int getNivel() {
		return Integer.parseInt(txtNivel.getText());
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