package io.github.yermilov.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofHours;
import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

public class N03_AssertionsTest {

    @Test
    @DisplayName("multiple assertions can be checked at once")
    public void all() {
        assertAll(
                () -> assertEquals("Jupiter", Planet.getByIndex(4).getName()),
                () -> assertEquals("Mars", Planet.getByIndex(5).getName())
        );
    }

    @Test
    @DisplayName("error messages was moved to the end of method signature")
    public void errorMessage() {
        assertEquals("Jupiter", Planet.getByIndex(4).getName(), "Are we counting with zero-based or one-based?");
    }

    @Test
    @DisplayName("error messages can be generated lazily")
    public void lazyMessage() {
        assertEquals("Jupiter", Planet.getByIndex(5).getName(), () -> {
            try {
                Thread.sleep(ofHours(2).toMillis());
            } catch (InterruptedException e) { }
            return "Let's think for a while, are we counting with zero-based or one-based?";
        });
    }

    @Test
    @DisplayName("expected exceptions now asserted throws")
    public void assertExceptions() {
        assertThrows(IllegalArgumentException.class, () -> {
            Planet.getByIndex(0);
        });
    }

    @Test
    @Tag("slow")
    @DisplayName("we can check that some code is executed within a time limit")
    public void timeouts() {
        assertTimeout(ofHours(9), () -> {
            Planet.getByIndex(5).waitForOneDay();
        });
    }

    @Test
    @DisplayName("we can get results of timelimited actions and terminate them")
    public void timeoutsWithResults() {
        String actualAtmosphere = assertTimeoutPreemptively(ofSeconds(1), () -> {
            Thread.sleep(20000);
            return Planet.getByIndex(5).getAtmosphere();
        });
        assertEquals(actualAtmosphere, "89.8±2.0%\thydrogen (H2)");
    }
}
