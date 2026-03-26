package org.example;

public class Antiplagiat {
    public String numeProgram;
    public float acuratete;
    public LucrareDeLicenta[] toateLucrarile;
    private String pachetUtilizat;

    Antiplagiat(String numeProgram,  float acuratete, String pachetUtilizat) {
        this.numeProgram = numeProgram;
        this.acuratete = acuratete;
        this.pachetUtilizat = pachetUtilizat;


    }

    public void afisare(){
        System.out.println("Date antiplagiat: ");
        System.out.println("Program: " + numeProgram);
        System.out.println("Acuratete: " + acuratete);
    }
}
