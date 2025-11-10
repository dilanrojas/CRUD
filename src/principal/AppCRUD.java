package principal;

import controlador.grafico.MenuControlador;

/**
 * @author Dilan Rojas
 * @date Nov 8, 2025
 * @version 1.0
 * @description description
 */

import modelo.dao.archivoJSON.*;
import modelo.dataset.ListaUsuarios;
import vista.grafico.*;

public class AppCRUD {
	// Componentes
	private MenuVista menuVista;
	private ListaUsuarios dataset;

	public static void main(String[] args) {
		AppCRUD app = new AppCRUD();
		app.iniciar();
	}

	// Iniciar controlador menu
	public void iniciar() {
		menuVista = new MenuVista();
		dataset = new ListaUsuarios();
		UsuarioDAO modelo = new UsuarioDAO(dataset);
		MenuControlador menuControlador = new MenuControlador(modelo, menuVista);
	}

}
