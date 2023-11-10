package es.ull.patrones.practica5;

import es.ull.patrones.practica5.estados.ACEstado;
import es.ull.patrones.practica5.estados.ERojo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
                //System.out.println(decisegundos);
                if(decisegundos == 100){
                    changeState();
                } else if (decisegundos == 130) {
                    changeState();
                } else if (decisegundos == 200) {
                    changeState();
                } else if (decisegundos == 230){
                    decisegundos = 0;
                    System.out.println("reset");
                }
            }
        }, 500, 100);

    }

    private void changeState(){
        this.estado = this.estado.changeState();
        //System.out.println(estado.toString());
    }
    public ACEstado getState(){
        return this.estado;
    }

}
