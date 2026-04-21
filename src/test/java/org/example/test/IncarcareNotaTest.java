package org.example.test;

import org.example.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IncarcareNotaTest {
    private Student student;
    private Secretar secretar;
    private Comisie comisie;
    private Validator validator;

    @BeforeEach
    void setup(){
        secretar = new Secretar("Popescu", "Ion", "ion@secretariat.ro", "0753837541", new Comisie[0]);
        comisie = new Comisie(1, secretar, new CadruDidactic[0]);
        validator = new Validator("ValidatorSistem");
    }

    @Test
    // Student admis cu note peste medie
    void testIncarcareNota1() {
        Student student = new Student("Munteanu", "Ioana", "mnt@stud.ro", "073346753", "AA", "332", 8.50f);
        student.incarcareLicenta("Proiect A", new CadruDidactic[0]);

        comisie.stabilireNota(student, 8.50f);
        secretar.incarcareNotaStudent(student);
        validator.validareNota(student);

        assertEquals(8.50f, student.mediaFinala, 0.01);
        assertTrue(student.mediaFinala >= 5, "Studentul ar trebui sa fie admis.");
    }


    @Test
    // Note maxime (10.00)
    void testIncarcareNota2() {
        Student student = new Student("Munteanu", "Ioana", "mnt@stud.ro", "073346753", "AA", "332", 10.00f);
        student.incarcareLicenta("Proiect B", new CadruDidactic[0]);

        comisie.stabilireNota(student, 10.00f);
        secretar.incarcareNotaStudent(student);

        assertEquals(10.00f, student.mediaFinala, 0.01);
        assertTrue(student.mediaFinala >= 5);
    }

    @Test
    // Media finala 5.00
    void testIncarcareNota3() {
        Student student = new Student("Munteanu", "Ioana", "mnt@stud.ro", "073346753", "AA", "332", 5.00f);
        student.incarcareLicenta("Proiect C", new CadruDidactic[0]);

        comisie.stabilireNota(student, 5.00f);
        secretar.incarcareNotaStudent(student);

        assertEquals(5.00f, student.mediaFinala, 0.01);
        assertTrue(student.mediaFinala >= 5, "Media de 5.00 trebuie sa fie de trecere.");
    }


    @Test
    // Media finala sub 5.00
    void testIncarcareNota4() {
        Student student = new Student("Munteanu", "Ioana", "mnt@stud.ro", "073346753", "AA", "332", 5.00f);
        student.incarcareLicenta("Proiect D", new CadruDidactic[0]);

        comisie.stabilireNota(student, 4.00f);
        secretar.incarcareNotaStudent(student);

        assertEquals(4.50f, student.mediaFinala, 0.01);
        assertFalse(student.mediaFinala >= 5, "Media sub 5.00 trebuie sa fie respinsa.");
    }


    @Test
    // Incercare recalculare medie pentru student deja notat
    void testIncarcareNota5() {
        Student student = new Student("Munteanu", "Ioana", "mnt@stud.ro", "073346753", "AA", "332", 8.00f);
        student.incarcareLicenta("Proiect E", new CadruDidactic[0]);

        comisie.stabilireNota(student, 8.00f);
        secretar.incarcareNotaStudent(student);

        // Incercare recalculare medie
        secretar.incarcaNotaLicenta(student, 10.00f);

        // Verificam ca nota a ramas cea initială (8.00), nu s-a suprascris cu 10.00
        assertEquals(8.00f, student.licenta.getNotaLicenta(), "Nota nu ar trebui sa poata fi modificata daca studentul a fost deja notat.");
    }


    @Test
    // Verificari notare licenta
    void testIncarcareNota6(){
        Student student = new Student("Munteanu", "Ioana", "mnt@stud.ro", "073346753", "AA", "332", 8.50f);
        student.incarcareLicenta("Proiect F", new CadruDidactic[0]);

        float notaAcordata = 8.50f;
        comisie.stabilireNota(student, notaAcordata);

        assertTrue(student.licenta.notat, "Licenta ar trebui sa fie marcata ca notata.");
        assertEquals(notaAcordata, student.licenta.getNotaLicenta(), "Nota licentei nu corespunde.");

        secretar.incarcareNotaStudent(student);

        float mediaAsteptata = 8.50f;
        assertEquals(mediaAsteptata, student.mediaFinala, 0.01, "Media finala nu a fost calculata corect.");

        validator.validareNota(student);
        assertTrue(student.mediaFinala >= 5, "Studentul ar trebui sa fie admis conform mediei.");
    }
}
