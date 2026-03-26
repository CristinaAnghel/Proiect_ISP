package org.example;

public class Comisie {
    public CadruDidactic[] cadreDidactice;
    public int identificator;
    public Secretar secretar;

    Comisie(int identificator, Secretar secretar, CadruDidactic[] cadreDidactice){
        this.identificator = identificator;
        this.secretar = secretar;
        this.cadreDidactice = cadreDidactice;
    }

    public void afisare(){
        System.out.println("Date comisie: ");
        System.out.println("Identificator: " + identificator);
        System.out.println("Secretar: " + secretar.nume + " " + secretar.prenume);
        System.out.println("Cadre didactice: ");
        for (int i = 0; i < cadreDidactice.length; i++) {
            System.out.println(cadreDidactice[i].nume + " " + cadreDidactice[i].prenume);
        }
    }
}
