package io.github.yermilov.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.util.Collections;

import static io.github.yermilov.junit5.PlanetSystem.SOLAR_SYSTEM;
import static org.junit.jupiter.api.Assertions.assertEquals;

class N07_DependencyInjectionTest {

    @Test
    @Tag("gas giants")
    @DisplayName("Jupiter is the Fifth planet in the Solar System")
    void jupiterIsFifthPlanet(TestInfo testInfo) {
        assertEquals("Jupiter", SOLAR_SYSTEM.getPlanetByIndex(5).getName());

        assertEquals("Jupiter is the Fifth planet in the Solar System", testInfo.getDisplayName());
        assertEquals(Collections.singleton("gas giants"), testInfo.getTags());
        assertEquals("io.github.yermilov.junit5.N07_DependencyInjectionTest", testInfo.getTestClass().get().getName());
        assertEquals("jupiterIsFifthPlanet", testInfo.getTestMethod().get().getName());
    }
}
