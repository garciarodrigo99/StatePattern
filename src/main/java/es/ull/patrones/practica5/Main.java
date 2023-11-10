package es.ull.patrones.practica5;

public class Main {
    public static void main(String[] args) {
        Semaforo semaforo = new Semaforo();
        SemaforoPanel semaforoPanel = new SemaforoPanel(semaforo);
        semaforoPanel.display();
    }
}
