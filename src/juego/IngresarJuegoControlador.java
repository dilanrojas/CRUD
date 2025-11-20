package juego.controlador;

import CRUD.modelo.dao.IUsuarioDAO;
import juego.vista.grafica.IngresarJuegoVista;

/**
 * @author AnaGonzalezC5F593
 * @date 19 nov 2025
 * @version 1.0
 * @description TODO
 */

public class IngresarJuegoControlador {
	private IngresarJuegoVista vista;
	private IUsuarioDAO modelo;
	
	public IngresarJuegoControlador( IngresarJuegoVista vista, IUsuarioDAO modelo) {
		this.vista = vista;
		this.modelo = modelo;
	}

}

