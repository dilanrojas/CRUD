package juego.escenas;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.JOptionPane;

import juego.Assets;
import juego.Config;
import juego.entidades.AdministradorDeColisiones;
import juego.entidades.Controles;
import juego.entidades.EnemigoFacil;
import juego.entidades.Nave;
import motor.Scene;
import motor.entidades.ListaEntidades;
import motor.input.Key;
import motor.util.Vector2D;

/**
 * @author AnaGonzalezC5F593
 * @date 20 nov 2025
 * @version 1.0
 * @description TODO
 */

public class EscenaNivel1 extends Scene {
	private double tiempoEntreOrdas = 1.0;
	
	private Nave jugador;
	private ListaEntidades balas;
	
	private int enemigosMuertos = 0;
	private final int ENEMIGOS_PARA_GANAR = 5;
	
	private EnemigoFacil enemigoFacil;
	private ListaEntidades listaEnemigos;
	private AdministradorDeColisiones administrador;
	private double contador;
	
	public EscenaNivel1() {
		this.listaEnemigos = new ListaEntidades();
		
		this.contador = 0;
		this.administrador = new AdministradorDeColisiones();
		
		Controles controles = new Controles(Key.W, Key.A, Key.D, Key.SPACE);
		
		this.jugador = new Nave(Assets.textura_nave, new Vector2D(200,200), controles);
		this.balas =  new ListaEntidades();
		
		Vector2D posicion = new Vector2D(200, 200);
		this.enemigoFacil = new EnemigoFacil(posicion, jugador);
	}
	
	@Override
	public void actualizar() {
		if (jugador != null) {
			jugador.actualizar();
		}
		
		balas.actualizar();
		
		disparar();
		listaEnemigos.actualizar();
		
		contador += motor.GameLoop.deltaTimeSeconds;
		if (contador > tiempoEntreOrdas) {
			oleadaDeEnemigos();
			listaEnemigos.actualizar();
			this.contador = 0;
			if (tiempoEntreOrdas == tiempoEntreOrdas) tiempoEntreOrdas = 10.0;
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
		
		if (listaEnemigos != null) listaEnemigos.dibujar(g);
		
		if (jugador != null) jugador.dibujar(g);
	}
	
	@Override
	public void destruir() {		
		if (jugador != null) {
			if (!jugador.estaViva()) {
				jugador = null;
			}
		}
		
		balas.destruir();
		
		listaEnemigos.destruir();
	}
	
	public void oleadaDeEnemigos() {
	    int cantidadEnemigosNuevos = 8;
	    double distanciaMin = 500;
	    double distanciaMax = 500;

	    for (int i = 0; i < cantidadEnemigosNuevos; i++) {

	        Vector2D spawn = generarSpawnAlejado(
	                jugador.getTransform().getPosicion(), 
	                distanciaMin, 
	                distanciaMax
	        );

	        listaEnemigos.add(new EnemigoFacil(spawn, jugador));
	    }
	}

	
	private void disparar() {
		if (jugador != null && jugador.quiereDisparar()) {
			balas.add(jugador.disparar());
			Assets.reproducirDisparo();
        }
	}
	
	private void controlarEnemigos() {
		if (listaEnemigos != null && administrador.detectarColisionesConBalas(listaEnemigos, balas) == 1) {
			enemigosMuertos += 1;
			Assets.reproducirExplosion();
			
			if (enemigosMuertos == ENEMIGOS_PARA_GANAR) {
				JOptionPane.showMessageDialog(null, "Ganaste");
				destruir();
			}
		}
	}
	
	private Vector2D generarSpawnAlejado(Vector2D centro, double distanciaMin, double distanciaMax) {
	    Random random = new Random();

	    // Elegimos un ángulo aleatorio 0°–360°
	    double angulo = random.nextDouble() * Math.PI * 2;

	    // Elegimos una distancia aleatoria entre min y max
	    double distancia = distanciaMin + (random.nextDouble() * (distanciaMax - distanciaMin));

	    // Convertimos polar → cartesiano
	    double x = centro.getX() + Math.cos(angulo) * distancia;
	    double y = centro.getY() + Math.sin(angulo) * distancia;

	    return new Vector2D(x, y);
	}

}
