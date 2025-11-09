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
	private int ID;
	
	// Constructor
	public Usuario(
		String nombre,
		String contrasena
	) {
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.nivel = 0;
		this.puntaje = 0;
		this.ID = 0;
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
	
	public void setID(int ID) {
		this.ID = ID;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", contrasena=" + contrasena + ", nivel=" + nivel + ", puntaje=" + puntaje
				+ ", ID=" + ID + "]";
	}
}
