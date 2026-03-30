package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Antiplagiat {
    public String numeProgram;
    public float acuratete;
    private String pachetUtilizat;


    Antiplagiat(String numeProgram,  float acuratete, String pachetUtilizat) {
        this.numeProgram = numeProgram;
        this.acuratete = acuratete;
        this.pachetUtilizat = pachetUtilizat;
    }

    public void verificare(LucrareDeLicenta licenta) {
        Random randomNumber = new Random();
        int scor = randomNumber.nextInt(100);
        if(scor < 30){
            licenta.scorAntiplagiat = Scor.Scazut;
        }
        else if(scor > 30 && scor < 70){
            licenta.scorAntiplagiat = Scor.Mediu;
        }
        else if(scor > 70){
            licenta.scorAntiplagiat = Scor.Avansat;
        }
    }


    public void afisare(){
        System.out.println("Date antiplagiat: ");
        System.out.println("Program: " + numeProgram);
        System.out.println("Acuratete: " + acuratete);
    }
}
