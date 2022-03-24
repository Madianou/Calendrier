package TestUnit;

import modele.Date;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    @org.junit.jupiter.api.Test
    @DisplayName("Test de dernierJourDuMois")
    void dernierJourDuMois() {
        assertEquals(31, Date.dernierJourDuMois(3,2022)); // Test pour le mois de mars qui compte 31 jours.
        assertEquals(30,Date.dernierJourDuMois(9,2022));// Test pour le mois de septembre qui compte 30 jours.
        assertEquals(28,Date.dernierJourDuMois(2,2022));// Test pour le mois de février qui compte 28 jours en 2022 car l'année n'est pas bissextile
        assertEquals(29,Date.dernierJourDuMois(29,2020));// Test pour le mois de février qui compte 29 jours en 2020 car l'année est bissextile
    }
    @org.junit.jupiter.api.Test
    @DisplayName("Test de compareTo")
    void compareTo() {
        Date date1 = new Date(1,1,2022);
        Date date2 = new Date(31,12,2022);
        Date date3 = new Date(1,1,2023);
        assertEquals(0,date1.compareTo(date1));
        assertEquals(-1,date1.compareTo(date2));
        assertEquals(1,date3.compareTo(date2));
    }
}