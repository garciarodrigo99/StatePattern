package es.ull.patrones.practica5;

import es.ull.patrones.practica5.estados.ACEstado;
import es.ull.patrones.practica5.estados.ERojo;
import es.ull.patrones.practica5.estados.EVerde;
import es.ull.patrones.practica5.estados.EVerdeOn;

import java.util.Timer;
import java.util.TimerTask;

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
    public ACEstado getState(){
        return this.estado;
    }

}
