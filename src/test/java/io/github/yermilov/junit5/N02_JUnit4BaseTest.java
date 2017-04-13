package io.github.yermilov.junit5;

import org.junit.Test;

import static io.github.yermilov.junit5.PlanetSystem.SOLAR_SYSTEM;
import static org.junit.Assert.assertEquals;

public class N02_JUnit4BaseTest {

    @Test
    public void marsIsForthPlanet() {
        Planet forthPlanet = SOLAR_SYSTEM.getPlanetByIndex(4);
        String actualName = forthPlanet.getName();
        assertEquals("Mars", actualName);
    }
}
