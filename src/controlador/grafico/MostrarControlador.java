package controlador.grafico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import modelo.Usuario;
import modelo.dao.IUsuarioDAO;
import vista.grafico.MostrarVista;
import vista.grafico.BuscarVista;

/**
 * @author Dilan Rojas
 * @date Nov 5, 2025
 * @version 1.0
 * @description description
 */

public class MostrarControlador implements IMostrarDatos {
	// Componentes
	private MostrarVista vista;
	
	// Constructores
	public MostrarControlador(MostrarVista vista) {
		this.vista = vista;
	}
	
    // Metodo para mostrar los datos en MostrarVistaUsuario
    public void mostrarDatos(Usuario usuario) {
        vista.setTfNombre(usuario.getNombre());
        vista.setTfNivel(usuario.getNivel());
        vista.setTfPuntaje(usuario.getPuntaje());
        vista.setTfID(usuario.getID());
        vista.setVisible(true);
    }
}
