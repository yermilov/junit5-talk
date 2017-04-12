package io.github.yermilov.junit5;

import java.time.Duration;

public final class TestUtils {

    private TestUtils() {}

    public static void waitFor(long timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
        }
    }

    public static void waitFor(Duration duration) {
        waitFor(duration.toMillis());
    }
}
