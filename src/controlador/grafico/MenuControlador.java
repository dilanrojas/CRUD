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

	private MenuVista vistaMenu;
	private ActualizarVista vistaActualizar;
	private ActualizarUsuarioVista vistaActualizarUsuario;
	private ConfiguracionesVista vistaConfg;
	private EliminarVista vistaEliminar;
	private EliminarUsuarioVista vistaEliminarUsuario;
	private InsertarVista vistaInsertar;
	private MostrarVista vistaMostrar;
	private MostrarUsuarioVista vistaUsuarioMostrar;

	private ActualizarControlador controladorAct;
	private ConfiguracionesControlador controladorConfg;
	private EliminarControlador controladorEl;
	private InsertarControlador controladorIns;
	private MostrarControlador controladorMost;

	public MenuControlador(IUsuarioDAO modelo, MenuVista vistaMenu) {
		this.modelo = modelo;
        this.vistaMenu = vistaMenu;

        // Escuchar los eventos del menú principal
        vistaMenu.setEscuchadores(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object fuente = e.getSource();

        if (fuente == vistaMenu.getBtnMostrar()) {
            vistaMostrar = new MostrarVista();
            vistaUsuarioMostrar = new MostrarUsuarioVista();
            controladorMost = new MostrarControlador(modelo, vistaMostrar, vistaUsuarioMostrar);

        } else if (fuente == vistaMenu.getBtnInsertar()) {
            vistaInsertar = new InsertarVista();
            controladorIns = new InsertarControlador(modelo, vistaInsertar);

        } else if (fuente == vistaMenu.getBtnActualizar()) {
            vistaActualizar = new ActualizarVista();
            vistaActualizarUsuario = new ActualizarUsuarioVista();
            controladorAct = new ActualizarControlador(modelo, vistaActualizar, vistaActualizarUsuario);

        } else if (fuente == vistaMenu.getBtnEliminar()) {
            vistaEliminar = new EliminarVista();
            vistaEliminarUsuario = new EliminarUsuarioVista();
            controladorEl = new EliminarControlador(modelo, vistaEliminar, vistaEliminarUsuario);

        /* PENDIENTE --> } else if (fuente == vistaMenu.getjM_Config()) {
            vistaConfg = new ConfiguracionesVista();
            controladorConfg = new ConfiguracionesControlador(vistaConfg, modelo);*/
        } else if (fuente == vistaMenu.getBtnSalir()) {
            vistaMenu.cerrar();
        }
    }

}