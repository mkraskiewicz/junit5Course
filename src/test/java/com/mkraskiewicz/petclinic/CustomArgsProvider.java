package com.mkraskiewicz.petclinic;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class CustomArgsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return  Stream.of(
                Arguments.of("EL",11,11),
                Arguments.of("WZ",22,22),
                Arguments.of("EZG",33,33));
    }
}
