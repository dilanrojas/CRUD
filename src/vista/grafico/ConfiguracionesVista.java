package vista.grafico;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JButton;

/**
 * @author Dilan Rojas
 * @date Nov 5, 2025
 * @version 1.0
 * @description description
 */

public class ConfiguracionesVista extends JFrame {
	// Componentes gráficos
	private static final long serialVersionUID = 1L;
	private JButton btnTipoEnemigos;
	private JButton btnNivelActual;
	private JButton btnCantidadVidasExtra;
	private JButton btnCantidadPorTipo;
	private JButton btnTipoArma;
	private JButton btnVelocidadJuego;
	private JButton btnDificultadPorNivel;

	// Main (Pruebas)
	public static void main(String[] args) {
		ConfiguracionesVista vista = new ConfiguracionesVista();
	}

	// Constructor
	public ConfiguracionesVista() {
    	initComponents();
        setTitle("Configuraciones | CRUD");
        setSize(370, 370);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        setVisible(true);
	}

	// Inicializar componentes
	public void initComponents() {
        btnTipoEnemigos = new JButton("Tipo de enemigos");
        btnTipoEnemigos.setBounds(38, 26, 295, 27);
        getContentPane().add(btnTipoEnemigos);

        btnNivelActual = new JButton("Nivel Actual");
        btnNivelActual.setBounds(38, 65, 295, 27);
        getContentPane().add(btnNivelActual);

        btnCantidadVidasExtra = new JButton("Cantidad de vidas extra");
        btnCantidadVidasExtra.setBounds(38, 143, 295, 27);
        getContentPane().add(btnCantidadVidasExtra);

        btnCantidadPorTipo = new JButton("Cantidad de enemigos por tipo");
        btnCantidadPorTipo.setBounds(38, 104, 295, 27);
        getContentPane().add(btnCantidadPorTipo);

        btnTipoArma = new JButton("Tipo de arma del jugador");
        btnTipoArma.setBounds(38, 221, 295, 27);
        getContentPane().add(btnTipoArma);

        btnVelocidadJuego = new JButton("Velocidad del juego");
        btnVelocidadJuego.setBounds(38, 182, 295, 27);
        getContentPane().add(btnVelocidadJuego);

        btnDificultadPorNivel = new JButton("Incremento de dificultad por nivel");
        btnDificultadPorNivel.setBounds(38, 260, 295, 27);
        getContentPane().add(btnDificultadPorNivel);
	}
	
	// Configurar escuchadores
	public void setEscuchadores(ActionListener escuchador) {
	    btnTipoEnemigos.addActionListener(escuchador);
	    btnNivelActual.addActionListener(escuchador);
	    btnCantidadVidasExtra.addActionListener(escuchador);
	    btnCantidadPorTipo.addActionListener(escuchador);
	    btnTipoArma.addActionListener(escuchador);
	    btnVelocidadJuego.addActionListener(escuchador);
	    btnDificultadPorNivel.addActionListener(escuchador);
	}

	// Método mostrar mensaje
	public void mostrarMsj(String msg) {
		JOptionPane.showMessageDialog(this, msg, "CRUD", JOptionPane.INFORMATION_MESSAGE);
    }
	
	// Método cerrar
	public void cerrar() {
		dispose();
	}
}
