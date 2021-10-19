package app.GUI.ListaMeniuri;

import app.Classes.Meniu;
import app.Classes.Restaurant;
import app.GUI.Meniuri;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Meniu4 {
    private JPanel panelMeniu4;
    private JLabel labelTitlu;
    private JLabel labelproduse1;
    private JButton butonInapoi;
    private  JFrame jFrame;
    private Meniu[] m = Restaurant.meniuri();
    public Meniu4(){
        jFrame = new JFrame("Meniu4" );
        jFrame.setContentPane(panelMeniu4);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setSize(450,350);
        jFrame.setLocation(550,200);
        jFrame.setVisible(false);
        jFrame.setResizable(false);
        labelTitlu.setText(m[3].getNumemeniu());
        String s =  m[3].detaliiMeniu();
        labelproduse1.setText(("<html>" + s.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>"));
        butonInapoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jFrame.setVisible(false);
                Meniuri m = new Meniuri();
                m.getJFMeniu().setVisible(true);
            }
        });
    }
    public JFrame getJFMeniu4(){
        return this.jFrame;
    }
}
