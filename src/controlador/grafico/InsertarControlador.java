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
		Usuario usuario = new Usuario(vista.getNickname(), vista.getContrasena(), vista.getGameLevel(), 0, 0);
		if (!modelo.agregar(usuario)) vista.mostrarMsj("No es posible agregar el usuario");
	}
}
