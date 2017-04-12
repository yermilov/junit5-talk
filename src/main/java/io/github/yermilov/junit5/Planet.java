package io.github.yermilov.junit5;

import java.time.Duration;

import static io.github.yermilov.junit5.TestUtils.waitFor;

public class Planet {

    private final String name;
    private final Duration oneDay;
    private final String atmosphere;

    public Planet(String name, Duration oneDay, String atmosphere) {
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
        waitFor(oneDay);
    }
}
