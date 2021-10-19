package app.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import app.Classes.CitireFisier;

public class AdminLogat extends CitireFisier{
    private JFrame jFrame;
    private JPanel panelAdminLogat;
    private JButton butonInapoi;
    private JLabel labelSold;
    private JTextField textFRetragere;
    private JButton butonRetragere;
    private JButton butonSP;
    private double sold;
    public AdminLogat() {
        jFrame = new JFrame("Admin");
        jFrame.setContentPane(panelAdminLogat);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setSize(350, 300);
        jFrame.setLocation(600, 250);
        jFrame.setVisible(false);
        jFrame.setResizable(false);
        //butonSP.setSize(20,20);
        butonInapoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jFrame.setVisible(false);
                Restaurantgui r = new Restaurantgui();
                r.getJFRestaurant().setVisible(true);
            }
        });
        butonSP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jFrame.setVisible(false);
                SchimbareParolagui sp = new SchimbareParolagui();
                sp.getJFSP().setVisible(true);
            }
        });
        sold = super.citireFisierDouble("SoldRestaurant.txt","Citire reusita","Citire esuata");
        System.out.println(sold);
        labelSold.setText(Double.toString(sold) + " lei");
        butonRetragere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                double sumaretragere;
                if(textFRetragere.getText().equals("") ) {
                    sumaretragere = 0.0;
                }
                else sumaretragere = Double.parseDouble(textFRetragere.getText());
                int result = JOptionPane.showConfirmDialog(null, "Sunteti sigur ca doriti sa retrageti " + sumaretragere + " lei din contul magazinului?", "Question", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(result==JOptionPane.YES_OPTION)
                {
                    if(sumaretragere > sold)
                    {
                        JOptionPane.showMessageDialog(null,"NU PUTETI RETRAGE ACEASTA SUMA!","Eroare",JOptionPane.ERROR_MESSAGE);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Suma retrasa","Succes",JOptionPane.INFORMATION_MESSAGE);
                        sold = sold - sumaretragere;
                        labelSold.setText(sold + " lei");
                        AdminLogat.super.scriereFisier("SoldRestaurant.txt",sold,"Sold committed","Committing sold failed");
                    }
                }
                textFRetragere.setText("");
            }
        });

    }
    public JFrame getJFAdminLogat(){
        return this.jFrame;
    }
}
