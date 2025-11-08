package modelo;

/**
 * @author Dilan Rojas
 * @date Nov 5, 2025
 * @version 1.0
 * @description description
 */

public class Usuario {
	// Atributos
	private String nombre;
	private String contrasena;
	private int nivel;
	private int puntaje;
	private final int ID;
	
	// Contador (ID único e incremental)
	private static int contadorID = 0;
	
	// Constructor
	public Usuario(
		String nombre,
		String contrasena
	) {
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.nivel = 0;
		this.puntaje = 0;
		this.ID = contadorID++;
	}

	// Getters & Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public int getID() {
		return ID;
	}
}
