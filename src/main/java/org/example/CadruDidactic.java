package org.example;

import java.util.ArrayList;
import java.util.List;

public class CadruDidactic extends Utilizator{
    public Student[] studentiCoordonati;
    public ComisieIndrumare titlu;
    public TipCoordonator rang;
    public Comisie comisie;
    public List<ProgramareSustinere> programariActive;

    CadruDidactic(String nume, String prenume, String email, String nrTelefon, ComisieIndrumare titlu, TipCoordonator rang, Comisie comisie, Student[] studentiCoordonati){
        super(nume, prenume, email, nrTelefon);
        this.studentiCoordonati = studentiCoordonati;
        this.titlu = titlu;
        if(titlu.equals(ComisieIndrumare.CoordonatorStiintific)) {
            this.rang = rang;
        }
        else{
            this.rang = null;
        }
        this.comisie = comisie;
        programariActive = new ArrayList<ProgramareSustinere>();
    }


    public void adaugaProgramare(ProgramareSustinere programare){
        programariActive.add(programare);
    }


    public boolean confirmareProgramare(ProgramareSustinere programareSustinere){
        for(int i = 0; i < programariActive.size(); i++){
            if(programareSustinere.dataSustinerii == programariActive.get(i).dataSustinerii) {
                return false;
            }
        }

        adaugaProgramare(programareSustinere);
        return true;
    }


    @Override
    public void afisare() {
        System.out.println("Datele cadrului didactic");
        super.afisare();
        System.out.println("ComisieIndrumare: " + titlu);
        System.out.println("Tip coordonator: " + rang);
        System.out.println("Comisie: " + comisie.identificator);
        System.out.println("Studenti coordonati: ");
        for (int i = 0; i < studentiCoordonati.length; i++) {
            System.out.println(studentiCoordonati[i].nume + " " + studentiCoordonati[i].prenume);
        }
    }

    public void verificareComisie(){
        System.out.println("Comisia de care apartine: ");
        comisie.afisare();
    }
}
