package com.mkraskiewicz.petclinic.model;

import com.mkraskiewicz.petclinic.ModelTests;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest implements ModelTests {

    @Test
    void groupedAssertions() {

        //given
        Person person = new Person(1l, "Peter", "Griffin");
        //when
        assertAll("Test Props Set",
                () -> assertEquals(person.getFirstName(), "Peter"),
                () -> assertEquals(person.getLastName(), "Griffin"));
    }


    @Test
    void groupedAssertionsMSG() {

        //given
        Person person = new Person(1l, "Peter", "Griffin");
        //when
        assertAll("Test Props Set",
                () -> assertEquals(person.getFirstName(), "Peter", "First Name Failed"),
                () -> assertEquals(person.getLastName(), "Griffin"));
    }

}