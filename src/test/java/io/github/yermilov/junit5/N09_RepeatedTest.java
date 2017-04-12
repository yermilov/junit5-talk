package io.github.yermilov.junit5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

class N09_RepeatedTest {

    Spaceship falcon = new Spaceship("Falcon");

    @BeforeEach
    void beforeEach(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        int currentRepetition = repetitionInfo.getCurrentRepetition();
        int totalRepetitions = repetitionInfo.getTotalRepetitions();
        String methodName = testInfo.getTestMethod().get().getName();
        System.err.printf("About to execute repetition %d of %d for %s%n", currentRepetition, totalRepetitions, methodName);
    }

    @RepeatedTest(value = 10, name = "start Falcon for {currentRepetition} time, plan to do it {totalRepetitions} times")
    void startFalcon() {
        falcon.sentToOrbit();
    }
}
