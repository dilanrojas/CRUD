package juego.escenas;

/**
 * @author AnaGonzalezC5F593
 * @date 21 nov 2025
 * @version 1.0
 * @description TODO
 */

public class EscenaFacilNivel1 extends EscenaFacil {

    public EscenaFacilNivel1() {
        super();
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
        return 0.8; 
    }
}


