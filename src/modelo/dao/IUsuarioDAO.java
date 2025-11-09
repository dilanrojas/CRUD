package modelo.dao;

import modelo.Usuario;

/**
 * @author Dilan Rojas
 * @date Nov 5, 2025
 * @version 1.0
 * @description description
 */

public interface IUsuarioDAO {
  // Leer datos de archivos y cargarlos al dataset
	public abstract void cargarUsuarios();

  // Almacenar datos de dataset en archivos
  public abstract void guardarDataset();

  // Agregar un nuevo usuario al dataset y almacenarlo
  // de forma permanente
  public abstract boolean agregar(Usuario usuario);

  // Actualiza y guarda la contraseña de un usuario
  public abstract boolean actualizar(Usuario usuario, String contrasena);

  // Elimina un usuario de la lista
  public abstract boolean eliminar(int id);

  // Busca un usuario en la lista
  // por nivel, id o nombre, devolviendo un array
  // con los usuarios que coinciden
  public abstract Usuario[] buscar(String entrada);
}
