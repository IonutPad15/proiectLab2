package app.GUI;

import app.Classes.CitireFisier;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin extends CitireFisier {
    private JTextField textFieldID;
    private JButton butonConectare;
    private JPanel panelAdmin;
    private JPasswordField passwordField1;
    private JButton butonInapoi;
    private  JFrame jFrame;
    public Admin(){
        super();
        jFrame = new JFrame("Admin" );
        jFrame.setContentPane(panelAdmin);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setSize(350,300);
        jFrame.setLocation(600,250);
        jFrame.setVisible(false);
        jFrame.setResizable(false);
        butonInapoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jFrame.setVisible(false);
                Restaurantgui r = new Restaurantgui();
                r.getJFRestaurant().setVisible(true);
            }
        });
        butonConectare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String password =String.valueOf(passwordField1.getPassword());
                String passwordsistem = Admin.super.citireFisierString("Parola.txt","Succes","Eroare");
                String username = textFieldID.getText();
                int result = JOptionPane.showConfirmDialog(null, "Are you sure you want ot login?", "Question", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(result == JOptionPane.YES_OPTION){
                    JOptionPane.showMessageDialog(null, "You have selected to login!", "Result", JOptionPane.INFORMATION_MESSAGE);
                    if(password.equals(passwordsistem) && username.equals("admin"))
                    {
                        jFrame.setVisible(false);
                        AdminLogat al = new AdminLogat();
                        al.getJFAdminLogat().setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Id sau parola inceorecte!", "Result", JOptionPane.ERROR_MESSAGE);
                        jFrame.setVisible(false);
                        Admin a = new Admin();
                        a.getJFAdmin().setVisible(true);
                    }
                }
                else{
                    if(result == JOptionPane.NO_OPTION)
                    {
                        JOptionPane.showMessageDialog(null, "You have selected not to login!", "Result", JOptionPane.WARNING_MESSAGE);
                    }
                    else if(result == JOptionPane.CANCEL_OPTION){
                        JOptionPane.showMessageDialog(null, "You have selected cancel!", "Result", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }
    public JFrame getJFAdmin(){
        return this.jFrame;
    }
}
