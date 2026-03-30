package org.example;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        System.out.println("INITIALIZARE");

        // Creare profesori
        CadruDidactic prof1 = new CadruDidactic("Ionescu", "Andrei", "andrei.ionescu@upb.ro", "0753837541",
                ComisieIndrumare.CoordonatorStiintific, TipCoordonator.Profesor, null);
        CadruDidactic prof2 = new CadruDidactic("Popescu", "Elena", "elena.popescu@upb.ro", "0727369787",
                ComisieIndrumare.Consultant, TipCoordonator.Conferentiar, null);

        CadruDidactic[] membriiComisie = {prof1, prof2};

        // Creare secretar si comisie
        Secretar secretar = new Secretar("Georgescu", "Maria", "maria.g@secretariat.ro", "0712345678", new Comisie[0]);
        Comisie comisie1 = new Comisie(101, secretar, membriiComisie);

        prof1.comisie = comisie1;
        prof2.comisie = comisie1;
        secretar.comisiiGestionate = new Comisie[]{comisie1};

        // Creare student
        Student student = new Student("Anghel", "Cristina", "cristina.anghel@stud.ro", "0755123456", "AA", "332", 9.10f);

        System.out.println("\n INCARCARE VALIDARE LICENTA");

        // Studentul creeaza licenta
        student.incarcareLicenta("Sistem de Management al Lucrarilor de Licenta", membriiComisie);
        secretar.adaugaLicenta(student.licenta);

        // Verificare antiplagiat
        Antiplagiat softAntiplagiat = new Antiplagiat("Moss", 0.98f, "Standard");
        softAntiplagiat.verificare(student.licenta);

        // Validare tema de catre secretar
        secretar.validareTemaLicenta(student);
        System.out.println("Licenta validata: " + student.licenta.getValida());
        student.licenta.afisare();

        System.out.println("\n PROGRAMARE SUSTINERE");

        // Secretarul programeaza sustinerea
        Date dataSustinere = new Date(System.currentTimeMillis());
        ProgramareSustinere prog = secretar.programare(student, comisie1, dataSustinere);
        student.adaugaProgramare(prog);
        for(int i = 0; i < membriiComisie.length; i++){
            membriiComisie[i].adaugaProgramare(prog);
        }

        student.verificareComisie();

        System.out.println("\n NOTARE");

        // Comisia stabileste nota
        float notaAcordata = 9.50f;
        comisie1.stabilireNota(student, notaAcordata);

        // Secretarul calculeaza media finala
        secretar.incarcareNotaStudent(student);

        student.afisare();

        // Validatorul verifica daca studentul a promovat
        Validator validatorSistem = new Validator("Validator-Licenta");
        validatorSistem.validareNota(student);

    }
}