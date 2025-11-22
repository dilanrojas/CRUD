package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import CRUD.modelo.Usuario;
import CRUD.modelo.dao.IUsuarioDAO;
import vista.BienvenidaVista;
import vista.IngresarJuegoVista;

/**
 * @author AnaGonzalezC5F593
 * @date 19 nov 2025
 * @version 1.0
 * @description TODO
 */

public class IngresarJuegoControlador implements ActionListener {
	private IngresarJuegoVista vista;
	private IUsuarioDAO modelo;
	
	public IngresarJuegoControlador(IUsuarioDAO modelo, IngresarJuegoVista vista) {
		this.vista = vista;
		this.modelo = modelo;
		
		vista.setEscuchadores(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source == vista.getBtnIngresar()) {
			Usuario usuarioIngresado = null;
			try {
				usuarioIngresado = modelo.buscar(vista.getNickname())[0];
			} catch (Exception ex) {
				vista.mostrarMsj("El usuario ingresado no existe");
				return;
			}
			
			if (!usuarioIngresado.getContrasena().equals(vista.getContrasena())) {
				vista.mostrarMsj("La contraseña ingresada no es correcta");
				return;
			}
			
			vista.mostrarMsj("Ingresando!");
		} else if (source == vista.getBtnCancelar()) {
			volver();
		}
		
	}
	
	public void volver() {
		vista.cerrar();
		BienvenidaVista bienvenidaVista = new BienvenidaVista();
		BienvenidaControlador bienvenidaControlador = new BienvenidaControlador(modelo, bienvenidaVista);
	}

}

