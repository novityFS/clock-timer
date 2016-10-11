package de.novity.smarthome.timer.bc.timer;

import de.novity.smarthome.timer.api.*;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;

import java.util.UUID;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@NoArgsConstructor
public class Timer {
    @AggregateIdentifier
    private UUID id;
    private boolean started;

    /********************************************************************/

    @CommandHandler
    public void createTimer(CreateTimerCommand command) {
        apply(new TimerCreatedEvent(command.getId()));
    }

    @CommandHandler
    public void startTimer(StartTimerCommand command) {
        if (!started) {
            apply(new TimerStartedEvent(command.getId()));
        }
    }

    @CommandHandler
    public void stopTimer(StopTimerCommand command) {
        if (started) {
            apply(new TimerStoppedEvent(command.getId()));
        }
    }

    /********************************************************************/

    @EventSourcingHandler
    public void on(TimerCreatedEvent event) {
        this.id = event.getId();
    }

    @EventSourcingHandler
    public void on(TimerStartedEvent event) {
        this.started = true;
    }

    @EventSourcingHandler
    public void on(TimerStoppedEvent event) {
        this.started = false;
    }
}
