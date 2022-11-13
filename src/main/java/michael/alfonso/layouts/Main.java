package michael.alfonso.layouts;

import javax.swing.*;

public class Main extends JPanel {
    public Main() {
        JFrame frame = new JFrame();
        new Panel(frame); // instancio la clase panel
        frame.setSize(500,500); //asigno tamaño de la ventana
        frame.setLocationRelativeTo(null); // Aparece centrado
        frame.setVisible(true); // Sea visible la app
    }
}