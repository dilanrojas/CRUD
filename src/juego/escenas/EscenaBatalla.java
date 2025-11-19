package juego.escenas;

import java.awt.Graphics;

import juego.Assets;
import juego.entidades.AdministradorDeColisiones;
import juego.entidades.Bala;
import juego.entidades.Controles;
import juego.entidades.Nave;
import motor.Scene;
import motor.entidades.ListaEntidades;
import motor.input.Key;
import motor.util.Vector2D;

/**
 * @author Dilan Rojas
 * @date Nov 18, 2025
 * @version 1.0
 * @description description
 */

public class EscenaBatalla extends Scene {

	private Nave jugador1;
	private Nave jugador2;
	private ListaEntidades balasJ1;
	private ListaEntidades balasJ2;
	private AdministradorDeColisiones colisiones;
	
	public EscenaBatalla() {
		Controles controles1 = new Controles(Key.UP, Key.LEFT, Key.RIGHT, Key.M);
		Controles controles2 = new Controles(Key.W, Key.A, Key.D, Key.SPACE);
		
		jugador1 = new Nave(Assets.textura_nave_1, new Vector2D(200,200), controles1);
		jugador2 = new Nave(Assets.textura_nave_2, new Vector2D(400,200), controles2);
		
		jugador2.getFireDerecho().setTextura(Assets.textura_fire_2);
		jugador2.getFireIzquierdo().setTextura(Assets.textura_fire_2);
		
		balasJ1 =  new ListaEntidades();
		balasJ2 =  new ListaEntidades();
		
		colisiones = new AdministradorDeColisiones();
	}
	
	@Override
	public void actualizar() {
		if (jugador1!=null) {
			jugador1.actualizar();
		}
		
		if (jugador2!=null) {
			jugador2.actualizar();
		}
		
		balasJ1.actualizar();
		balasJ2.actualizar();
		
		disparar();
		
		colisiones.detectarColisionesConNave(balasJ1, jugador2);
		colisiones.detectarColisionesConNave(balasJ2, jugador1);
		
		destruir();
	}
	
	@Override
	public void dibujar(Graphics g) {
		balasJ1.dibujar(g);
		balasJ2.dibujar(g);
		
		if (jugador1!=null) {
			jugador1.dibujar(g);
		}
		
		if (jugador2!=null) {
			jugador2.dibujar(g);
		}
		

	}

	@Override
	public void destruir() {
		if (jugador1!=null && jugador2!=null) {
			if (!jugador1.estaViva()) {
				jugador1 = null;
			}
			
			if (!jugador2.estaViva()) {
				jugador2 = null;
			}
		}

		balasJ1.destruir();
		balasJ2.destruir();
	}

	private void disparar() {
		if (jugador1!=null && jugador1.quiereDisparar()) {
			balasJ1.add(jugador1.disparar());
        }
		
        if (jugador2!=null && jugador2.quiereDisparar()) {
        	Bala bala = jugador2.disparar();
        	bala.setTextura(Assets.textura_bala_2);
        	balasJ2.add(bala);
        }
	}


}


