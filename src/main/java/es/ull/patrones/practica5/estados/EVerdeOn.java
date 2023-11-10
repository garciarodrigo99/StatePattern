package es.ull.patrones.practica5.estados;

import es.ull.patrones.practica5.Semaforo;

public class EVerdeOn extends EVerde {
    public EVerdeOn(Semaforo semaforo) {
        super(semaforo);
    }
    @Override
    public ACEstado changeState() {
        return new EVerdeOff(semaforo);
    }

    @Override
    public String getImagen() {
        return "src/main/resources/semaforo/estados/green.png";
    }

    @Override
    public String toString() {
        return "Verde ON";
    }
}
