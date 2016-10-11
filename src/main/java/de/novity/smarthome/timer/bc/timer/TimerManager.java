package de.novity.smarthome.timer.bc.timer;

import de.novity.smarthome.timer.api.TimerStartedEvent;
import de.novity.smarthome.timer.api.TimerStoppedEvent;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.saga.EndSaga;
import org.axonframework.eventhandling.saga.SagaEventHandler;
import org.axonframework.eventhandling.saga.StartSaga;
import org.axonframework.eventhandling.scheduling.EventScheduler;

import javax.inject.Inject;

public class TimerManager {
    @Inject
    private transient CommandGateway commandGateway;

    @Inject
    private transient EventScheduler eventScheduler;

    @StartSaga
    @SagaEventHandler(
            associationProperty = "id"
    )
    public void on(TimerStartedEvent event) {
    }

    @EndSaga
    @SagaEventHandler(
            associationProperty = "id"
    )
    public void on(TimerStoppedEvent event) {
    }
}
