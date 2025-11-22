package CRUD.principal;

import CRUD.controlador.grafico.MenuControlador;

/**
 * @author Dilan Rojas
 * @date Nov 8, 2025
 * @version 1.0
 * @description description
 */

import CRUD.modelo.dao.archivoJSON.*;
import CRUD.modelo.dataset.ListaUsuarios;
import CRUD.vista.grafico.*;

public class AppCRUD {
	// Componentes
	private MenuVista menuVista;
	private ListaUsuarios dataset;

	public AppCRUD() {
		iniciar();
	}

	// Iniciar controlador menu
	public void iniciar() {
		menuVista = new MenuVista();
		dataset = new ListaUsuarios();
		UsuarioDAO modelo = new UsuarioDAO(dataset);
		MenuControlador menuControlador = new MenuControlador(modelo, menuVista);
	}

}
