package es.ull.patrones.practica5.estados;

import es.ull.patrones.practica5.Semaforo;

public class ERojo extends ACEstado {
    public ERojo(Semaforo semaforo) {
        super(semaforo);
    }

    @Override
    public ACEstado changeState() {
        return new EAmbar(semaforo);
    }

    @Override
    public String getSound() {
        return "src/main/resources/semaforo/sounds/red";
    }

    @Override
    public String getImagen() {
        return "src/main/resources/semaforo/estados/red.png";
    }

    @Override
    public String toString() {
        return "Rojo";
    }
}