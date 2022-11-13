package michael.alfonso.layouts;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu implements ActionListener{

    public final JMenuBar menu;
    private final JMenuItem menuItem11;
    private final JMenuItem menuItem21;
    private final JLabel labelStatus;

    public Menu(JLabel label){
        labelStatus = label;
        menu = new JMenuBar();
        JMenu menu1 = new JMenu("Opciones");
        menu.add(menu1);

        JMenu menu2 = new JMenu("Otras opciones");
        menu.add(menu2);

        menuItem11 = new JMenuItem("Opt11");
        menu1.add(menuItem11);
        menuItem11.addActionListener(this);

        menuItem21 = new JMenuItem("Opt21");
        menu2.add(menuItem21);
        menuItem21.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==menuItem11) {
            labelStatus.setText("Selecciono la opcion Opt11");
            System.out.println("hola");
        }
        if (e.getSource()==menuItem21) {
            labelStatus.setText("Selecciono la opcion Opt21");
            System.out.println("hola2");
        }
    }
}
