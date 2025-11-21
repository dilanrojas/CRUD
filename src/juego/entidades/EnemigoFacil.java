package juego.entidades;

import java.awt.image.BufferedImage;

import motor.util.Vector2D;

/**
 * @author AnaGonzalezC5F593
 * @date 21 nov 2025
 * @version 1.0
 * @description Clase EnemigoFacil es un enemigo sencillo, el cual no tiene un ataque especial ya quesu forma de ataque es colisionar con el jugador.
 */

public class EnemigoFacil extends EnemigoBase {

	public EnemigoFacil(BufferedImage textura, Vector2D posicion, Nave target) {
		super(textura, posicion, target);
	}

	@Override
	public double getVelocidad() {
		return 50.0;
	}

	@Override
	public double getAceleracion() {
		return 1.5;
	}

	@Override
	public double getSuavizado() {
		return 15.0;
	}

	@Override
	public double getDesviacionAngular() {
		return 0.05;
	}

	@Override
	public void mover() {
		perseguir(target.getPosicion());
	}

	@Override
	public void atacar() {
	}

}
