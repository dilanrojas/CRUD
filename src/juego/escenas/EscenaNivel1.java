package juego.escenas;

import java.awt.Graphics;
import java.util.Random;
import javax.swing.JOptionPane;

import juego.entidades.Enemigo;
import juego.entidades.Nave;
import motor.Scene;
import motor.entidades.ListaEntidades;
import motor.input.Key;
import motor.util.Vector2D;
import juego.entidades.Bala;
import juego.entidades.Controles;
import juego.Assets;
import juego.entidades.AdministradorDeColisiones;

/**
 * @author AnaGonzalezC5F593
 * @date 20 nov 2025
 * @version 1.0
 * @description TODO
 */

public class EscenaNivel1 extends Scene {

	private Nave jugador;
	private ListaEntidades enemigos;
	private ListaEntidades balasJugador;
	private AdministradorDeColisiones colisiones;

	private int enemigosMuertos = 0;
	private final int ENEMIGOS_PARA_GANAR = 3;

	private double cronometroSpawn = 0;
	private boolean nivelActivo = true;
	private Random rnd = new Random();

	public EscenaNivel1() {

		enemigos = new ListaEntidades();
		balasJugador = new ListaEntidades();
		colisiones = new AdministradorDeColisiones();

		Controles controles1 = new Controles(Key.UP, Key.LEFT, Key.RIGHT, Key.M);
		jugador = new Nave(Assets.textura_nave_1, new Vector2D(400, 300), controles1);

		generarEnemigoInstantaneo();
	}

	@Override
	public void actualizar() {
		if (!nivelActivo)
			return;

		if (jugador != null) {
			jugador.actualizar();
		}

		enemigos.actualizar();
		balasJugador.actualizar();
		for (int i = 0; i < enemigos.getSize(); i++) {
		    Enemigo e = (Enemigo) enemigos.get(i);
		    e.perseguir(jugador.getTransform().getPosicion());
		}

		if (jugador != null && jugador.quiereDisparar()) {
			Object balaObj = jugador.disparar();
			if (balaObj instanceof Bala) {
				balasJugador.add((Bala) balaObj);
			} 
		}

		sincronizarMovimientoEnemigosHaciaJugador();

		// - balas del jugador vs enemigos
		///colisiones.detectarColisionesEntreEntidades(balasJugador, enemigos);

		colisiones.detectarColisionesConNave(enemigos, jugador);

		// eliminar entidades muertas y comprobar condiciones
		destruir();

		//  si no hay enemigo vivo, generar otro inmediatamente
		if (enemigos.getSize() == 0) {
			generarEnemigoInstantaneo();
		}

	}

	@Override
	public void dibujar(Graphics g) {

		enemigos.dibujar(g);

		balasJugador.dibujar(g);

		if (jugador != null) {
			jugador.dibujar(g);
		}
	}

	@Override
	public void destruir() {

		enemigos.destruir();
		balasJugador.destruir();

		// Game Over
		if (jugador == null || !jugador.estaViva()) {
			nivelActivo = false;
			mostrarGameOver();
		}

		// Gana
		if (enemigosMuertos >= ENEMIGOS_PARA_GANAR) {
			nivelActivo = false;
			mostrarGanaste();
		}
	}

	private void generarEnemigoInstantaneo() {

		int x, y;
		int pantallaW = 800;
		int pantallaH = 600;

		int borde = rnd.nextInt(4);
		switch (borde) {
		case 0 -> { // arriba
			x = rnd.nextInt(pantallaW);
			y = 0;
		}
		case 1 -> { // abajo
			x = rnd.nextInt(pantallaW);
			y = pantallaH;
		}
		case 2 -> { // izquierda
			x = 0;
			y = rnd.nextInt(pantallaH);
		}
		default -> { // derecha
			x = pantallaW;
			y = rnd.nextInt(pantallaH);
		}
		}

		// Crear enemigo
		Enemigo enemigo = new Enemigo(Assets.textura_nave_2, new Vector2D(x, y));

		if (enemigo.getMovement() != null) {
			enemigo.getMovement().setVelocidad(100);
		}

		enemigos.add(enemigo);
	}

	private void sincronizarMovimientoEnemigosHaciaJugador() {
		if (jugador == null || enemigos == null)
			return;
		int size = enemigos.getSize();
		for (int i = 0; i < size; i++) {
			Object obj = enemigos.get(i);
			if (obj instanceof Enemigo enemigo) {
				if (jugador != null) {

					Vector2D posEn = enemigo.getTransform().getPosicion();
					Vector2D posJ = jugador.getTransform().getPosicion();
					Vector2D dir = posJ.subtract(posEn).normalize();
					
					double angulo = Math.toDegrees(Math.atan2(dir.getY(), dir.getX()));
					if (enemigo.getMovement() != null) {
						enemigo.getMovement().setDireccion((int) angulo);

					}
				}
			}
		}
	}

	public void manejarEnemigoMuerto() {
		enemigosMuertos++;
	}

	private void mostrarGameOver() {
		JOptionPane.showMessageDialog(null, "Game Over", "Nivel 1", JOptionPane.INFORMATION_MESSAGE);

		// volver al menú del juego o cerrar/terminar la escena
	}

	private void mostrarGanaste() {
		JOptionPane.showMessageDialog(null, "¡Ganaste Nivel 1!", "Nivel 1", JOptionPane.INFORMATION_MESSAGE);

		// TODO: notificar al controlador que el nivel terminó correctamente
	}
}