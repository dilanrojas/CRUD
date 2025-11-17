package controlador.grafico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import modelo.Usuario;
import modelo.dao.IUsuarioDAO;
import vista.grafico.MostrarUsuarioVista;
import vista.grafico.MostrarVista;

/**
 * @author Dilan Rojas
 * @date Nov 5, 2025
 * @version 1.0
 * @description description
 */

public class MostrarControlador implements ActionListener {
	// Componentes
	private IUsuarioDAO modelo;
	private MostrarVista vista;
	private MostrarUsuarioVista vistaUsuario;
	
	// Constructor
	public MostrarControlador(
		IUsuarioDAO modelo,
		MostrarVista vista,
		MostrarUsuarioVista vistaUsuario
	) {
		this.modelo = modelo;
		this.vista = vista;
		this.vistaUsuario = vistaUsuario;
		
    // Registrar escuchadores
    vista.setEscuchadores(this);
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
      if (e.getSource() == vista.getBtnBuscar()) {

        try {
          // Obtener texto de entrada
          String entrada = vista.getTfBuscarInput().trim();

          // Comprobar entrada
          if (entrada == "" || entrada.isBlank()) {
            vista.mostrarMsj("Ingrese un nombre de usuario, nivel o puntaje");
            return;
          }

          // Buscar coincidencias
          Usuario[] coincidencias = modelo.buscar(entrada);

          if (coincidencias == null || coincidencias.length == 0) {
            vista.mostrarMsj("No se encontraron usuarios.");
          } else {
            // Si encuentra coincidencias, añadirlas
            vista.setListaUsuarios(coincidencias);
          }
        } catch (Exception ex) {
          vista.mostrarMsj("Error al buscar usuarios: " + ex.getMessage());
        }
      } else if (e.getSource() == vista.getBtnVolver()) {
        vista.cerrar();
      }
    }
	
    // Metodo para mostrar los datos en MostrarVistaUsuario
    private void mostrarUsuario(Usuario usuario) {
        vistaUsuario.setTfNombre(usuario.getNombre());
        vistaUsuario.setTfNivel(usuario.getNivel());
        vistaUsuario.setTfPuntaje(usuario.getPuntaje());
        vistaUsuario.setTfID(usuario.getID());
        vistaUsuario.setVisible(true);
    }
}
