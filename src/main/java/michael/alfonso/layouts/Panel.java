package michael.alfonso.layouts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Panel implements ActionListener {

    private JPanel container;
    private JButton sumar, multiplicar, promedio;
    private ArrayList<JTextField> products = new ArrayList();
    private JTextField totals;

    private JTextField buildForm(String label, Boolean editable){
        JPanel panelForm = new JPanel();
        JLabel labelProduct = new JLabel(label);
        JTextField product = new JTextField("",20);
        product.setEditable(editable);

        panelForm.add(labelProduct);
        panelForm.add(product);
        container.add(panelForm);
        return product;
    }

    public Panel(JFrame frame) {
        container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        frame.add(container);

        JPanel panelTop = new JPanel();
        JLabel labelMenu = new JLabel("Este label es para mostrar el menu seleccionado");
        Menu menuBar = new Menu(labelMenu);
        frame.setJMenuBar(menuBar.menu); // se agrega menu
        panelTop.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
        panelTop.add(labelMenu);
        container.add(panelTop);

        for (int i = 1; i <= 5; i++) {
            this.products.add(this.buildForm("Producto "+i, true));
        }
        totals = this.buildForm("Totales     ", false);

        JPanel panelBottom = new JPanel();
        sumar = new JButton("Sumar");
        sumar.addActionListener(this);

        multiplicar = new JButton("Multiplicar");
        multiplicar.addActionListener(this);

        promedio = new JButton("Promedio");
        promedio.addActionListener(this);

        panelBottom.add(sumar);
        panelBottom.add(multiplicar);
        panelBottom.add(promedio);
        container.add(panelBottom);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double total = 0;
        if (e.getSource()==sumar) {
            for (JTextField product : products){
                total += Double.parseDouble(product.getText());
            }
        }else if (e.getSource()==multiplicar) {
            total = 1;
            for (JTextField product : products){
                total *= Double.parseDouble(product.getText());
            }
        }else if (e.getSource()==promedio) {
            for (JTextField product : products){
                total += Double.parseDouble(product.getText());
            }
            total /= products.size();
        }
        totals.setText(String.valueOf(total));
    }
}