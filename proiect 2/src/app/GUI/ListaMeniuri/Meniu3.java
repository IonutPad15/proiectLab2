package app.GUI.ListaMeniuri;

import app.Classes.Meniu;
import app.Classes.Restaurant;
import app.GUI.Meniuri;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Meniu3 {
    private JPanel panelMeniu3;
    private JButton butonInapoi;
    private JLabel labelTitlu;
    private JLabel labelproduse1;
    private  JFrame jFrame;
    private Meniu[] m = Restaurant.meniuri();
    public Meniu3(){
        jFrame = new JFrame("Meniu3" );
        jFrame.setContentPane(panelMeniu3);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setSize(500,380);
        jFrame.setLocation(550,200);
        jFrame.setVisible(false);
        jFrame.setResizable(false);
        labelTitlu.setText(m[2].getNumemeniu());
        String s =  m[2].detaliiMeniu();
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
    public JFrame getJFMeniu3(){
        return this.jFrame;
    }
}
