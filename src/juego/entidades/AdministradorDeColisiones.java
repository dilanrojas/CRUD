package juego.entidades;

import motor.entidades.ListaEntidades;
import motor.entidades.interfaces.IColisionable;
import motor.util.Vector2D;

/**
 * @author Dilan Rojas
 * @date Nov 18, 2025
 * @version 1.0
 * @description description
 */

public class AdministradorDeColisiones {

	public void detectarColisionesConPunto(ListaEntidades entidades, Vector2D punto) {
		if (entidades == null || entidades.getSize() == 0 || punto == null) {
			return;
		}

		for (int i = 0; i < entidades.getSize(); i++) {
			IColisionable entidad = (IColisionable) entidades.get(i);
			if (entidad != null) {
				if (entidad.getCollider().colisionaCon(punto)) {
					entidad.alColisionarCon(entidad);
				}
			}
		}
	}
	
	public void detectarColisionesConNave(ListaEntidades entidades, IColisionable entidad) {
		if (entidades == null || entidades.getSize() == 0 || entidad == null) {
			return;
		}

		for (int i = 0; i < entidades.getSize(); i++) {
			IColisionable elemento = (IColisionable) entidades.get(i);
			if (elemento != null) {
				if (elemento.getCollider().colisionaCon(entidad)) {
					elemento.alColisionarCon(entidad);
					entidad.alColisionarCon(elemento);
				}
			}
		}

	}
	
	

}
