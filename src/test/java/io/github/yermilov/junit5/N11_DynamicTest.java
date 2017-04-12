package io.github.yermilov.junit5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.function.ThrowingConsumer;

import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Stream;

import static io.github.yermilov.junit5.PlanetSystem.SOLAR_SYSTEM;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

class N11_DynamicTest {

    @BeforeEach
    void beforeEach(TestInfo testInfo) {
        if (testInfo.getDisplayName().contains("Mars")) {
            System.exit(666);
        }
    }

    @TestFactory
    Stream<DynamicTest> dynamicTestsFromStream() {
        AtomicInteger index = new AtomicInteger();
        return Stream.of("Mercury, Venus, Earth, Mars, Jupiter".split(","))
                .sequential()
                .map(String::trim)
                .map(planet -> dynamicTest("locate " + planet, () -> {
                    assertEquals(planet, SOLAR_SYSTEM.getPlanetByIndex(index.incrementAndGet()).getName());
                }));
    }

    @TestFactory
    Stream<DynamicTest> generateRandomNumberOfTests() {
        Iterator<Integer> inputGenerator = new Iterator<Integer>() {

            Random random = new Random();
            int current;

            @Override
            public boolean hasNext() {
                current = random.nextInt(8);
                return current > 0 && current < 6;
            }

            @Override
            public Integer next() {
                return current;
            }
        };

        Function<Integer, String> displayNameGenerator = (input) -> "find planet #" + input;

        ThrowingConsumer<Integer> testExecutor = (input) -> assertNotNull(SOLAR_SYSTEM.getPlanetByIndex(input));

        return DynamicTest.stream(inputGenerator, displayNameGenerator, testExecutor);
    }
}
