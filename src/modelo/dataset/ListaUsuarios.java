package modelo.dataset;

import modelo.Usuario;

/**
 * @author Dilan Rojas
 * @date Nov 7, 2025
 * @version 1.0
 * @description description
 */

public class ListaUsuarios {
	// Atributos
	private Usuario[] lista;
	private int size;
	private final int TAMANO_INICIAL = 20;
	
	// === Constructores ===
	
	// Lista con el tamaño inicial
	public ListaUsuarios() {
		this.lista = new Usuario[TAMANO_INICIAL];
		this.size = 0;
	}
	
	// Lista con tamaño personalizado
	public ListaUsuarios(int tamano) {
		this.lista = new Usuario[Math.max(tamano, 1)];
		this.size = 0;
	}
	
	// === MéTODOS ===
	
	// Obtener
	public Usuario getElemento(int index) {
		if (index < 0 || index >= size) return null;
		return lista[index];
	}
	
	// Agregar
	public boolean agregar(Usuario usuario) {
		if (usuario == null) return false;
		if (size >= lista.length) crecer(); 
		lista[size++] = usuario;
		return true;
	}
	
	// Crecer
  private void crecer() {
      int nuevoTamano = lista.length * 2;
      Usuario[] nuevaLista = new Usuario[nuevoTamano];
      for (int i = 0; i < lista.length; i++) {
          nuevaLista[i] = lista[i];
      }
      lista = nuevaLista;
      System.out.println("Dataset ampliado a " + nuevoTamano + " elementos.");
  }
  
  // Imprimir
  public String imprimir() {
      String valores = "";
      for (int i = 0; i < size; i++) {
          valores = valores + lista[i] + "\n";
      }
      return valores;
  }
  
  // Getters y setters
  public int getSize() {
      return size;
  }

  // Verificar si la lista está vacía
  public boolean isEmpty() {
      return size == 0;
  }

  // Limpiar la lista
  public void clear() {
  	for (Usuario usuario : lista) usuario = null;
    size = 0;
	}
}
