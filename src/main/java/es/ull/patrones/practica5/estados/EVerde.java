package es.ull.patrones.practica5.estados;

import es.ull.patrones.practica5.Semaforo;

public class EVerde extends ACEstado {

    public EVerde(Semaforo semaforo) {
        super(semaforo);
    }

    @Override
    public ACEstado changeState() {
        return new ERojo(semaforo);
    }

    @Override
    public String getSound() {
        return "src/main/resources/semaforo/sounds/green";
    }

    @Override
    public String getImagen() {
        return "src/main/resources/semaforo/estados/green.png";
    }

    @Override
    public String toString() {
        return "Verde";
    }
}
