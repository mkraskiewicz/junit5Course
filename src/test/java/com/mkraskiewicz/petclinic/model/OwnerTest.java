package com.mkraskiewicz.petclinic.model;

import com.mkraskiewicz.petclinic.CustomArgsProvider;
import com.mkraskiewicz.petclinic.ModelTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OwnerTest implements ModelTests {

        @Test
        void dependentAssertions() {

            Owner owner = new Owner(1l, "Peter", "Griffin");
            owner.setCity("Warsaw");
            owner.setTelephone("123456789");

            assertAll("Properties Test",
                    () -> assertAll("Person Properties",
                        () -> assertEquals("Peter", owner.getFirstName(), "First name did not Match"),
                        () -> assertEquals("Griffin", owner.getLastName())),
                    () -> assertAll("Owner Properties",
                        () -> assertEquals("Warsaw", owner.getCity()),
                        () -> assertEquals("123456789", owner.getTelephone())
                    ));
        }

        @DisplayName("Value Source Test ")
        @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
        @ValueSource(strings = {"Spring", "Course", "mkraskiewicz"})
        void testValueSources(String val) {

            System.out.println(val);
        }

        @DisplayName("Enum Source Test ")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @EnumSource(OwnerType.class)
    void enumTest(OwnerType ownerType) {

        System.out.println(ownerType);
    }

    @DisplayName("CSV Input Test ")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvSource({
            "EL, 1, 1",
            "WZ, 2, 2",
            "EZG, 3, 3"
    })
    void csvInputTest(String cityName, int val1, int val2) {

        System.out.println(cityName + " = " + val1 + ":" + val2);
    }

    @DisplayName("CSV From File Test ")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvFileSource(resources = "/input.csv", numLinesToSkip = 1)
    void csvFromFileTest(String cityName, int val1, int val2) {

        System.out.println(cityName + " = " + val1 + ":" + val2);
    }

    @DisplayName("Method Provider Test ")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @MethodSource("getArgs")
    void fromMethodTest(String cityName, int val1, int val2) {

        System.out.println(cityName + " = " + val1 + ":" + val2);
    }

    static Stream<Arguments> getArgs() {

            return Stream.of(
                    Arguments.of("EL",1,1),
                    Arguments.of("WZ",2,2),
                    Arguments.of("EZG",3,3));
    }

    @DisplayName("Custom Provider Test ")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ArgumentsSource(CustomArgsProvider.class)
    void fromCustomProviderTest(String cityName, int val1, int val2) {

        System.out.println(cityName + " = " + val1 + ":" + val2);
    }
}