package org.example;

import java.util.Date;

public class ProgramareSustinere {
    public Comisie comisie;
    public Student student;
    public Date dataSustinerii;

    ProgramareSustinere(Comisie comisie, Student student, Date dataSustinerii) {
        this.comisie = comisie;
        this.student = student;
        this.dataSustinerii = dataSustinerii;
    }


    public void confirmareSustinere(){
        System.out.println("S-a sustinut prezentarea temei de licenta cu comisia " + comisie.identificator + " si studentul " + student.nume + " " + student.prenume + " la data de " + dataSustinerii.toString());
    }


    public void stabilireNota(float notaLicenta){
        comisie.stabilireNota(student, notaLicenta);
    }


    public void afisare(){
        System.out.println("Date programare sustinere: ");
        System.out.println("Comisie: " + comisie.identificator);
        System.out.println("Student: " + student.nume + " " + student.prenume);
        System.out.println("Data de sustinere: " + dataSustinerii.toString());
    }
}
