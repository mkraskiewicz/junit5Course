package com.mkraskiewicz.petclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

    IndexController controller;

    @BeforeEach
    void setUp() {

        controller = new IndexController();
    }

    @DisplayName("test Proper View name is returned for index page")
    @Test
    void index() {

        assertEquals("index", controller.index(), () -> "Expensive message" +
                "Make me only if you have to");
    }

    @Test
    void oupsHandler() {


        assertThrows(ValueNotFoundException.class, () -> {
           controller.oupsHandler();
        });
    }
}