package controlador.grafico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.dao.IUsuarioDAO;
import vista.grafico.ActualizarUsuarioVista;
import vista.grafico.ActualizarVista;
import vista.grafico.ConfiguracionesVista;
import vista.grafico.EliminarUsuarioVista;
import vista.grafico.EliminarVista;
import vista.grafico.InsertarVista;
import vista.grafico.MenuVista;
import vista.grafico.MostrarUsuarioVista;
import vista.grafico.MostrarVista;

/**
 * @author Ana Gonzalez
 * @date Nov 9, 2025
 * @version 1.0
 * @description description
 */

public class MenuControlador implements ActionListener {
	private IUsuarioDAO modelo;

	private MenuVista menuVista;
	private ActualizarVista menuActualizar;
	private ActualizarUsuarioVista menuActualizarUsuario;
	private ConfiguracionesVista configuracionesVista;
	private EliminarVista eliminarVista;
	private EliminarUsuarioVista eliminarUsuarioVista;
	private InsertarVista insertarVista;
	private MostrarVista mostrarVista;
	private MostrarUsuarioVista mostrarUsuarioVista;

	private ActualizarControlador actualizarControlador;
	private ConfiguracionesControlador configuracionesControlador;
	private EliminarControlador eliminarControlador;
	private InsertarControlador insertarControlador;
	private MostrarControlador mostrarControlador;

	public MenuControlador(IUsuarioDAO modelo, MenuVista menuVista) {
		this.modelo = modelo;
        this.menuVista = menuVista;

        // Escuchar los eventos del menú principal
        menuVista.setEscuchadores(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object fuente = e.getSource();

        if (fuente == menuVista.getBtnMostrar()) {
            mostrarVista = new MostrarVista();
            mostrarUsuarioVista = new MostrarUsuarioVista();
            mostrarControlador = new MostrarControlador(modelo, mostrarVista, mostrarUsuarioVista);

        } else if (fuente == menuVista.getBtnInsertar()) {
            insertarVista = new InsertarVista();
            insertarControlador = new InsertarControlador(modelo, insertarVista);

        } else if (fuente == menuVista.getBtnActualizar()) {
            menuActualizar = new ActualizarVista();
            menuActualizarUsuario = new ActualizarUsuarioVista();
            actualizarControlador = new ActualizarControlador(modelo, menuActualizar, menuActualizarUsuario);

        } else if (fuente == menuVista.getBtnEliminar()) {
            eliminarVista = new EliminarVista();
            eliminarUsuarioVista = new EliminarUsuarioVista();
            eliminarControlador = new EliminarControlador(modelo, eliminarVista, eliminarUsuarioVista);

        /* PENDIENTE --> } else if (fuente == menuVista.getjM_Config()) {
            configuracionesVista = new ConfiguracionesVista();
            configuracionesControlador = new ConfiguracionesControlador(configuracionesVista, modelo);*/
        } else if (fuente == menuVista.getBtnSalir()) {
            menuVista.cerrar();
        }
    }

}