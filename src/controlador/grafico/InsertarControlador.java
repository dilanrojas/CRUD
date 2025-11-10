package controlador.grafico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import modelo.Usuario;
import modelo.dao.IUsuarioDAO;
import vista.grafico.InsertarVista;

/**
 * @author Dilan Rojas
 * @date Nov 5, 2025
 * @version 1.0
 * @description description
 */

public class InsertarControlador implements ActionListener {
	private IUsuarioDAO modelo;
	private InsertarVista vista;
	
	public InsertarControlador(IUsuarioDAO modelo, InsertarVista vista) {
		this.modelo = modelo;
		this.vista = vista;
		
		vista.setEscuchadores(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Realizar comprobaciones antes de agregar
		if (vista.getNickname() == "" || vista.getNickname().isBlank()) {
			vista.mostrarMsj("Ingrese un nombre válido");
			return;
		}
		
		if (vista.getContrasena() == "" || vista.getContrasena().isBlank()) {
			vista.mostrarMsj("Ingrese una contraseña válida");
			return;
		}
		
		// Recuperar nivel como numero
		int nivel = 0;

        try {
            nivel = vista.getNivel();
            if (nivel < 0 || nivel > 10) {
            	vista.mostrarMsj("Ingrese un nivel válido (entre 0 y 10)");
            	return;
            }
        } catch (NumberFormatException e1) {
        	vista.mostrarMsj("El nivel debe ser un numero");
        	return;
        }
		
		Usuario usuario = null;
		try {
			usuario = new Usuario(vista.getNickname(), vista.getContrasena(), nivel, 0, 0);
			modelo.agregar(usuario);
			vista.mostrarMsj("Usuario agregado corractamente");
		} finally {
			vista.mostrarMsj("No es posible agregar el usuario");
		}
	}
}
