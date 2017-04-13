package io.github.yermilov.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.github.yermilov.junit5.PlanetSystem.SOLAR_SYSTEM;
import static io.github.yermilov.junit5.TestUtils.waitFor;
import static java.time.Duration.ofHours;
import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

class N04_AssertionsTest {

    @Test
    @DisplayName("multiple assertions can be checked at once")
    void all() {
        assertAll(
                () -> assertEquals("Jupiter", SOLAR_SYSTEM.getPlanetByIndex(4).getName()),
                () -> assertEquals("Mars", SOLAR_SYSTEM.getPlanetByIndex(5).getName())
        );
    }

    @Test
    @DisplayName("error messages was moved to the end of method signature")
    void errorMessage() {
        assertEquals("Jupiter", SOLAR_SYSTEM.getPlanetByIndex(4).getName(), "Are we counting with zero-based or one-based?");
    }

    @Test
    @DisplayName("error messages can be generated lazily")
    void lazyMessage() {
        assertEquals("Jupiter", SOLAR_SYSTEM.getPlanetByIndex(5).getName(), () -> {
            waitFor(ofHours(2));
            return "Let's think for a while, are we counting with zero-based or one-based?";
        });
    }

    @Test
    @DisplayName("expected exceptions now asserted throws")
    void assertExceptions() {
        IllegalArgumentException actualException = assertThrows(IllegalArgumentException.class, () -> {
            SOLAR_SYSTEM.getPlanetByIndex(0);
        });
        assertEquals("There is no planet with index=0", actualException.getMessage());
    }

    @Test
    @Tag("slow")
    @DisplayName("we can check that some code is executed within a time limit")
    void timeouts() {
        assertTimeout(ofHours(9), () -> {
            Planet jupiter = SOLAR_SYSTEM.getPlanetByIndex(5);
            jupiter.waitForOneDay();
        });
    }

    @Test
    @DisplayName("we can get results of timelimited actions and terminate them")
    void timeoutsWithResults() {
        String actualAtmosphere = assertTimeoutPreemptively(ofSeconds(5), () -> {
            Planet jupiter = SOLAR_SYSTEM.getPlanetByIndex(5);
            waitFor(ofSeconds(10));
            return jupiter.getAtmosphere();
        });
        assertEquals(actualAtmosphere, "89.8±2.0%\thydrogen");
    }
}
