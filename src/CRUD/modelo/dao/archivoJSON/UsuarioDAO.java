package CRUD.modelo.dao.archivoJSON;

import java.io.IOException;

import CRUD.modelo.Usuario;
import CRUD.modelo.dao.IUsuarioDAO;

import CRUD.modelo.dataset.ListaUsuarios;

/**
 * @author Dilan Rojas
 * @date Nov 7, 2025
 * @version 1.0
 * @description description
 */

public class UsuarioDAO implements IUsuarioDAO {
	// Componentes
	private EscritorJSON escritor;
	private LectorJSON lector;
	private ListaUsuarios dataset;
	public final static String FILE_NAME = "data/usuariosData.json";
	
	public UsuarioDAO(ListaUsuarios dataset) {
		this.dataset = dataset;
		this.escritor = new EscritorJSON(dataset, FILE_NAME);
		this.lector = new LectorJSON(dataset, FILE_NAME);
		
		cargarUsuarios();
	}

	@Override
	public void cargarUsuarios() {
		try {
			lector.readAll();
		} catch (IOException e) {
			System.err.println("Error al guardar el archivo JSON: " + e.getMessage());
		}
	}

	@Override
	public void guardarDataset() {
		try {
			escritor.writeAll();
		} catch (IOException e) {
			
		}
	}

	@Override
	public boolean agregar(Usuario usuario) {
		if (usuario == null) return false;
		dataset.agregar(usuario);
		guardarDataset();
		return true;
	}

	@Override
	public boolean actualizar(Usuario usuario, String contrasena) {
		if (usuario == null) return false;
		usuario.setContrasena(contrasena);
		guardarDataset();
		return true;
	}

	@Override
	public boolean eliminar(int id) {
		dataset.eliminar(id);
		guardarDataset();
		return false;
	}

	@Override
	public Usuario[] buscar(String entrada) {
		return dataset.buscar(entrada);
	}

	@Override
	public Usuario getElemento(int id) {
		return dataset.getElemento(id);
	}

}
