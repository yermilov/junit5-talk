package io.github.yermilov.junit5;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class N01_JUnit4BaseTest {

    @Test
    public void mars_is_fourth_planet() {
        assertEquals("Mars", Planet.getByIndex(4).getName());
    }
}
