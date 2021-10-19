package app.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Restaurantgui {
    private JPanel panelRestaurant;
    private JLabel labelTFM;
    private JLabel label2;
    private JButton butonMeniuri;
    private JButton butonComanda;
    private JButton butonAdmin;
    private JButton butonIesire;
    private JFrame jFrame;
    public Restaurantgui() {
        jFrame = new JFrame("Restaurant" );
        jFrame.setContentPane(panelRestaurant);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setSize(250,300);
        jFrame.setLocation(650,250);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        butonMeniuri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jFrame.setVisible(false);
                Meniuri m = new Meniuri();
                m.getJFMeniu().setVisible(true);
            }
        });
            butonComanda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jFrame.setVisible(false);
                CreareComanda cc = new CreareComanda();
                cc.getJFComanda().setVisible(true);
            }
        });
        butonAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jFrame.setVisible(false);
                Admin a = new Admin();
                a.getJFAdmin().setVisible(true);
            }
        });
        butonIesire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, "Multumim ca ati ales TheForestMan!", "Result", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        });
    }
    public JFrame getJFRestaurant(){
        return this.jFrame;
    }
    public static void main(String[] args) {
        Restaurantgui r = new Restaurantgui();

    }
}
