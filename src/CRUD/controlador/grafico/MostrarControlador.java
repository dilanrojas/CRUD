package CRUD.controlador.grafico;

import CRUD.modelo.Usuario;
import CRUD.vista.grafico.MostrarVista;

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
