package app.GUI.ListaMeniuri;

import app.Classes.Meniu;
import app.Classes.Restaurant;
import app.GUI.Meniuri;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Meniu2 {
    private JLabel labelTitlu;
    private JPanel panelProduse;
    private JPanel panelMeniu2;
    private JButton butonInapoi;
    private JLabel labelproduse1;
    private JFrame jFrame;
    private Meniu[] m = Restaurant.meniuri();
    public Meniu2(){
        jFrame = new JFrame("Meniu2" );
        jFrame.setContentPane(panelMeniu2);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setSize(500,350);
        jFrame.setLocation(550,200);
        jFrame.setVisible(false);
        jFrame.setResizable(false);
        labelTitlu.setText(m[1].getNumemeniu());
        String s =  m[1].detaliiMeniu();
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
    public JFrame getJFMeniu2(){
        return this.jFrame;
    }
}
