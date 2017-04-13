package io.github.yermilov.junit5;

import junit.framework.TestCase;

import static io.github.yermilov.junit5.PlanetSystem.SOLAR_SYSTEM;

public class N01_JUnit3BaseTest extends TestCase {

    public void testMarsIsForthPlanet() {
        Planet forthPlanet = SOLAR_SYSTEM.getPlanetByIndex(4);
        String actualName = forthPlanet.getName();
        assertEquals("Mars", actualName);
    }
}
