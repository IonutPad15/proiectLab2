package app.GUI;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.Classes.*;
public class CreareComanda extends ScriereFisier{
    private JPanel panelComanda;
    private JLabel label1;
    private  JSpinner spinner1;
    private JLabel meniu1;
    private JSpinner spinner2;
    private JLabel label2;
    private  JSpinner spinner3;
    private JLabel label3;
    private JSpinner spinner4;
    private JLabel label4;
    private JLabel label5;
    private  JLabel pretlabel;
    private JLabel label6;
    private JButton butonComanda;
    private JTextField textField1;
    private JButton butonInapoi;
    private JButton butonAnulare;
    private JFrame jFcomanda;
    private static int vals1,vals2,vals3,vals4;
    private static Meniu[] m = Restaurant.meniuri();
    private static double pret ;
    public CreareComanda(){
        super();
        jFcomanda = new JFrame("Creeare comanda" );
        jFcomanda.setContentPane(panelComanda);
        jFcomanda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFcomanda.pack();
        jFcomanda.setSize(350,300);
        jFcomanda.setLocation(650,250);
        jFcomanda.setVisible(false);
        jFcomanda.setResizable(false);
        pretlabel.setText(Integer.toString(0)+" lei");
        pret = 0;
        vals1=vals2=vals3=vals4=0;
        butonInapoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                vals1=vals2=vals3=vals4=0;
                jFcomanda.setVisible(false);
                Restaurantgui r = new Restaurantgui();
                r.getJFRestaurant().setVisible(true);
            }
        });
        butonComanda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int []nrmeniuri =new int[ m.length];
                nrmeniuri[0] = vals1;
                nrmeniuri[1] = vals2;
                nrmeniuri[2] = vals3;
                nrmeniuri[3] = vals4;
                double sumaTransfer ;
                if(textField1.getText().equals("")) {
                    sumaTransfer = 0.0;
                }
                else {
                    sumaTransfer = Double.parseDouble(textField1.getText());
                }
                Chitanta c = new Chitanta(m,nrmeniuri, sumaTransfer);
                String s = c.generareChitanta();
                JOptionPane.showMessageDialog(null, "Comanda creata", "Info", JOptionPane.INFORMATION_MESSAGE);
                if(pret < sumaTransfer) {
                    vals1 = vals2 = vals3 = vals4 = 0;
                    jFcomanda.setVisible(false);
                    Restaurantgui r = new Restaurantgui();
                    r.getJFRestaurant().setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Fonduri insuficiente", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        butonAnulare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                spinner1.setValue(0);
                spinner2.setValue(0);
                spinner3.setValue(0);
                spinner4.setValue(0);
                textField1.setText("");
                //pretlabel.setText(Integer.toString(0)+" lei");
                vals1=vals2=vals3=vals4=0;
            }
        });
        spinner1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                vals1= (int) spinner1.getValue();
                if(vals1<0) {
                    spinner1.setValue(0);
                    vals1=0;
                }
                setPretlabel(pretlabel);
            }
        });
        spinner2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                vals2 = (int) spinner2.getValue();
                if(vals2<0) {
                    spinner2.setValue(0);
                    vals2=0;
                }
                setPretlabel(pretlabel);
            }
        });
        spinner3.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                vals3 = (int) spinner3.getValue();
                if(vals3<0) {
                    spinner3.setValue(0);
                    vals3=0;
                }
                setPretlabel(pretlabel);
            }
        });
        spinner4.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                vals4 = (int) spinner4.getValue();
                if(vals4<0) {
                    spinner4.setValue(0);
                    vals4=0;
                }
                setPretlabel(pretlabel);
            }
        });
    }
    public static void setPretlabel(JLabel pretlabel ){
        pret = 0;
        pret+=vals1*m[0].getPret();
        pret+=vals2*m[1].getPret();
        pret+=vals3*m[2].getPret();
        pret+=vals4*m[3].getPret();
        pretlabel.setText(Double.toString(pret) + " lei");
    }
    public JFrame getJFComanda(){
        return this.jFcomanda;
    }
}
