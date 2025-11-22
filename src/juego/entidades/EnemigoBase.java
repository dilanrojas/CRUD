package juego.entidades;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import motor.entidades.SpriteMovible;
import motor.entidades.interfaces.IColisionable;
import motor.util.Vector2D;

/**
 * @author AnaGonzalezC5F593
 * @date 21 nov 2025
 * @version 1.0
 * @description TODO
 */

public abstract class EnemigoBase extends SpriteMovible {

	protected Vector2D direccionActual;
	protected Nave target;

	public EnemigoBase(BufferedImage textura, Vector2D posicion, Nave target) {
		super(textura, posicion);
		this.target = target;

		direccionActual = Vector2D.ZERO;
	}

	@Override
	public void actualizar() {
		mover();
		super.actualizar();

	}

	@Override
	public void dibujar(Graphics g) {
		super.dibujar(g);
	}

	public void perseguir(Vector2D posicionJugador) {

		double velocidad = getVelocidad();
		double aceleracion = getAceleracion();
		double suavizado = getSuavizado();
		double desviacion = getDesviacionAngular();

		getPhysics().setAceleracion(aceleracion);
		getMovement().setVelocidad(velocidad);

		Vector2D objetivo = posicionJugador.subtract(transform.getPosicion()).normalize();

		// Suavizado distinto por tipo de enemigo
		direccionActual = direccionActual.lerp(objetivo, suavizado).normalize();

		// Pequeño ruido angular
		double ruido = (Math.random() * 2 - 1) * desviacion;
		double cos = Math.cos(ruido);
		double sin = Math.sin(ruido);
		double x = direccionActual.getX() * cos - direccionActual.getY() * sin;
		double y = direccionActual.getX() * sin + direccionActual.getY() * cos;

		direccionActual = new Vector2D(x, y).normalize();

		movement.setDireccion(direccionActual);
		physics.acelerar(movement);
		movement.mover(transform);

	}

	@Override
	public void alColisionarCon(IColisionable otro) {
		super.destruir();
	}

	// MÉTODOS ABSTRACTOS
	public abstract double getVelocidad();

	public abstract double getAceleracion();

	public abstract double getSuavizado();

	public abstract double getDesviacionAngular();

	public abstract void mover();

}

	public abstract void mover();

	public abstract void atacar();
}

