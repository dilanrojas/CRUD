package principal;

import CRUD.modelo.dao.archivoJSON.UsuarioDAO;
import CRUD.modelo.dataset.ListaUsuarios;
import controlador.BienvenidaControlador;
import vista.BienvenidaVista;

/**
 * @author Dilan Rojas
 * @date Nov 20, 2025
 * @version 1.0
 * @description description
 */

public class AppGeometryWars {
	// Componentes
	private BienvenidaVista bienvenidaVista;
	private BienvenidaControlador bienvenidaControlador;
	private ListaUsuarios dataset;
	
	// Constructor
	public static void main(String[] args) {
		AppGeometryWars app = new AppGeometryWars();
		app.iniciar();
	}
	
	public void iniciar() {
		bienvenidaVista = new BienvenidaVista();
		dataset = new ListaUsuarios();
		UsuarioDAO modelo = new UsuarioDAO(dataset);
		bienvenidaControlador = new BienvenidaControlador(modelo, bienvenidaVista);
	}
	
}
