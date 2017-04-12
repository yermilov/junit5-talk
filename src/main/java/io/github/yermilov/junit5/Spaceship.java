package io.github.yermilov.junit5;

import static io.github.yermilov.junit5.PlanetSystem.SOLAR_SYSTEM;

public class Spaceship {

    private final static Planet EARTH = SOLAR_SYSTEM.getPlanetByIndex(3);

    private final String name;

    private Planet target = EARTH;
    private String location = "landed";

    public Spaceship(String name) {
        this.name = name;
    }

    public void sentTo(Planet target) {
        System.err.println(name + " is going to " + target.getName());

        this.location = "space";
        this.target = target;
    }

    public void returnHome() {
        System.err.println(name + " is returning home");

        sentTo(EARTH);
    }

    public void land() {
        System.err.println(name + " is landing on " + target.getName());

        this.location = "landed";
    }

    public String getLocation() {
        return location;
    }

    public Planet getTarget() {
        return target;
    }
}
