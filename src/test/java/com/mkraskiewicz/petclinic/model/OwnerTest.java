package com.mkraskiewicz.petclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {

        @Test
        void dependentAssertions() {

            Owner owner = new Owner(1l, "Peter", "Griffin");
            owner.setCity("Warsaw");
            owner.setTelephone("123456789");

            assertAll("Properties Test",
                    () -> assertAll("Person Properties",
                        () -> assertEquals("Joe", owner.getFirstName(), "First name did not Match"),
                        () -> assertEquals("Griffin", owner.getLastName())),
                    () -> assertAll("Owner Properties",
                        () -> assertEquals("Warsaw", owner.getCity()),
                        () -> assertEquals("123456789", owner.getTelephone())
                    ));
        }
}