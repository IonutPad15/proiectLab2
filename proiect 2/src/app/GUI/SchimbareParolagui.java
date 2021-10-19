package app.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import app.Classes.SchimbareParola;
public class SchimbareParolagui extends SchimbareParola{
    private JPasswordField passField;
    private JPasswordField oldPass;
    private JPasswordField confirmPassField;
    private JButton butonSP;
    private JPanel panelSP;
    private JButton butonInapoi;
    private JFrame jFrame;
    public SchimbareParolagui(){
        jFrame = new JFrame("Admin");
        jFrame.setContentPane(panelSP);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setSize(180, 300);
        jFrame.setLocation(700, 250);
        jFrame.setVisible(false);
        jFrame.setResizable(false);
        butonInapoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jFrame.setVisible(false);
                AdminLogat al = new AdminLogat();
                al.getJFAdminLogat().setVisible(true);
            }
        });
        butonSP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int result = JOptionPane.showConfirmDialog(null,"Sunteti sigur ca doriti sa schimbati parola?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                String parolaVeche = String.valueOf(oldPass.getPassword());
                String parolan = String.valueOf(passField.getPassword());
                String parolanconf = String.valueOf(confirmPassField.getPassword());
                if(result == JOptionPane.YES_OPTION) {
                    if((!parolaVeche.equals(""))&&(!parolan.equals(""))&&(!parolanconf.equals(""))) {
                        String passSys = SchimbareParolagui.super.citireFisierString("Parola.txt", "Succes", "Eroare");
                        if (parolaVeche.equals(passSys)) {
                            if (parolan.equals(parolanconf)) {
                                SchimbareParolagui.super.schimbareParola(parolan);
                                JOptionPane.showMessageDialog(null, "Parola Schimbata", "Info", JOptionPane.INFORMATION_MESSAGE);
                                oldPass.setText("");
                                passField.setText("");
                                confirmPassField.setText("");
                            } else {
                                JOptionPane.showMessageDialog(null, "Parolele nu coincid!", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Parola veche incorecta", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Completati toate campurile!","Error",JOptionPane.ERROR_MESSAGE);
                    }
                }
                else
                {
                    oldPass.setText("");
                    passField.setText("");
                    confirmPassField.setText("");
                }
            }
        });
    }
    public JFrame getJFSP(){
        return this.jFrame;
    }
}
