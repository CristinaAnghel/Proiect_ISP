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

    public void afisare(){
        System.out.println("Date programare sustinere: ");
        System.out.println("Comisie: " + comisie.identificator);
        System.out.println("Student: " + student.nume + " " + student.prenume);
        System.out.println("Data de sustinere: " + dataSustinerii.toString());
    }
}
