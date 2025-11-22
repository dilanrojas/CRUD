package juego.escenas;

import java.lang.annotation.Target;

/**
 * @author AnaGonzalezC5F593
 * @date 21 nov 2025
 * @version 1.0
 * @description  contiene configuración base para cualquier nivel de dificultad fácil.
 */

import juego.entidades.EnemigoBase;
import juego.entidades.EnemigoFacil;
import motor.util.Vector2D;

public class EscenaFacil extends EscenaBase {

	public EscenaFacil() {
		super();
	}

	@Override
	public EnemigoBase crearEnemigo(Vector2D posicion) {
		return new EnemigoFacil(posicion, jugador);
	}

	@Override
	public int getCantidadParaGanar() {
		return 3;
	}

	@Override
	public int getCantidadPorOleada() {
		return 2;
	}

	@Override
	public double getTiempoEntreOleadasInicial() {
		return 1.5;
	}


}
