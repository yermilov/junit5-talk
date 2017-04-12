package io.github.yermilov.junit5;

import static java.time.Duration.ofHours;

public class Planet {

    public static Planet getByIndex(int index) {
        if (index == 4) {
            return new Planet("Mars", ofHours(24).toMillis(), "95.97% carbon dioxide");
        }
        if (index == 5) {
            return new Planet("Jupiter", ofHours(9).toMillis(), "89.8±2.0%\thydrogen (H2)");
        }
        throw new IllegalArgumentException("Unknown planet with index=" + index);
    }

    private final String name;
    private final long oneDay;
    private final String atmosphere;

    private Planet(String name, long oneDay, String atmosphere) {
        this.name = name;
        this.oneDay = oneDay;
        this.atmosphere = atmosphere;
    }

    public String getName() {
        return name;
    }

    public String getAtmosphere() {
        return atmosphere;
    }

    public void waitForOneDay() {
        try {
            Thread.sleep(oneDay);
        } catch (InterruptedException e) {
        }
    }
}
