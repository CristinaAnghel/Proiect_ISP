package org.example;

import java.awt.desktop.SystemEventListener;

public class Validator {
    public String numeProgram;
    public Student[] totiStudenti;

    Validator(String numeProgram) {
        this.numeProgram=numeProgram;
    }

    public void afisare() {
        System.out.println("Date validator: ");
        System.out.println("Program: " + numeProgram);
    }
}
