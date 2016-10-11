package de.novity.smarthome.timer.bc.program;

import de.novity.smarthome.timer.api.program.*;
import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TimeProgramTest {
    private FixtureConfiguration fixture;

    @BeforeMethod
    public void setUp() throws Exception {
        fixture = Fixtures.newGivenWhenThenFixture(TimeProgram.class);
    }

    @Test
    public void registerTimeProgram() {
        final UUID uuid = UUID.randomUUID();

        fixture
                .givenNoPriorActivity()
                .when(new CreateTimeProgramCommand(uuid))
                .expectEvents(new TimeProgramCreatedEvent(uuid));

    }

    @Test
    public void defineTimeProgram() {
        final UUID uuid = UUID.randomUUID();
        final Interval interval = new Interval(LocalTime.parse("00:00:00"), LocalTime.parse("23:59:59"));
        final String value = "ON";

        final List<SwitchingCycle> switchingCycles = new ArrayList<>();
        switchingCycles.add(new SwitchingCycle(interval, value));

        fixture
                .given(new TimeProgramCreatedEvent(uuid))
                .when(new DefineTimeProgramCommand(uuid, switchingCycles))
                .expectEvents(new TimeProgramDefinedEvent(uuid, switchingCycles));


    }

    @Test
    public void releaseTimeprogram() {
        final UUID uuid = UUID.randomUUID();
        final Interval interval = new Interval(LocalTime.parse("00:00:00"), LocalTime.parse("23:59:59"));
        final String value = "ON";

        final List<SwitchingCycle> switchingCycles = new ArrayList<>();
        switchingCycles.add(new SwitchingCycle(interval, value));

        fixture
                .given(new TimeProgramCreatedEvent(uuid), new TimeProgramDefinedEvent(uuid, switchingCycles))
                .when(new ReleaseTimeProgramCommand(uuid))
                .expectEvents(new TimeProgramReleasedEvent(uuid, switchingCycles));
    }
}