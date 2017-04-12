package io.github.yermilov.junit5;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class N05_DisabledTest {

    @Test
    @Disabled("Saturn is not supported in version 5")
    @DisplayName("Saturn is the Sixth planet in the Solar System")
    public void saturnIsFifthPlanet() {
        assertEquals("Saturn", Planet.getByIndex(6).getName());
    }
}
