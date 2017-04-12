package io.github.yermilov.junit5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.time.Duration.ofDays;
import static java.time.Duration.ofHours;

public class PlanetSystem {

    public static PlanetSystem SOLAR_SYSTEM = new PlanetSystem(
            Arrays.asList(
                    new Planet("Mercury", ofDays(59), "42% molecular oxygen"),
                    new Planet("Venus", ofDays(243), "96.5% carbon dioxide"),
                    new Planet("Earth", ofHours(24), "78.08% nitrogen"),
                    new Planet("Mars", ofHours(24), "95.97% carbon dioxide"),
                    new Planet("Jupiter", ofHours(9), "89.8±2.0%\thydrogen")
            ),
            "Nicolaus Copernicus",
            "Sun"
    );

    private final List<Planet> planets;

    private final String modeledBy;
    private final String starName;

    private PlanetSystem(List<Planet> planets, String modeledBy, String starName) {
        this.planets = new ArrayList<>(planets);
        this.modeledBy = modeledBy;
        this.starName = starName;
    }

    public Planet getPlanetByIndex(int index) {
        if (index < 1) {
            throw new IllegalArgumentException("There is no planet with index=" + index);
        }
        return planets.get(index - 1);
    }

    public String getModeledBy() {
        return modeledBy;
    }

    public String getStarName() {
        return starName;
    }
}
