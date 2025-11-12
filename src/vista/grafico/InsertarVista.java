package vista.grafico;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

/**
 * @author Sebastian Castro Ulate
 * @date Nov 5, 2025
 * @version 1.0
 * @description description
 */

public class InsertarVista extends JFrame {
	private static final long serialVersionUID = 1L;
  private JTextField tfNombre;
	private JTextField tfNickname;
	private JTextField tfContrasena;
	private JTextField tfNivel;
  private JLabel lblNombre;
	private JLabel lblNickname;
	private JLabel lblContrasena;
	private JLabel lblGameLevel;
	private JButton btnCrear;
	
	public static void main(String[] args) {
		InsertarVista vista = new InsertarVista();
	}

	public InsertarVista() {
		initComponents();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Insertar | CRUD");
		setSize(400, 470);
		setResizable(true);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	public void initComponents() {
    getContentPane().setLayout(null);

    // x, y, width, height
    lblNombre = new JLabel("Nombre");
    lblNombre.setBounds(110, 30, 110, 20);
    lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
    getContentPane().add(lblNombre);

    tfNombre = new JTextField();
    tfNombre.setBounds(110, 60, 180, 30);
    tfNombre.setHorizontalAlignment(SwingConstants.LEFT);
    getContentPane().add(tfNombre);

    lblNickname = new JLabel("Nickname");
    lblNickname.setBounds(110, 110, 110, 20);
    lblNickname.setHorizontalAlignment(SwingConstants.LEFT);
    getContentPane().add(lblNickname);

    tfNickname = new JTextField();
    tfNickname.setBackground(new Color(255, 255, 255));
    tfNickname.setBounds(110, 140, 180, 30);
    tfNickname.setHorizontalAlignment(SwingConstants.LEFT);
    getContentPane().add(tfNickname);

    lblContrasena = new JLabel("Contraseña");
    lblContrasena.setBounds(110, 190, 110, 20);
    lblContrasena.setHorizontalAlignment(SwingConstants.LEFT);
    getContentPane().add(lblContrasena);

    tfContrasena = new JTextField();
    tfContrasena.setBackground(new Color(255, 255, 255));
    tfContrasena.setBounds(110, 220, 180, 30);
    tfContrasena.setHorizontalAlignment(SwingConstants.LEFT);
    getContentPane().add(tfContrasena);
    tfContrasena.setColumns(10);

    lblGameLevel = new JLabel("Nivel de juego");
    lblGameLevel.setBounds(110, 270, 110, 20);
    lblGameLevel.setHorizontalAlignment(SwingConstants.LEFT);
    getContentPane().add(lblGameLevel);

    tfNivel = new JTextField();
    tfNivel.setBackground(new Color(255, 255, 255));
    tfNivel.setFont(new Font("Dialog", Font.PLAIN, 12));
    tfNivel.setBounds(110, 300, 180, 30);
    tfNivel.setHorizontalAlignment(SwingConstants.CENTER);
    getContentPane().add(tfNivel);
    tfNivel.setColumns(10);

    btnCrear = new JButton("Crear");
    btnCrear.setFont(new Font("Dialog", Font.BOLD, 12));
    btnCrear.setBackground(new Color(255, 255, 255));
    btnCrear.setBounds(110, 360, 180, 30);
    getContentPane().add(btnCrear);
  }

  public String getNombre() {
    return tfNombre.getText();
  }

	public String getNickname() {
		return tfNickname.getText();
	}
	
	public String getContrasena() {
		return tfContrasena.getText();
	}

	public int getNivel() {
		return Integer.parseInt(tfNivel.getText());
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
