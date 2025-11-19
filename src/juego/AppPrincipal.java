package juego;

import juego.escenas.EscenaBatalla;
import motor.GameLoop;

/**
 * @author Dilan Rojas
 * @date Nov 18, 2025
 * @version 1.0
 * @description description
 */

public class AppPrincipal {
    public void iniciar() {
        // Paso 1: Cargar los recursos del juego: imágenes, sonidos, fuentes
        if (Assets.cargados()) {
            // Paso 2: Crear el juego
            Game game = new Game(new EscenaBatalla());
            // Paso 3: Iniciar el bucle principal del juego
            GameLoop gameLoop = new GameLoop(game);
        }
    }

    public static void main(String[] args) {
        AppPrincipal app = new AppPrincipal();
        app.iniciar();
    }
}
