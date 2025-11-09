package principal;

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
		
		Usuario dilan = new Usuario("Dilan", "ab0Oak*");
		Usuario ana = new Usuario("Ana", "Hah:z9u");
		Usuario sebastian = new Usuario("Sebastián", "Xuz{oo7");
		Usuario anabelle = new Usuario("Anabelle", "woh1eW{");
		
		
		// === PRUEBAS ===
		
		// Agregar
		modelo.agregar(dilan);
		System.out.println("=== Prueba 1: Agregar ===");
		System.out.println(dataset.getElemento(0).toString());
		
		// Actualizar
		System.out.println("\n=== Prueba 2: Actualizar (contraseña) ===");
		modelo.actualizar(dataset.getElemento(0), "NuevaContrasena");
		System.out.println(dataset.getElemento(0).toString());
		
		// Eliminar y agregar mas
		System.out.println("\n=== Prueba 3: Eliminar y agregar más");
		modelo.eliminar(0);
		dilan.setNivel(3);
		modelo.agregar(dilan);
		modelo.agregar(sebastian);
		ana.setNivel(3);
		modelo.agregar(ana);
		modelo.agregar(anabelle);
		
		// Buscar
		System.out.println("\n=== Prueba 3: Buscar ===");
		System.out.println("\nCoincidencias por ID y Nivel:");
		for (Usuario u : modelo.buscar("3")) {
			System.out.println(u.toString());
		}
		System.out.println("\nCoincidencias por Nombre:");
		for (Usuario u : modelo.buscar("Ana")) {
			System.out.println(u.toString());
		}
	}

}
