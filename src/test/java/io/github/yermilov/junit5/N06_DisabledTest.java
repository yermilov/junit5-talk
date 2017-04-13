package io.github.yermilov.junit5;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.github.yermilov.junit5.PlanetSystem.SOLAR_SYSTEM;
import static org.junit.jupiter.api.Assertions.assertEquals;

class N06_DisabledTest {

    @Test
    @Disabled("Saturn is not supported in version 5")
    @DisplayName("Saturn is the Sixth planet in the Solar System")
    void saturnIsFifthPlanet() {
        assertEquals("Saturn", SOLAR_SYSTEM.getPlanetByIndex(6).getName());
    }
}
