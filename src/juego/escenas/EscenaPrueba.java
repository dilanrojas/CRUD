package juego.escenas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import juego.Assets;
import juego.Config;
import juego.entidades.AdministradorDeColisiones;
import juego.entidades.Bala;
import juego.entidades.Enemigo;
import juego.entidades.Nave;
import motor.Entidad;
import motor.GameLoop;
import motor.Scene;
import motor.component.Renderer;
import motor.entidades.ListaEntidades;
import motor.input.InputKeyboard;
import motor.input.InputMouse;
import motor.input.Key;
import motor.util.Vector2D;

/**
 * @author Dilan Rojas
 * @date Nov 18, 2025
 * @version 1.0
 * @description description
 */

public class EscenaPrueba extends Scene {
	private ListaEntidades listaDeEnemigos;
	private final AdministradorDeColisiones colisiones;
	private double cronometro = 0;

	public EscenaPrueba() {
		listaDeEnemigos = new ListaEntidades();
		colisiones = new AdministradorDeColisiones();
	}

	@Override
	public void actualizar() {
		// validamos que los objetos no esten null (importante)
		if (listaDeEnemigos != null) {

			//oleada de enemigos
			cronometro += GameLoop.deltaTimeSeconds;
			if (cronometro > 2) {
				oleadaDeEnemigos();
				cronometro = 0;
			}

			colisiones.detectarColisionesConPunto(listaDeEnemigos, InputMouse.getPosicion());
			
			listaDeEnemigos.actualizar();

			destruir();
		}
	}

	@Override
	public void dibujar(Graphics g) {
		if (listaDeEnemigos != null) {
			listaDeEnemigos.dibujar(g);
		}
	}

	@Override
	public void destruir() {
		listaDeEnemigos.destruir();
	}
	
	private void oleadaDeEnemigos() {
		for (int i = 0; i < 10; i++) {
			BufferedImage textura = Renderer.crearTextura(
					new Rectangle(20, 20), 
					new Color(
							new Random().nextInt(255), 
							new Random().nextInt(255), 
							new Random().nextInt(255)
							)
					);

			Entidad enemigo = new Enemigo(textura, new Vector2D(
					new Random().nextInt(Config.WIDTH), 
					new Random().nextInt(Config.HEIGHT)));
			
			listaDeEnemigos.add(enemigo);
		}
	}
	
	
}
