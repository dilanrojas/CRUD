package juego.entidades;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import motor.component.Renderer;
import motor.entidades.SpriteMovible;
import motor.entidades.interfaces.IColisionable;
import motor.input.InputMouse;
import motor.util.Vector2D;

/**
 * @author Dilan Rojas
 * @date Nov 18, 2025
 * @version 1.0
 * @description description
 */

public class Enemigo extends SpriteMovible{
	private Vector2D direccionActual;

	public Enemigo(BufferedImage textura, Vector2D posicion) {
		super(textura, posicion);
		
		direccionActual = Vector2D.ZERO;
	}
	
	@Override
	public void actualizar() {
		perseguir(InputMouse.getPosicion());
		super.actualizar();
	}

	@Override
	public void dibujar(Graphics g) {
		super.dibujar(g);
		//Renderer.dibujarCollider(g, this);
	}
	
	public void perseguir(Vector2D posicionJugador) {
		getPhysics().setAceleracion(1.5);
		getMovement().setVelocidad(300);
		
		Vector2D objetivo = posicionJugador.subtract(transform.getPosicion()).normalize();

	    // Suavizado
	    double factorSuavizado = 0.15;
	    direccionActual = direccionActual.lerp(objetivo, factorSuavizado).normalize();

	    // Pequeño ruido angular
	    double maxDesviacion = Math.toRadians(6);
	    double ruido = (Math.random() * 2 - 1) * maxDesviacion;
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
}


