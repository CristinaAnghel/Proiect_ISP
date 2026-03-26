package org.example;


import javax.swing.plaf.synth.SynthTextAreaUI;

abstract class Utilizator {
    public String nume, prenume, email, nrTelefon;
    protected int idCont;

    Utilizator(String nume, String prenume, String email, String nrTelefon) {
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.nrTelefon = nrTelefon;

    }

    public void creareCont()   {
        System.out.println("Am creat un cont!");
    }

    abstract void verificareComisie();

    public void vizualizareNota(Student student){
        System.out.println("Media finala a studentului " + student.nume + " " + student.prenume + "este " + student.mediaFinala);
    }

    public void afisare(){
        System.out.println("Nume: " + nume);
        System.out.println("Prenume: " + prenume);
        System.out.println("Email: " + email);
        System.out.println("NrTelefon: " + nrTelefon);
        System.out.println("IdCont: " + idCont);
    }
}
