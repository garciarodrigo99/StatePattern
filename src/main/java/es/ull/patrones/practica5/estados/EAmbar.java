package es.ull.patrones.practica5.estados;

import es.ull.patrones.practica5.Semaforo;

public class EAmbar extends ACEstado {
    public EAmbar(Semaforo semaforo) {
        super(semaforo);
    }

    @Override
    public ACEstado changeState() {
        return new EVerde(semaforo);
    }

    @Override
    public String getSound() {
        return "src/main/resources/semaforo/sounds/yellow";
    }

    @Override
    public String getImagen() {
        return "src/main/resources/semaforo/estados/yellow.png";
    }

    @Override
    public String toString() {
        return "Ambar";
    }
}