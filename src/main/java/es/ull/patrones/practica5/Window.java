package es.ull.patrones.practica5;

import es.ull.patrones.practica5.Semaforo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;

public class Window {
    private JFrame frame;
    private JLabel imageLabel;
    private Semaforo sem;
    private Timer timer;

    public Window() {
        frame = new JFrame("Semaforo");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        imageLabel = new JLabel();
        frame.add(imageLabel);

        sem = new Semaforo();

        // Crea un temporizador que se activa cada 500 milisegundos (0.5 segundos)
        timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Actualiza la imagen en la etiqueta
                actualizarImagen();
            }
        });

        // Inicia el temporizador
        timer.start();

        // Configura la GUI
        frame.setVisible(true);
    }

    private void actualizarImagen() {
        // Obtiene el InputStream de la imagen desde semáforo
        InputStream imageStream = getClass().getResourceAsStream(sem.getState().getImagen());

        try {
            // Lee la imagen desde el InputStream utilizando ImageIO
            Image image = ImageIO.read(imageStream);

            // Escala el Image a la nueva dimensión
            Image scaledImage = image.getScaledInstance(200, 200, Image.SCALE_DEFAULT);

            // Crea el ImageIcon desde el Image escalado
            ImageIcon newImageIcon = new ImageIcon(scaledImage);

            // Muestra el ImageIcon en la etiqueta
            imageLabel.setIcon(newImageIcon);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Window();
            }
        });
    }
}
