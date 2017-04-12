package io.github.yermilov.junit5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static io.github.yermilov.junit5.PlanetSystem.SOLAR_SYSTEM;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Jupiter test cases")
class N06_NestedTest {

    Planet jupiter;

    @BeforeEach
    void locateJupiter() {
        jupiter = SOLAR_SYSTEM.getPlanetByIndex(5);
    }

    @Test
    void jupiter_is_fifth_planet() {
        assertEquals("Jupiter", jupiter.getName());
    }

    @Nested
    @DisplayName("Spaceship test cases")
    class SpaceshipTest {

        Spaceship spaceship;

        @BeforeEach
        void sentSpaceship() {
            spaceship = new Spaceship("Juno");
            spaceship.sentTo(jupiter);
        }

        @Test
        void spaceship_is_created() {
            assertNotNull(spaceship);
        }

        @Test
        void spaceship_is_on_his_way() {
            assertEquals("space", spaceship.getLocation());
        }

        @AfterEach
        void returnSpaceship() {
            spaceship.returnHome();
        }

        @Nested
        @DisplayName("Landing test cases")
        class LandingTest {

            @BeforeEach
            void landSpaceship() {
                spaceship.land();
            }

            @Test
            void spaceship_is_landed() {
                assertEquals("landed", spaceship.getLocation());
            }

            @Test
            void spaceship_is_on_correct_planet() {
                assertEquals("Jupiter", spaceship.getTarget().getName());
            }
        }
    }
}
