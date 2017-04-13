package io.github.yermilov.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.github.yermilov.junit5.PlanetSystem.SOLAR_SYSTEM;
import static org.junit.jupiter.api.Assertions.assertEquals;

// @RunWith(JUnitPlatform.class)
class N03_JUnit5BaseTest {

    @Test
    void jupiterIsFifthPlanet() {
        Planet fifthPlanet = SOLAR_SYSTEM.getPlanetByIndex(5);
        String actualName = fifthPlanet.getName();
        assertEquals("Jupiter", actualName);
    }

    @Test
    @DisplayName("Jupiter is the Fifth planet in the Solar System")
    void jupiterIsFifthPlanetButMethodNameIsNoLongerRelevantYouCanEvenPutAdsHere() {
        Planet fifthPlanet = SOLAR_SYSTEM.getPlanetByIndex(5);
        String actualName = fifthPlanet.getName();
        assertEquals("Jupiter", actualName);
    }
}
