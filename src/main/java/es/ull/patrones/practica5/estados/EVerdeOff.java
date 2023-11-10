package es.ull.patrones.practica5.estados;

import es.ull.patrones.practica5.Semaforo;

public class EVerdeOff extends EVerde {
    public EVerdeOff(Semaforo semaforo) {
        super(semaforo);
    }
    @Override
    public ACEstado changeState() {
        return new EVerdeOn(semaforo);
    }

    @Override
    public String getImagen() {
        return "src/main/resources/semaforo/estados/black.png";
    }

    @Override
    public String toString() {
        return "Verde OFF";
    }
}
