package app.Classes;

import app.Interfaces.IMeniu;

public class Meniu implements IMeniu {
    private String _numemeniu;
    private double _pret;
    private int _nrproduse;
    private Produs[] _produse;
    public Meniu(Produs[] produse, String numemeniu, double pret, int nrproduse) {
        _produse =produse;
        _numemeniu = numemeniu;
        _pret = pret;
        _nrproduse = nrproduse;
    }
    public String getNumemeniu() {
        return _numemeniu;
    }
    public void setNumemeniu(String _numemeniu) {
        this._numemeniu = _numemeniu;
    }
    public double getPret() {
        return _pret;
    }
    public void setPret(double pret) {
        _pret = pret;
    }
    public int getNrproduse() {
        return _nrproduse;
    }

    public void setNrproduse(int nrproduse) {
        _nrproduse = nrproduse;
    }

    public Produs[] getProduse() {
        return _produse;
    }

    public void setProduse(Produs[] _produse) {
        this._produse = _produse;
    }
    public String detaliiMeniu()
    {

        StringBuffer rez =new StringBuffer("");
        rez.append("Meniul " + _numemeniu + " contine:\n");
        for(int i = 0; i < _nrproduse; ++i)
        {
            rez.append(_produse[i].getNrprod() + "x" + _produse[i].getNumeProdus() + " " + _produse[i].getGramaj() + " " );
            rez.append(_produse[i].getUnitatemasura() + "\n");
        }
        rez.append( "Pret: " + getPret() + " lei");
        String s = rez.toString();
        return s;
    }
    public String toString()
    {
        StringBuffer rez = new StringBuffer("");
         rez.append("Meniul " + getNumemeniu() + " contine:\n");
        for(int i = 0; i < _nrproduse; ++i)
        {
            rez.append(_produse[i].toString() + "\n");
        }
        rez.append( "Pret: " + getPret() +" lei");
        return rez.toString();
    }
}
