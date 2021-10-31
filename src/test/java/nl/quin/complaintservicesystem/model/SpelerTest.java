package nl.quin.complaintservicesystem.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SpelerTest {

    @Test
    void setId() {
        //Arrange
        Speler speler = new Speler();
        //Act
        speler.setNaam("Harry");
        //Assert
        assertEquals("Harry", speler.getNaam());
    }


    @Test
    void getRugnummer() {
    }

    @Test
    void setRugnummer() {
    }

    @Test
    void getNaam() {
    }

    @Test
    void setNaam() {
    }

    @Test
    void getPositie() {
    }

    @Test
    void setPositie() {
    }

    @Test
    void getTeam() {
    }

    @Test
    void setTeam() {
    }
}