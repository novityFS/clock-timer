package de.novity.smarthome.timer.bc.program;

import de.novity.smarthome.timer.api.program.SwitchingCycle;
import de.novity.smarthome.timer.api.program.TimeProgramDefinedEvent;
import de.novity.smarthome.timer.api.program.TimeProgramReleasedEvent;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.saga.EndSaga;
import org.axonframework.eventhandling.saga.SagaEventHandler;
import org.axonframework.eventhandling.saga.StartSaga;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.List;

public class TimeProgramManager {
    private static final Logger logger = LoggerFactory.getLogger(TimeProgramManager.class);

    private List<SwitchingCycle> switchingCycles;

    @Inject
    private transient CommandGateway commandGateway;

    @Inject
    private transient EventBus eventBus;

    @StartSaga
    @SagaEventHandler(
            associationProperty = "id"
    )
    public void on(TimeProgramDefinedEvent event) {
        this.switchingCycles = event.getSwitchCycles();
        logger.info("Time program defined - id={}, cycles={}", event.getId(), event.getSwitchCycles());
    }

    @EndSaga
    @SagaEventHandler(
            associationProperty = "id"
    )
    public void on(TimeProgramReleasedEvent event) {
        logger.info("Time program released - id={}", event.getId());
    }
}
