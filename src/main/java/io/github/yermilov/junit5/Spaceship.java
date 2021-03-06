package io.github.yermilov.junit5;

import static io.github.yermilov.junit5.PlanetSystem.SOLAR_SYSTEM;

public class Spaceship {

    private final static Planet EARTH = SOLAR_SYSTEM.getPlanetByIndex(3);

    private final static int MAX_MOVES_COUNT = 6;

    private final String name;

    private Planet target = EARTH;
    private String location = "landed";
    private int movesCount;

    public Spaceship(String name) {
        this.name = name;
        this.movesCount = 0;
    }

    public void sentTo(Planet target) {
        checkMovesCount();

        this.location = "space";
        this.target = target;
    }

    public void returnHome() {
        checkMovesCount();

        sentTo(EARTH);
    }

    public void land() {
        checkMovesCount();

        this.location = "landed";
    }

    public void sentToOrbit() {
        checkMovesCount();

        this.location = "on orbit";
    }

    private void checkMovesCount() {
        if (movesCount > MAX_MOVES_COUNT) {
            throw new IllegalStateException(name + " can't move anymore");
        }
        movesCount++;
    }

    public String getLocation() {
        return location;
    }

    public Planet getTarget() {
        return target;
    }
}
