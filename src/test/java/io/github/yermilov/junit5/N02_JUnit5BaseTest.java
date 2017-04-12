package io.github.yermilov.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class N02_JUnit5BaseTest {

    @Test
    public void jupiter_is_fifth_planet() {
        assertEquals("Jupiter", Planet.getByIndex(5).getName());
    }

    @Test
    @DisplayName("Jupiter is the Fifth planet in the Solar System")
    public void jupiterIsFifthPlanet() {
        assertEquals("Jupiter", Planet.getByIndex(5).getName());
    }
}
