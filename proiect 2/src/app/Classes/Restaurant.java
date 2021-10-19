package app.Classes;

import java.util.Scanner;
import java.util.StringJoiner;

public class Restaurant {
    private Meniu [] meniuri;
    public static Meniu [] meniuri(){
        Meniu[] meniuri = new Meniu[4];
        //meniu maxi
        Produs[] produse1 = new Produs[3];
        produse1[0] = new Produs("Coca Cola",500,"ml",1);
        produse1[1] = new Produs("Burger Maxi King", 350, "g",1);
        produse1[2] = new Produs("Cartofi prajiti",250,"g",1);
        meniuri[0]= new Meniu(produse1,"Meniu Maxi",16.5,3);
        //meniu hot wings
        Produs[] produse2 = new Produs[3];
        produse2[0] = new Produs("Aripioare picante", 350, "g", 6);
        produse2[1] = new Produs("Cartofi prajiti", 250, "g", 1);
        produse2[2] = new Produs("Ketchup picant",50, "ml",1);
        meniuri[1] = new Meniu(produse2, "Hot wings ",14.5,3);
        //meniu mcchicken
        Produs[] produse3 = new Produs[3];
        produse3[0] = new Produs("Coca Cola", 500, "ml", 1);
        produse3[1] = new Produs("Cartofi prajiti", 250, "g", 1);
        produse3[2] = new Produs("Burger cu pui",250, "g",1);
        meniuri[2] = new Meniu(produse3, "McChicken ",13.5,3);
        //omleta campionilor
        Produs[] produse4 = new Produs[5];
        produse4[0] = new Produs("Oua", 35, "g", 3);
        produse4[1] = new Produs("Sunca", 250, "g", 1);
        produse4[2] = new Produs("Rosii",50, "g",1);
        produse4[3] = new Produs("Ardei",30, "g",1);
        produse4[4] = new Produs("Ardei picanti",30, "g",1);
        meniuri[3] = new Meniu(produse4, "Omleta    ",14.5,3);
        return meniuri;
    }

}
