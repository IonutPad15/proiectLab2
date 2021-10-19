package app.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import app.GUI.ListaMeniuri.*;
public class Meniuri {
    private JLabel labelMeniuri;
    private JButton butonM1;
    private JButton butonM2;
    private JButton butonM3;
    private JButton butonM4;
    private JPanel panelMeniuri;
    private JButton butonInapoi;
    private JFrame jfmeniu ;
    public Meniuri(){
        jfmeniu = new JFrame("Meniuri" );
        jfmeniu.setContentPane(panelMeniuri);
        jfmeniu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfmeniu.pack();
        jfmeniu.setSize(300,200);
        jfmeniu.setLocation(650,250);
        jfmeniu.setVisible(false);
        jfmeniu.setResizable(false);
        butonInapoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jfmeniu.setVisible(false);
                Restaurantgui r = new Restaurantgui();
                r.getJFRestaurant().setVisible(true);
            }
        });
        butonM1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jfmeniu.setVisible(false);
                Meniu1 m1 = new Meniu1();
                m1.getJFMeniu1().setVisible(true);
            }
        });
        butonM2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jfmeniu.setVisible(false);
                Meniu2 m2 = new Meniu2();
                m2.getJFMeniu2().setVisible(true);
            }
        });
        butonM3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jfmeniu.setVisible(false);
                Meniu3 m3 = new Meniu3();
                m3.getJFMeniu3().setVisible(true);
            }
        });
        butonM4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jfmeniu.setVisible(false);
                Meniu4 m4 = new Meniu4();
                m4.getJFMeniu4().setVisible(true);
            }
        });
    }
    public JFrame getJFMeniu(){
        return jfmeniu;
    }
}
