package controlador.grafico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.dao.IUsuarioDAO;
import vista.grafico.ActualizarUsuarioVista;
import vista.grafico.ActualizarVista;
import vista.grafico.ConfiguracionesVista;
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
	private InsertarVista vistaInsertar;
	private MostrarVista vistaMostrar;
	private MostrarUsuarioVista vistaUsuarioMostrar;

	private ActualizarControlador controladorAct;
	private ConfiguracionesControlador controladorConfg;
	private EliminarControlador controladorEl;
	private InsertarControlador controladorIns;
	private MostrarControlador controladorMost;

	public MenuControlador(MenuVista vistaMenu, IUsuarioDAO modelo) {
        this.vistaMenu = vistaMenu;
        this.modelo = modelo;

        // Escuchar los eventos del menú principal
        vistaMenu.setEscuchadores(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object fuente = e.getSource();

        if (fuente == vistaMenu.getjM_Mostrar()) {
            vistaMostrar = new MostrarVista();
            controladorMost = new MostrarControlador(modelo, vistaMostrar, vistaUsuarioMostrar);

        } else if (fuente == vistaMenu.getjM_Insertar()) {
            vistaInsertar = new InsertarVista();
            controladorIns = new InsertarControlador(vistaInsertar, modelo);

        } else if (fuente == vistaMenu.getjM_Actualizar()) {
            vistaActualizar = new ActualizarVista();
            controladorAct = new ActualizarControlador(modelo, vistaActualizar, vistaActualizarUsuario);

        } else if (fuente == vistaMenu.getjM_Eliminar()) {
            vistaEliminar = new EliminarVista();
            controladorEl = new EliminarControlador(vistaEliminar, modelo);

        /* PENDIENTE --> } else if (fuente == vistaMenu.getjM_Config()) {
            vistaConfg = new ConfiguracionesVista();
            controladorConfg = new ConfiguracionesControlador(vistaConfg, modelo);*/
        } else if (fuente == vistaMenu.getjM_Salir()) {
            vistaMenu.cerrar();
        }
    }

}