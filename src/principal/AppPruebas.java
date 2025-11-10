package principal;

import controlador.grafico.MostrarControlador;

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

public class AppPruebas {

	public static void main(String[] args) {
		ListaUsuarios dataset = new ListaUsuarios();
		UsuarioDAO modelo = new UsuarioDAO(dataset);
		
		System.out.println(dataset.imprimir());
	}

}
