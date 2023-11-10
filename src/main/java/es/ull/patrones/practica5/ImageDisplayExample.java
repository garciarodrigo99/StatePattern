package es.ull.patrones.practica5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImageDisplayExample {
    private static final int TARGET_WIDTH = 700;
    private static final int TARGET_HEIGHT = 700;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Semaforo");
            frame.setSize(1200, 1000);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Crear un JPanel personalizado con un fondo de imagen
            JPanel panel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);

                    // Cargar la imagen de fondo
                    ImageIcon backgroundImage = new ImageIcon("src/main/resources/semaforo/fondo.jpg");
                    Image image = backgroundImage.getImage();

                    // Dibujar la imagen de fondo en el JPanel
                    g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
                }
            };

            // Establecer el diseño del JPanel
            panel.setLayout(new GridBagLayout());

            JLabel label = new JLabel();

            // Restricciones para centrar en el contenedor
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.gridx = 0;
            constraints.gridy = 0;
            constraints.weightx = 1.0;
            constraints.weighty = 1.0;
            constraints.fill = GridBagConstraints.CENTER;

            panel.add(label, constraints);

            frame.add(panel);

            Semaforo semaforo = new Semaforo();
            semaforo.start();
            // Crea un temporizador que se activa cada 500 milisegundos (0.5 segundos)
            Timer timer = new Timer(500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Actualiza la imagen en la etiqueta
                    ImageIcon originalIcon = new ImageIcon(semaforo.getState().getImagen());
                    ImageIcon scaledIcon = scaleImage(originalIcon, TARGET_WIDTH, TARGET_HEIGHT);
                    label.setIcon(scaledIcon);
                }
            });

            // Inicia el temporizador
            timer.start();

            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    private static ImageIcon scaleImage(ImageIcon originalIcon, int targetWidth, int targetHeight) {
        // Obtener la imagen original
        Image originalImage = originalIcon.getImage();

        // Calcular las nuevas dimensiones manteniendo la proporción
        int originalWidth = originalImage.getWidth(null);
        int originalHeight = originalImage.getHeight(null);
        int newWidth = originalWidth;
        int newHeight = originalHeight;

        double widthRatio = (double) targetWidth / originalWidth;
        double heightRatio = (double) targetHeight / originalHeight;

        double minRatio = Math.min(widthRatio, heightRatio);

        newWidth = (int) (originalWidth * minRatio);
        newHeight = (int) (originalHeight * minRatio);

        // Crear una imagen escalada
        Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

        // Crear un ImageIcon a partir de la imagen escalada
        return new ImageIcon(scaledImage);
    }
}
