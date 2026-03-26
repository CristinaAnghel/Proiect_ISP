package org.example;

import java.util.ArrayList;
import java.util.List;

public class CadruDidactic extends Utilizator{
    public List<Student> studentiCoordonati;
    public ComisieIndrumare titlu;
    public TipCoordonator rang;
    public Comisie comisie;
    public List<ProgramareSustinere> programariActive;

    CadruDidactic(String nume, String prenume, String email, String nrTelefon, ComisieIndrumare titlu, TipCoordonator rang, Comisie comisie){
        super(nume, prenume, email, nrTelefon);
        this.studentiCoordonati = new ArrayList<>();
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


    public void adaugareStudent(Student student){
        studentiCoordonati.add(student);
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
        for (int i = 0; i < studentiCoordonati.size(); i++) {
            System.out.println(studentiCoordonati.get(i).nume + " " + studentiCoordonati.get(i).prenume);
        }
    }

    public void verificareComisie(){
        System.out.println("Comisia de care apartine: ");
        comisie.afisare();
    }
}
