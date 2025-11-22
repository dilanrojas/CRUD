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


public class EnemigoDificil extends EnemigoBase {

    public EnemigoDificil(BufferedImage textura, Vector2D posicion, Nave target) {
        super(Assets.textura_enemigoDificil, posicion, target);
    }

    @Override
    public double getVelocidad() { return 200.0; }

    @Override
    public double getAceleracion() { return 2.5; }

    @Override
    public double getSuavizado() { return 10.0; }

    @Override
    public double getDesviacionAngular() { return 0.5; }

    @Override
    public void mover() {
        // Movimiento aleatorio con tendencia hacia el jugador
        Vector2D objetivo = target.getPosicion().subtract(transform.getPosicion()).normalize();
        Vector2D aleatorio = new Vector2D(Math.random() * 2 - 1, Math.random() * 2 - 1).normalize();
        direccionActual = objetivo.add(aleatorio).normalize();

        movement.setDireccion(direccionActual);
        physics.acelerar(movement);
        movement.mover(transform);
    }

    
}
