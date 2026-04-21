package org.example.test;

import org.example.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class Programare {
    private Secretar secretar;
    private Student student;
    private Comisie comisie;
    private CadruDidactic p1, p2;
    private Date dataTest;

    @BeforeEach
    void setup(){
        secretar = new Secretar("Boboc", "Elena", "elena@sec.ro", "072209676", new Comisie[0]);
        p1 = new CadruDidactic("Ionescu", "Dan", "dan@u.ro", "074356121", ComisieIndrumare.CoordonatorStiintific, TipCoordonator.Profesor, null);
        p2 = new CadruDidactic("Popa", "Amalia", "popa@u.ro", "075908634", ComisieIndrumare.CoordonatorStiintific, TipCoordonator.Conferentiar, null);

        CadruDidactic[] membrii = {p1, p2};

        comisie = new Comisie(3, secretar, membrii);
        student = new Student("Anghel", "Cristina", "anghel@stud.ro", "074324863", "AA", "332", 9.0f);
        dataTest = new Date();
    }

    @Test
    // Toata lumea confirma
    void testCreareProgramare1() {
        ProgramareSustinere pg = secretar.programare(student, comisie, dataTest);

        assertNotNull(pg);

        assertTrue(student.confirmareProgramare(pg) == false,
                "Daca programarea s-a facut deja in metoda secretar.programare, a doua confirmare ar trebui sa fie false.");

        for (CadruDidactic cd : comisie.cadreDidactice) {
            assertTrue(cd.programariActive.contains(pg), "Profesorul " + cd.nume + " trebuia să confirme.");
        }
    }


    @Test
    // Studentul are deja alta programare
    void testCreareProgramare2() {
        // Prima programare ocupa slotul studentului
        secretar.programare(student, comisie, dataTest);

        ProgramareSustinere pg2 = new ProgramareSustinere(comisie, student, dataTest);
        boolean aConfirmat = student.confirmareProgramare(pg2);

        assertFalse(aConfirmat, "Studentul nu ar fi trebuit sa poata confirma a doua oara.");
    }


    @Test
    // Un profesor din comisie este ocupat
    void testCreareProgramare3(){
        secretar.programare(student, comisie, dataTest);

        // o sa fie false deoarece profesorul are deja o programare in acea zi
        boolean aDouaConfirmare = p1.confirmareProgramare(new ProgramareSustinere(comisie, student, dataTest));

        assertFalse(aDouaConfirmare, "Programarea ar trebui sa esueze daca profesorul are deja ceva in acel interval.");
    }
}
