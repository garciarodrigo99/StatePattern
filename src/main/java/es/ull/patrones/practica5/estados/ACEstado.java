package es.ull.patrones.practica5.estados;

import es.ull.patrones.practica5.Semaforo;

public abstract class ACEstado {
    Semaforo semaforo;

    public ACEstado (Semaforo semaforo){
        this.semaforo = semaforo;
    }

    public abstract ACEstado changeState();
    public abstract String getSound();

    public abstract String getImagen();

    @Override
    public abstract String toString();

}
