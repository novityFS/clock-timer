package de.novity.smarthome.timer.bc.program;

import de.novity.smarthome.timer.api.program.Interval;
import de.novity.smarthome.timer.api.program.SwitchingCycle;
import de.novity.smarthome.timer.api.program.TimeProgramDefinedEvent;
import de.novity.smarthome.timer.api.program.TimeProgramReleasedEvent;
import org.axonframework.test.saga.AnnotatedSagaTestFixture;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TimeProgramManagerTest {
    private AnnotatedSagaTestFixture<TimeProgramManager> fixture;

    @BeforeTest
    public void setUp() throws Exception {
        fixture = new AnnotatedSagaTestFixture<>(TimeProgramManager.class);
    }

    @Test
    public void startSaga() throws Exception {
        final UUID id = UUID.randomUUID();
        final String value = "On";
        final Interval interval = new Interval(LocalTime.MIN, LocalTime.MAX);
        final SwitchingCycle switchingCycle = new SwitchingCycle(interval, value);

        final List<SwitchingCycle> switchingCycles = new ArrayList<>();
        switchingCycles.add(switchingCycle);

        fixture
                .givenNoPriorActivity()
                .whenPublishingA(new TimeProgramDefinedEvent(id, switchingCycles))
                .expectActiveSagas(1);
    }

    @Test
    public void endSaga() throws Exception {
        final UUID id = UUID.randomUUID();
        final String value = "On";
        final Interval interval = new Interval(LocalTime.MIN, LocalTime.MAX);
        final SwitchingCycle switchingCycle = new SwitchingCycle(interval, value);

        final List<SwitchingCycle> switchingCycles = new ArrayList<>();
        switchingCycles.add(switchingCycle);

        fixture
                .givenAggregate("id")
                .published(new TimeProgramDefinedEvent(id, switchingCycles))
                .whenPublishingA(new TimeProgramReleasedEvent(id, switchingCycles))
                .expectNoDispatchedCommands();
    }
}