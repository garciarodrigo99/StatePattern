package es.ull.patrones.practica5.estados;

import es.ull.patrones.practica5.Semaforo;

public class EAzul extends ACEstado {
    private ACEstado callerState = null;
    public EAzul(Semaforo semaforo,ACEstado callerState) {
        super(semaforo);
        this.callerState = callerState;
    }

    @Override
    public ACEstado changeState() {
        return this.callerState;
    }

    @Override
    public String getSound() {
        return null;
    }

    @Override
    public String getImagen() {
        return "src/main/resources/semaforo/estados/blue.png";
    }

    @Override
    public String toString() {
        return "Azul";
    }
}
