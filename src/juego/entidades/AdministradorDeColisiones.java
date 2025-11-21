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
	
	public int detectarColisionesConBalas(ListaEntidades entidades1, ListaEntidades entidades2) {
	    if (entidades1 == null || entidades2 == null) return -1;

	    for (int i = 0; i < entidades1.getSize(); i++) {
	        IColisionable bala = (IColisionable) entidades1.get(i);
	        if (bala == null) continue;

	        for (int j = 0; j < entidades2.getSize(); j++) {
	            IColisionable enemigo = (IColisionable) entidades2.get(j);
	            if (enemigo == null) continue;

	            if (enemigo.getCollider().colisionaCon(bala)) {
	                enemigo.alColisionarCon(bala);
	                
	                bala.alColisionarCon(enemigo);
	                System.out.println("mataste uno");
	                return 1;
	            }
	        }
	    }
	    
	    return -1;
	}

	
	public boolean detectarColisionesConNave(ListaEntidades entidades, IColisionable entidad) {
		if (entidades == null || entidades.getSize() == 0 || entidad == null) {
			return false;
		}

		for (int i = 0; i < entidades.getSize(); i++) {
			IColisionable elemento = (IColisionable) entidades.get(i);
			if (elemento != null) {
				if (elemento.getCollider().colisionaCon(entidad)) {
					elemento.alColisionarCon(entidad);
					entidad.alColisionarCon(elemento);
					return true;
				}
			}
		}

		return false;
	}
	
	

}
