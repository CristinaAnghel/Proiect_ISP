package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Secretar extends Utilizator{
    public Comisie[] comisiiGestionate;
    public List<LucrareDeLicenta> licente;

    Secretar(String nume, String prenume, String email, String nrTelefon, Comisie[] comisiiGestionate){
        super(nume, prenume, email, nrTelefon);
        this.comisiiGestionate = comisiiGestionate;
        licente = new ArrayList<>();
    }


    public void verificareComisie(){
        System.out.println("Comisiile gestionate: ");
        for(Comisie comisie : comisiiGestionate){
            System.out.println(comisie);
        }
    }


    public void programare(Student student, Comisie comisie, Date data){
        ProgramareSustinere programare = new ProgramareSustinere(comisie, student, data);
        boolean resStud = student.confirmareProgramare(programare);
        System.out.println("Studentul a confirmat? " + resStud);

        for(int i = 0; i < comisie.cadreDidactice.length; i++){
            boolean resCad = comisie.cadreDidactice[i].confirmareProgramare(programare);
            System.out.println("Cadrul didactic " + comisie.cadreDidactice[i].nume + " " + comisie.cadreDidactice[i].prenume + " a confirmat? " + resCad);
        }
    }


    public void incarcareNotaStudent(Student student){
        if(student.licenta.notat){
            student.mediaFinala = (student.mediaAnilor + student.licenta.getNotaLicenta())/2;
        }
        else{
            System.out.println("Licenta nu a fost notata!");
        }
    }


    public void incarcaNotaLicenta(Student student, float notaLicenta){
        if(!student.licenta.notat){
            student.licenta.notat = true;
            student.licenta.setNotaLicenta(notaLicenta);
        }
        else{
            System.out.println("Studentul a fost notat deja!");
        }
    }


    public void adaugaLicenta(LucrareDeLicenta licenta){
        licente.add(licenta);
    }


    public void validareTemaLicenta(Student student){
        for(LucrareDeLicenta licente : licente){
            if(student.licenta.titlu.equals(licente.titlu)){
                student.licenta.setValida(false);
            }
        }

        student.licenta.setValida(true);
    }


    @Override
    public void afisare() {
        System.out.println("Datele secretarului: ");
        super.afisare();
        System.out.println("Comisiile gestionate: ");
        for (int i = 0; i < comisiiGestionate.length; i++) {
            System.out.println(comisiiGestionate[i]);
        }
    }
}
