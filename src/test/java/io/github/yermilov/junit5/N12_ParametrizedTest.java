package io.github.yermilov.junit5;

import org.junit.jupiter.api.extension.ContainerExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ObjectArrayArguments;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static io.github.yermilov.junit5.PlanetSystem.SOLAR_SYSTEM;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class N12_ParametrizedTest {

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3, 4, 5 })
    void testWithValueSource(int index) {
        assertNotNull(SOLAR_SYSTEM.getPlanetByIndex(index).getName());
    }

    @ParameterizedTest(name = "{0} is {1} planet in Solar System")
    @MethodSource(names = "planetsSource")
    void testWithMultiArgMethodSource(String expectedName, int index) {
        assertEquals(expectedName, SOLAR_SYSTEM.getPlanetByIndex(index).getName());
    }

    @ParameterizedTest(name = "{0} is {1} planet in Solar System")
    @CsvSource({ "'Jupiter', 5", "Earth, 3" })
    void testWithCsvSource(String expectedName, int index) {
        assertEquals(expectedName, SOLAR_SYSTEM.getPlanetByIndex(index).getName());
    }

    @ParameterizedTest(name = "{0} is {1} planet in Solar System")
    @CsvFileSource(resources = "/planets.csv")
    void testWithCsvFileSource(String expectedName, int index) {
        assertEquals(expectedName, SOLAR_SYSTEM.getPlanetByIndex(index).getName());
    }

    @ParameterizedTest(name = "{0} is {1} planet in Solar System")
    @ArgumentsSource(PlanetsProvider.class)
    void testWithArgumentsSource(String expectedName, int index) {
        assertEquals(expectedName, SOLAR_SYSTEM.getPlanetByIndex(index).getName());
    }

    static Stream<Arguments> planetsSource() {
        return Stream.of(
                ObjectArrayArguments.create("Venus", 2),
                ObjectArrayArguments.create("Mars", 4)
        );
    }

    static class PlanetsProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> arguments(ContainerExtensionContext context) throws Exception {
            AtomicInteger index = new AtomicInteger();
            return Stream.of("Mercury, Venus, Earth, Mars, Jupiter".split(","))
                    .sequential()
                    .map(String::trim)
                    .map(name -> ObjectArrayArguments.create(name, index.incrementAndGet()));
        }
    }
}
