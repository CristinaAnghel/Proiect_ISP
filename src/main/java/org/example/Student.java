package org.example;

public class Student extends Utilizator{
    public String serie, grupa;
    public float mediaAnilor, mediaFinala;
    public LucrareDeLicenta licenta;
    private ProgramareSustinere programarePrezentare;

    Student(String nume, String prenume, String email, String nrTelefon, String serie, String grupa, float mediaAnilor, float mediaFinala){
        super(nume, prenume, email, nrTelefon);
        this.serie = serie;
        this.grupa = grupa;
        this.mediaAnilor = mediaAnilor;
        this.mediaFinala = mediaFinala;
        licenta = null;
        programarePrezentare = null;
    }

    public void adaugaProgramare(ProgramareSustinere programare){
        programarePrezentare = programare;
    }

    public void verificareComisie(){
        if(programarePrezentare != null) {
            System.out.println("Comisia la care va prezenta " + nume + " " + prenume + " este: ");
            programarePrezentare.comisie.afisare();
        }
        else{
            System.out.println("Studentul nu este programat!");
        }

    }


    public boolean confirmareProgramare(ProgramareSustinere programareSustinere){
        if(programarePrezentare != null){
            adaugaProgramare(programarePrezentare);
            return true;
        }

        return false;
    }


    public void incarcareLicenta(String titlu, CadruDidactic[] coordonatori){
        this.licenta = new  LucrareDeLicenta(titlu, coordonatori);
    }


    @Override
    public void afisare() {
        System.out.println("Datele studentului: ");
        super.afisare();
        System.out.println("Serie: " + serie);
        System.out.println("Grupa: " + grupa);
        System.out.println("MediaAnilor: " + mediaAnilor);
        System.out.println("MediaFinala: " + mediaFinala);
        System.out.println("Licenta: " + licenta.titlu);
    }
}
