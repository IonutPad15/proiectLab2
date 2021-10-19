package app.Classes;

import app.Interfaces.ISchimbareParola;

public class SchimbareParola extends CitireFisier implements ISchimbareParola{
    public void schimbareParola( String parolaNoua){
        super.scriereFisier("Parola.txt",parolaNoua,"Parola schimbata","Nu s-a putut schimba parola");
    }
}
