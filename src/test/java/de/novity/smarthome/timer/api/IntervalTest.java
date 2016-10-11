package de.novity.smarthome.timer.api;

import de.novity.smarthome.timer.api.program.Interval;
import org.testng.annotations.Test;

import java.time.LocalTime;

public class IntervalTest {
    @Test
    public void createValidInterval() {
        final LocalTime loInstant = LocalTime.parse("08:00:00");
        final LocalTime hiInstant = LocalTime.parse("09:00:00");
        final Interval interval = new Interval(loInstant, hiInstant);
    }

    @Test(
            expectedExceptions = {
                    IllegalArgumentException.class
            }
    )
    public void createIntervalWithEqualInstantsShouldFail() {
        LocalTime loInstant = LocalTime.parse("08:00:00");
        LocalTime hiInstant = LocalTime.parse("08:00:00");
        final Interval interval = new Interval(loInstant, hiInstant);
    }

    @Test(
            expectedExceptions = {
                    IllegalArgumentException.class
            }
    )
    public void createIntervalHigherInstantBeforeLowerInstantShouldFail() {
        LocalTime loInstant = LocalTime.parse("08:00:00");
        LocalTime hiInstant = LocalTime.parse("07:00:00");
        final Interval interval = new Interval(loInstant, hiInstant);
    }
}