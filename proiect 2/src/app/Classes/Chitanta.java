package app.Classes;

import app.Interfaces.IChitanta;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.StringJoiner;

public class Chitanta extends CitireFisier implements IChitanta {
    private static Meniu [] _meniuri;
    private int[] _nrmeniuri;
    double _total;
    private double _sumatransfer;
    public Chitanta(Meniu [] meniuri, int[] nrmeniuri, double sumatransfer)
    {
        super();
        _total = 0;
        _meniuri = meniuri;
        _nrmeniuri = nrmeniuri;
        _sumatransfer = sumatransfer;
    }
    public String generareChitanta()
    {
        boolean ok = false;
        for(int i=0;i<_nrmeniuri.length;++i){
            if(_nrmeniuri[i]>0) ok = true;
        }
        if(ok ) {
            StringJoiner rez = new StringJoiner("");
            rez.add("         The Forest Man         \n   Str 1.Decembrie 1918, Nr.15  \n");
            rez.add("    Ludus / Oras Ludus/ Mures  \n             VANZARE\n====================================\n");
            rez.add("DATA             ");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            rez.add(dtf.format(now) + "\n");
            _total = 0;
            for (int i = 0; i < 4; ++i) {
                if (_nrmeniuri[i] > 0) {
                    rez.add(_nrmeniuri[i] + "x" + _meniuri[i].getNumemeniu());
                    rez.add("          Pret: " + _nrmeniuri[i] * _meniuri[i].getPret() + " lei\n");
                    _total += _nrmeniuri[i] * _meniuri[i].getPret();
                }
            }
            rez.add("Total de plata:            " + _total + " lei\n");
            rez.add("Suma furnizata:            " + _sumatransfer + " lei\n");
            if (_sumatransfer < _total) {
                rez.add("///////Fonduri Insuficiente/////////\n");
            } else {
                rez.add("Rest:                      " + (_sumatransfer - _total) + " lei\n");
                double sold = super.citireFisierDouble("SoldRestaurant.txt","Citire reusita","Citire esuata");
                sold +=_total;
                super.scriereFisier("SoldRestaurant.txt",sold,"Sold committed","Committing sold failed");
            }
            super.scriereFisier("Chitanta.txt",rez.toString(),"Chitanta a fost tiparita.","Eroare in timpul tiparirii.");
            return rez.toString();
        }
        return "";
    }
    public void setMeniuri(Meniu[] meniuri) {
        _meniuri = meniuri;
    }
    public void setNrmeniuri(int[] nrmeniuri)
    {
        _nrmeniuri = nrmeniuri;
    }
    public void setSumatransfer(double sumatransfer)
    {
        _sumatransfer = sumatransfer;
    }
    public double getSumatransfer(){
        return _sumatransfer;
    }
    public static Meniu[] getMeniuri()
    {
        return _meniuri;
    }
    public int[] getNrmeniuri(){
        return _nrmeniuri;
    }
    public String toString(){
        StringBuffer rez = new StringBuffer("");
        rez.append("Chitanta:\n");
        rez.append("Meniuri:\n");
        for(int i = 0; i < _meniuri.length; ++i) rez.append(_meniuri[i].toString());
        rez.append("NrMeniuri:\n");
        for(int i = 0; i < _meniuri.length; ++i) rez.append(_nrmeniuri[i]);
        rez.append("\nTotal: " + _total+"\nSumaTransfer:" + _sumatransfer + "\n");
        return rez.toString();
    }
}
