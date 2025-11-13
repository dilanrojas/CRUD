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
import javax.swing.border.LineBorder;

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
	private JButton btnCancelar;
	
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
    lblNickname.setBounds(110, 100, 110, 20);
    lblNickname.setHorizontalAlignment(SwingConstants.LEFT);
    getContentPane().add(lblNickname);

    tfNickname = new JTextField();
    tfNickname.setBackground(new Color(255, 255, 255));
    tfNickname.setBounds(110, 130, 180, 30);
    tfNickname.setHorizontalAlignment(SwingConstants.LEFT);
    getContentPane().add(tfNickname);

    lblContrasena = new JLabel("Contraseña");
    lblContrasena.setBounds(110, 170, 110, 20);
    lblContrasena.setHorizontalAlignment(SwingConstants.LEFT);
    getContentPane().add(lblContrasena);

    tfContrasena = new JTextField();
    tfContrasena.setBackground(new Color(255, 255, 255));
    tfContrasena.setBounds(110, 200, 180, 30);
    tfContrasena.setHorizontalAlignment(SwingConstants.LEFT);
    getContentPane().add(tfContrasena);
    tfContrasena.setColumns(10);

    lblGameLevel = new JLabel("Nivel de juego");
    lblGameLevel.setBounds(110, 240, 110, 20);
    lblGameLevel.setHorizontalAlignment(SwingConstants.LEFT);
    getContentPane().add(lblGameLevel);

    tfNivel = new JTextField();
    tfNivel.setBackground(new Color(255, 255, 255));
    tfNivel.setFont(new Font("Dialog", Font.PLAIN, 12));
    tfNivel.setBounds(110, 270, 180, 30);
    tfNivel.setHorizontalAlignment(SwingConstants.CENTER);
    getContentPane().add(tfNivel);
    tfNivel.setColumns(10);

    btnCrear = new JButton("Crear");
    btnCrear.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
    btnCrear.setFont(new Font("Dialog", Font.BOLD, 12));
    btnCrear.setBackground(Color.LIGHT_GRAY);
    btnCrear.setBounds(110, 320, 180, 30);
    getContentPane().add(btnCrear);
    
    btnCancelar = new JButton("Cancelar");
    btnCancelar.setBackground(Color.LIGHT_GRAY);
    btnCancelar.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
    btnCancelar.setBounds(110, 362, 180, 30);
    getContentPane().add(btnCancelar);
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
	
	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void cerrar() {
		dispose();
	}
	
	public void mostrarMsj(String msg) {
	      JOptionPane.showMessageDialog(this, msg);
	  }
	
	public void setEscuchadores(ActionListener escuchador) {
		btnCrear.addActionListener(escuchador);
		btnCancelar.addActionListener(escuchador);
	}
}
