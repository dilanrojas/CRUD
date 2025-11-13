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
	    if(source == vista.getBtnVolver()) {
	    	vista.cerrar();
	    }

	    try {
	        if (source == vista.getBtnBuscar()) {
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

	        else if (source == vistaUsuario.getBtnCambiar()) {
	            String nuevaContrasena = vistaUsuario.getNuevaContrasena();
              String nuevaContrasenaConfirmar = vistaUsuario.getNuevaContrasenaConfirmar();
	            int id = vistaUsuario.getID() - 1;
	            Usuario usuario = modelo.getElemento(id);

	            if (usuario != null) {

	        		// Comprobar contraseña válida
	        		if (!nuevaContrasena.equals(nuevaContrasenaConfirmar)) {
	        			vista.mostrarMsj("Las contraseñas no coinciden");
	        			return;
	        		} else if (nuevaContrasena == "" || nuevaContrasena.isBlank()) {
	        			vista.mostrarMsj("Ingrese una contraseña válida");
	        			return;
              }else if (nuevaContrasena.length() < 4) {
	        			vista.mostrarMsj("La contraseña debe tener un mínimo de 4 caractéres");
	        			return;
	        		} else if (nuevaContrasena.contains(" ")) {
                vista.mostrarMsj("La contraseña no debe tener espacios");
                return;
              }

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
