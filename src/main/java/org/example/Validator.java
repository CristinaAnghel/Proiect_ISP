package org.example;

public class Validator {
    public String numeProgram;

    Validator(String numeProgram) {
        this.numeProgram=numeProgram;
    }


    public void validareNota(Student student) {
        if(student.mediaFinala < 5 && student.mediaFinala != -1) {
            System.out.println("Studentul " + student.nume + " " + student.prenume + " este picat");
        }
        else if(student.mediaFinala > 5 && student.mediaFinala != -1) {
            System.out.println("Studentul " + student.nume + " " + student.prenume + " este promovat");
        }
    }


    public void afisare() {
        System.out.println("Date validator: ");
        System.out.println("Program: " + numeProgram);
    }
}
