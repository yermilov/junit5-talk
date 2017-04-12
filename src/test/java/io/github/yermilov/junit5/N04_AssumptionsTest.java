package io.github.yermilov.junit5;

import org.junit.jupiter.api.Test;

import static io.github.yermilov.junit5.PlanetSystem.SOLAR_SYSTEM;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class N04_AssumptionsTest {

    @Test
    void assumeWeUseCopernicusModel() {
        assumeTrue("Nicolaus Copernicus".equals(SOLAR_SYSTEM.getModeledBy()));

        assertEquals("Jupiter", SOLAR_SYSTEM.getPlanetByIndex(5).getName());
    }

    @Test
    void assumeWeUsePtolemyModel() {
        assumeTrue("Ptolemy".equals(SOLAR_SYSTEM.getModeledBy()), () -> "wrong model!");

        assertEquals("Earth", SOLAR_SYSTEM.getPlanetByIndex(0).getName());
    }

    @Test
    void testInAllEnvironments() {
        assumingThat("Nicolaus Copernicus".equals(SOLAR_SYSTEM.getModeledBy()),
                () -> {
                    assertEquals("Earth", SOLAR_SYSTEM.getPlanetByIndex(3).getName());
                });

        assumingThat("Ptolemy".equals(SOLAR_SYSTEM.getModeledBy()),
                () -> {
                    assertEquals("Earth", SOLAR_SYSTEM.getPlanetByIndex(0).getName());
                });

        assertEquals("Sun", SOLAR_SYSTEM.getStarName());
    }
}
