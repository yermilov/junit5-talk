package io.github.yermilov.junit5;

import org.junit.Test;

import static io.github.yermilov.junit5.PlanetSystem.SOLAR_SYSTEM;
import static org.junit.Assert.assertEquals;

public class N01_JUnit4BaseTest {

    @Test
    public void mars_is_fourth_planet() {
        assertEquals("Mars", SOLAR_SYSTEM.getPlanetByIndex(4).getName());
    }
}
