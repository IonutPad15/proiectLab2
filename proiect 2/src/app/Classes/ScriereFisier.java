package app.Classes;

import java.io.FileWriter;
import java.io.IOException;

public class ScriereFisier {
    protected void scriereFisier(String numeFisier, String text, String mesaj_succes, String mesaj_eroare){
        try {
            FileWriter myWriter = new FileWriter(numeFisier);
            myWriter.write(text);
            myWriter.close();
            System.out.println(mesaj_succes);
        } catch (IOException e) {
            System.out.println(mesaj_eroare);
            e.printStackTrace();
        }
    }
    protected void scriereFisier(String numeFisier,double val, String mesaj_succes, String mesaj_eroare){
        try {
            FileWriter myWriter = new FileWriter(numeFisier);
            myWriter.write(Double.toString(val));
            myWriter.close();
            System.out.println(mesaj_succes);
        } catch (IOException e) {
            System.out.println(mesaj_eroare);
            e.printStackTrace();
        }
    }
}
