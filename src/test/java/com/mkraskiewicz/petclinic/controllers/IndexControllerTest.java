package com.mkraskiewicz.petclinic.controllers;

import com.mkraskiewicz.petclinic.ControllerTests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;



class IndexControllerTest implements ControllerTests {

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
       assertThat(controller.index()).isEqualTo("index");
    }

    @Test
    void oupsHandler() {


        assertThrows(ValueNotFoundException.class, () -> {
           controller.oupsHandler();
        });
    }

    @Disabled("Demo of timeout")
    @Test
    void testTimeOut() {

        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);
            System.out.println("I got here");
        });


    }

    @Disabled("Demo of timeout")
    @Test
    void testTimeOutPrempt() {

        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);
            System.out.println("I got here Prempt");
        });
    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testMeOnWindows(){}

    @EnabledOnOs(OS.MAC)
    @Test
    void testMeOnMac(){}

    @EnabledOnJre(JRE.JAVA_8)
    @Test
    void testMeOnJava8(){ }

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    void testMeOnJava11(){}

}