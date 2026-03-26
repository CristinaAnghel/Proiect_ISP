package org.example;

import javax.sound.midi.SysexMessage;

public class LucrareDeLicenta {
    public String titlu;
    public CadruDidactic[] coordonatori;
    public Scor scorAntiplagiat;
    private float notaLicenta;
    public boolean notat;
    private boolean valida;

    LucrareDeLicenta(String titlu, CadruDidactic[] coordonatori) {
        this.titlu = titlu;
        this.coordonatori = coordonatori;
        this.scorAntiplagiat = null;
        notaLicenta = 0;
        notat = false;
    }

    public void afisare(){
        System.out.println("Date lucrare de licenta: ");
        System.out.println("Titlu: " + titlu);
        System.out.println("Coordonatori: ");
        for (int i = 0; i < coordonatori.length; i++) {
            System.out.println(coordonatori[i].nume + " " + coordonatori[i].prenume + " " + coordonatori[i].titlu);
        }

        System.out.println("Scor antiplagiat: " + scorAntiplagiat);
        System.out.println("Nota: " + notaLicenta);
    }

    public void vizualizareNota(){
        if(notat){
            System.out.println("Nota licentei este: " + notaLicenta);
        }
        else{
            System.out.println("Licenta nu a fost notata");
        }
    }

    public float getNotaLicenta() {
        return notaLicenta;
    }

    public void setNotaLicenta(float notaLicenta) {
        this.notaLicenta = notaLicenta;
    }

    public boolean getValida() {
        return valida;
    }

    public void setValida(boolean valida) {
        this.valida = valida;
    }
}
