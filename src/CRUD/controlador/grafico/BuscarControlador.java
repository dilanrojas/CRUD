package CRUD.controlador.grafico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import CRUD.modelo.Usuario;
import CRUD.modelo.dao.IUsuarioDAO;
import CRUD.vista.grafico.BuscarVista;

/**
 * @author Dilan Rojas
 * @date Nov 18, 2025
 * @version 1.0
 * @description description
 */

public class BuscarControlador implements ActionListener {
	// Componentes
	private BuscarVista vista;
	private IUsuarioDAO modelo;

	// Constructor
	public BuscarControlador(BuscarVista vista, IUsuarioDAO modelo, IMostrarDatos siguienteVista) {
		this.vista = vista;
		this.modelo = modelo;

		vista.setEscuchadores(this);
		vista.setEscuchadorLista(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					Usuario seleccionado = vista.getListaUsuarios().getSelectedValue();
					if (seleccionado != null) {
						siguienteVista.mostrarDatos(seleccionado);
						vista.cerrar();
					}
				}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vista.getBtnVolver()) {
			vista.cerrar();
			return;
		} else if (e.getSource() == vista.getBtnBuscar()) {
			String entrada = vista.getTfBuscarInput().trim();

			// Comprobar entrada
			if (entrada == "" || entrada.isBlank()) {
				vista.mostrarMsj("Ingrese un nombre de usuario, nivel o puntaje");
				return;
			}

			Usuario[] coincidencias = modelo.buscar(entrada);

			if (coincidencias == null || coincidencias.length == 0) {
				vista.mostrarMsj("No se encontraron usuarios.");
			} else {
				vista.setListaUsuarios(coincidencias);
			}
		}
	}
}
