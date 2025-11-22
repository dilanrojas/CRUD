package juego.entidades;

import java.awt.image.BufferedImage;

import juego.Assets;
import motor.util.Vector2D;

/**
 * @author AnaGonzalezC5F593
 * @date 21 nov 2025
 * @version 1.0
 * @description TODO
 */

public class EnemigoMedio extends EnemigoBase {

	private double zigzagOffset = 0;

	public EnemigoMedio(BufferedImage textura, Vector2D posicion, Nave target) {
		super(Assets.textura_enemigoMedio, posicion, target);
	}

	@Override
	public double getVelocidad() {
		return 70.0;
	}

	@Override
	public double getAceleracion() {
		return 2.0;
	}

	@Override
	public double getSuavizado() {
		return 10.0;
	}

	@Override
	public double getDesviacionAngular() {
		return 0.1;
	}

	@Override
	public void mover() {
		// Movimiento zigzag mientras persigue
		zigzagOffset += 2.5;
		Vector2D objetivo = target.getPosicion().subtract(transform.getPosicion()).normalize();
		Vector2D zigzag = new Vector2D(Math.sin(zigzagOffset) * 1.5, Math.cos(zigzagOffset) * 1.5);
		direccionActual = objetivo.add(zigzag).normalize();

		movement.setDireccion(direccionActual);
		physics.acelerar(movement);
		movement.mover(transform);
	}
}
