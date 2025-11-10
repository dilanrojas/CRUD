package controlador.grafico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import modelo.Usuario;
import modelo.dao.IUsuarioDAO;
import vista.grafico.ActualizarUsuarioVista;
import vista.grafico.ActualizarVista;

/**
 * @author Dilan Rojas
 * @date Nov 5, 2025
 * @version 1.0
 * @description description
 */

public class ActualizarControlador implements ActionListener {
	// Componentes
	private IUsuarioDAO modelo;
	private ActualizarVista vista;
	private ActualizarUsuarioVista vistaUsuario;
	
	// Constructor
	/**
	 * @wbp.parser.entryPoint
	 */
	public ActualizarControlador(
		IUsuarioDAO modelo,
		ActualizarVista vista,
		ActualizarUsuarioVista vistaUsuario
	) {
		this.modelo = modelo;
		this.vista = vista;
		this.vistaUsuario = vistaUsuario;
		
        // Registrar escuchadores
        vista.setEscuchadores(this);
        vistaUsuario.setEscuchadores(this);
        vista.setEscuchadorLista(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) { // Doble clic
                    Usuario seleccionado = vista.getListaUsuarios().getSelectedValue();
                    if (seleccionado != null) {
                        mostrarUsuario(seleccionado);
                    }
                }
            }
        });
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    Object source = e.getSource();

	    try {
	        if (source == vista.getBtnBuscar()) {
	            String entrada = vista.getTfBuscarInput().trim();
	            Usuario[] coincidencias = modelo.buscar(entrada);

	            if (coincidencias == null || coincidencias.length == 0) {
	                vista.mostrarMsj("No se encontraron usuarios.");
	            } else {
	                vista.setListaUsuarios(coincidencias);
	            }
	        }

	        else if (source == vistaUsuario.getBtnCambiar()) {
	            String nuevaContrasena = vistaUsuario.getNuevaContrasena();
	            int id = vistaUsuario.getID();
	            Usuario usuario = modelo.buscar("" + id)[0];

	            if (usuario != null) {
	                modelo.actualizar(usuario, nuevaContrasena);
	                vistaUsuario.mostrarMsj("Contraseña actualizada correctamente.");
	                vistaUsuario.cerrar();
	                vista.cerrar();
	            } else {
	                vistaUsuario.mostrarMsj("No se encontró el usuario.");
	            }
	        }

	        else if (source == vistaUsuario.getBtnCancelar()) {
	            vistaUsuario.cerrar();
	        }

	    } catch (Exception ex) {
	        if (source == vistaUsuario.getBtnCambiar()) {
	            vistaUsuario.mostrarMsj("Error al actualizar: " + ex.getMessage());
	        } else {
	            vista.mostrarMsj("Error al buscar: " + ex.getMessage());
	        }
	    }
	}

    // Metodo para mostrar los datos
    private void mostrarUsuario(Usuario usuario) {
        vistaUsuario.setTfNombre(usuario.getNombre());
        vistaUsuario.setTfNivel(usuario.getNivel());
        vistaUsuario.setTfPuntaje(usuario.getPuntaje());
        vistaUsuario.setTfID(usuario.getID());
        vistaUsuario.setVisible(true);
    }
}
