package juego.escenas;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.JOptionPane;

import juego.Assets;
import juego.entidades.AdministradorDeColisiones;
import juego.entidades.Controles;
import juego.entidades.EnemigoBase;
import juego.entidades.Nave;
import motor.Scene;
import motor.entidades.ListaEntidades;
import motor.input.Key;
import motor.util.Vector2D;

/**
 * @author AnaGonzalezC5F593
 * @date 21 nov 2025
 * @version 1.0
 * @description TODO
 */

public abstract class EscenaBase extends Scene {
	public double tiempoEntreOrdas = 1.0;
	public Nave jugador;
	public ListaEntidades balas;
	public ListaEntidades listaEnemigos;
	public AdministradorDeColisiones administrador;

	private int enemigosMuertos = 0;
	private double contador = 0;

	public EscenaBase() {

		this.listaEnemigos = new ListaEntidades();
		this.administrador = new AdministradorDeColisiones();

		Controles controles = new Controles(Key.W, Key.A, Key.D, Key.SPACE);

		this.jugador = new Nave(Assets.textura_nave, new Vector2D(200, 200), controles);
		this.balas = new ListaEntidades();

		this.tiempoEntreOrdas = getTiempoEntreOleadasInicial();
	}

	@Override
	public final void actualizar() {

		if (jugador != null)
			jugador.actualizar();

		balas.actualizar();
		disparar();
		listaEnemigos.actualizar();

		contador += motor.GameLoop.deltaTimeSeconds;
		if (contador > tiempoEntreOrdas) {
			oleadaDeEnemigos();
			contador = 0;
			tiempoEntreOrdas = 10.0;
		}

		if (administrador.detectarColisionesConNave(listaEnemigos, jugador)) {
			JOptionPane.showMessageDialog(null, "Perdiste");
			destruir();
		}

		controlarEnemigos();

		destruir();
	}

	@Override
	public void dibujar(Graphics g) {
		balas.dibujar(g);
		listaEnemigos.dibujar(g);
		if (jugador != null)
			jugador.dibujar(g);
	}

	@Override
	public void destruir() {
		if (jugador != null && !jugador.estaViva())
			jugador = null;

		balas.destruir();
		listaEnemigos.destruir();
	}

	private void disparar() {
		if (jugador != null && jugador.quiereDisparar()) {
			balas.add(jugador.disparar());
			Assets.reproducirDisparo();
		}
	}

	private void controlarEnemigos() {
		if (administrador.detectarColisionesConBalas(listaEnemigos, balas) == 1) {

			enemigosMuertos++;
			Assets.reproducirExplosion();

			if (enemigosMuertos == getCantidadParaGanar()) {
				JOptionPane.showMessageDialog(null, "Ganaste");
				destruir();
			}
		}
	}

	private void oleadaDeEnemigos() {
		int cantidad = getCantidadPorOleada();
		double min = 500;
		double max = 500;

		for (int i = 0; i < cantidad; i++) {
			Vector2D spawn = generarSpawnAlejado(jugador.getTransform().getPosicion(), min, max);
			listaEnemigos.add(crearEnemigo(spawn));
		}
	}

	private Vector2D generarSpawnAlejado(Vector2D centro, double min, double max) {
		Random random = new Random();
		double angulo = random.nextDouble() * Math.PI * 2;
		double distancia = min + (random.nextDouble() * (max - min));
		double x = centro.getX() + Math.cos(angulo) * distancia;
		double y = centro.getY() + Math.sin(angulo) * distancia;
		return new Vector2D(x, y);
	}

	// MÉTODOS ABSTRACTOS

	public abstract EnemigoBase crearEnemigo(Vector2D posicion);

	public abstract int getCantidadParaGanar();

	public abstract int getCantidadPorOleada();

	public abstract double getTiempoEntreOleadasInicial();
}
