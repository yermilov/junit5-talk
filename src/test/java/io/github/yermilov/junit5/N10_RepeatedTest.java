package io.github.yermilov.junit5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

class N10_RepeatedTest {

    static Spaceship falcon = new Spaceship("Falcon");

    @BeforeEach
    void beforeEach(TestInfo testInfo, RepetitionInfo repetitionInfo, TestReporter testReporter) {
        int currentRepetition = repetitionInfo.getCurrentRepetition();
        int totalRepetitions = repetitionInfo.getTotalRepetitions();
        testReporter.publishEntry("repetition", currentRepetition + "/" + totalRepetitions);
    }

    @RepeatedTest(value = 10, name = "start Falcon for {currentRepetition} time, plan to do it {totalRepetitions} times")
    void startFalcon() {
        falcon.sentToOrbit();
    }
}
