package es.ull.patrones.practica5;

import es.ull.patrones.practica5.estados.*;

import java.util.Timer;
import java.util.TimerTask;

import java.util.Random;

import static java.lang.Thread.sleep;

public class Semaforo {
    private ACEstado estado = null;
    private Timer cronometro;
    private int decisegundos;

    public Semaforo(){
        this.estado = new ERojo(this);
        this.decisegundos = 0;
        this.cronometro = new Timer();
    }

    public void start(){
        this.cronometro.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                decisegundos++;

                switch (decisegundos) {
                    case 100:
                    case 130:
                    case 202:
                    case 204:
                    case 206:
                    case 208:
                    case 210:
                    case 212:
                    case 214:
                    case 216:
                    case 218:
                    case 220:
                    case 222:
                    case 224:
                    case 226:
                    case 228:
                        changeState();
                        break;
                    case 200:
                        parpadeoVerde(true);
                        break;

                    case 230:
                        parpadeoVerde(false);
                        changeState();
                        decisegundos = 0;
                        break;

                    default:
                        if (probabilidad20()){
                            try {
                                estadoAzul(estado);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }

                    break;
                }
            }
        }, 500, 100);

    }

    private void changeState(){
        this.estado = this.estado.changeState();
        System.out.println(estado.toString()+" "+decisegundos);
    }

    // Ajusta el modo parpadeo
    private void parpadeoVerde(boolean b){
        // Se activa
        if (b) {
            this.estado = new EVerdeOn(Semaforo.this);
        }
        // Se desactiva
        else {
            this.estado = new EVerde(Semaforo.this);
        }
    }
    private void estadoAzul(ACEstado currentState) throws InterruptedException {
        this.estado = new EAzul(Semaforo.this,estado);
        sleep(timeBlue(3,9));
        estado.changeState();
    }
    // Probabilidad entrar en azul
    private boolean probabilidad20() {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(2500) + 1; // Genera un número entre 1 y 100

        // Retorna true si el número aleatorio está en el rango del 20%
        return numeroAleatorio <= 20;
    }
    // Margen de tiempo que dura el semaforo azul(segundos)
    private int timeBlue(int min, int max) {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(max) + min; // Genera un número entre 1 y 100

        return numeroAleatorio *= 1000; // Se devuelve el valor en milisegundos
    }
    public ACEstado getState(){
        return this.estado;
    }

}
