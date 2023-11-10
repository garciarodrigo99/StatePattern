package es.ull.patrones.practica5;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Semaforo sem = new Semaforo();
        Timer t = new Timer();
        int[] decisec = {0};
        sem.start();
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                decisec[0]++;
                System.out.println(sem.getState().toString());
            }
        }, 0, 1000);
    }
}