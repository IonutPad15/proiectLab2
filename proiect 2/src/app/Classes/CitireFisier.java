package app.Classes;

import java.io.*;
import java.math.BigDecimal;
import java.util.Scanner;

public class CitireFisier extends ScriereFisier{
    protected double citireFisierDouble(String numeFisier, String mesaj_succes, String mesaj_eroare){
        Scanner sc = null;
        try {
            sc = new Scanner(new File(numeFisier));
            double d = sc.nextDouble();
            System.out.println(mesaj_succes);
            return d;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(mesaj_eroare);
            return -1;
        }
        catch (Exception ex){
            ex.printStackTrace();
            System.out.println(mesaj_eroare);
            return -1;
        }
    }
    protected String citireFisierString(String numeFisier, String mesaj_succes, String mesaj_eroare){
        Scanner sc = null;
        try {
            sc = new Scanner(new File(numeFisier));
            String s = sc.next();
            System.out.println(mesaj_succes);
            return s;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(mesaj_eroare);
            return "";
        }
        catch (Exception ex){
            ex.printStackTrace();
            System.out.println(mesaj_eroare);
            return "";
        }
    }
}
