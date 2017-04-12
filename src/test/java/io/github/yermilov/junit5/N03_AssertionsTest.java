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
    @DisplayName("Jupiter is the Fifth planet in the Solar System")
    public void errorMessage() {
        assertEquals("Jupiter", Planet.getByIndex(4).getName(), "Are we counting with zero-based or one-based?");
    }

    @Test
    @DisplayName("Jupiter is the Fifth planet in the Solar System")
    public void all() {
        assertAll(
                () -> assertEquals("Jupiter", Planet.getByIndex(4).getName()),
                () -> assertEquals("Mars", Planet.getByIndex(5).getName())
        );

    }

    @Test
    @DisplayName("Jupiter is the Fifth planet in the Solar System")
    public void lazyMessage() {
        assertEquals("Jupiter", Planet.getByIndex(5).getName(), () -> {
            try {
                Thread.sleep(ofHours(2).toMillis());
            } catch (InterruptedException e) { }
            return "Let's think for a while, are we counting with zero-based or one-based?";
        });
    }

    @Test
    @DisplayName("Jupiter is the Fifth planet in the Solar System")
    public void assertExceptions() {
        assertThrows(IllegalArgumentException.class, () -> {
            Planet.getByIndex(0);
        });
    }

    @Test
    @Tag("slow")
    @DisplayName("Jupiter is the Fifth planet in the Solar System")
    public void timeouts() {
        assertTimeout(ofHours(9), () -> {
            Planet.getByIndex(5).waitForOneDay();
        });
    }

    @Test
    @DisplayName("Jupiter is the Fifth planet in the Solar System")
    public void timeouts2() {
        String actualAtmosphere = assertTimeoutPreemptively(ofSeconds(1), () -> {
            Thread.sleep(20000);
            return Planet.getByIndex(5).getAtmosphere();
        });
        assertEquals(actualAtmosphere, "89.8±2.0%\thydrogen (H2)");
    }
}
