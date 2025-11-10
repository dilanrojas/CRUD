package principal;

import controlador.grafico.MenuControlador;

/**
 * @author Dilan Rojas
 * @date Nov 8, 2025
 * @version 1.0
 * @description description
 */

import modelo.*;
import modelo.dao.IUsuarioDAO;
import modelo.dao.archivoJSON.*;
import modelo.dataset.ListaUsuarios;
import vista.grafico.*;

public class AppCRUD {

	public static void main(String[] args) {
		MenuVista vistaMenu = new MenuVista();
		ListaUsuarios dataset = new ListaUsuarios();
		UsuarioDAO modelo = new UsuarioDAO(dataset);
		MenuControlador controladorMenu = new MenuControlador(modelo, vistaMenu);
	}

}
