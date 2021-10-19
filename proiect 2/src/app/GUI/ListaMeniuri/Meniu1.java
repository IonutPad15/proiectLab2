package app.GUI.ListaMeniuri;

import app.GUI.Meniuri;

import app.Classes.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Meniu1 {
    private JLabel labelTitlu;
    private JLabel labelproduse1;
    private JPanel panelMeniu1;
    private JButton butonInapoi;
    private JLabel labelImage;
    private JFrame jFrame;
    private Meniu [] m = Restaurant.meniuri();
    public Meniu1(){
        jFrame = new JFrame("Meniu1" );
        jFrame.setContentPane(panelMeniu1);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setSize(500,350);
        jFrame.setLocation(550,200);
        jFrame.setVisible(false);
        jFrame.setResizable(false);
        labelTitlu.setText(m[0].getNumemeniu());
        String s =  m[0].detaliiMeniu();
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
    public JFrame getJFMeniu1(){
        return this.jFrame;
    }
}
