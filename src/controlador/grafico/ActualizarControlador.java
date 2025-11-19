package controlador.grafico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Usuario;
import modelo.dao.IUsuarioDAO;
import vista.grafico.ActualizarVista;

/**
 * @author Dilan Rojas
 * @date Nov 5, 2025
 * @version 1.0
 * @description description
 */

public class ActualizarControlador implements ActionListener, IMostrarDatos {
	// Componentes
	private IUsuarioDAO modelo;
	private ActualizarVista vista;

	// Constructor
	public ActualizarControlador(
		IUsuarioDAO modelo,
		ActualizarVista vista
	) {
		this.modelo = modelo;
		this.vista = vista;

		vista.setEscuchadores(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source == vista.getBtnCambiar()) {
			String nuevaContrasena = vista.getNuevaContrasena();
			String nuevaContrasenaConfirmar = vista.getNuevaContrasenaConfirmar();
			int id = vista.getID() - 1;
			Usuario usuario = modelo.getElemento(id);

			if (usuario != null) {

				// Comprobar contraseña válida
				if (!nuevaContrasena.equals(nuevaContrasenaConfirmar)) {
					vista.mostrarMsj("Las contraseñas no coinciden");
					return;
				} else if (nuevaContrasena == "" || nuevaContrasena.isBlank()) {
					vista.mostrarMsj("Ingrese una contraseña válida");
					return;
				} else if (nuevaContrasena.length() < 4) {
					vista.mostrarMsj("La contraseña debe tener un mínimo de 4 caractéres");
					return;
				} else if (nuevaContrasena.contains(" ")) {
					vista.mostrarMsj("La contraseña no debe tener espacios");
					return;
				}

				modelo.actualizar(usuario, nuevaContrasena);
				vista.mostrarMsj("Contraseña actualizada correctamente.");
				vista.cerrar();

			} else {
				vista.mostrarMsj("No se encontró el usuario.");
			}
		}

		if (source == vista.getBtnCancelar()) vista.cerrar();
	}

	// Metodo para mostrar los datos
	public void mostrarDatos(Usuario usuario) {
		vista.setTfNombre(usuario.getNombre());
		vista.setTfNivel(usuario.getNivel());
		vista.setTfPuntaje(usuario.getPuntaje());
		vista.setTfID(usuario.getID());
		vista.setVisible(true);
	}
}
