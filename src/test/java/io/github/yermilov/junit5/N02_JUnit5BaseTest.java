package io.github.yermilov.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.github.yermilov.junit5.PlanetSystem.SOLAR_SYSTEM;
import static org.junit.jupiter.api.Assertions.assertEquals;

class N02_JUnit5BaseTest {

    @Test
    void jupiter_is_fifth_planet() {
        assertEquals("Jupiter", SOLAR_SYSTEM.getPlanetByIndex(5).getName());
    }

    @Test
    @DisplayName("Jupiter is the Fifth planet in the Solar System")
    void jupiterIsFifthPlanet() {
        assertEquals("Jupiter", SOLAR_SYSTEM.getPlanetByIndex(5).getName());
    }
}
