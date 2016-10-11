package de.novity.smarthome.timer.bc.program;

import de.novity.smarthome.timer.api.program.*;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;

import java.util.List;
import java.util.UUID;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@NoArgsConstructor
public class TimeProgram {
    @AggregateIdentifier
    private UUID id;
    private State state;
    private List<SwitchingCycle> switchingCycles;

    @CommandHandler
    public TimeProgram(CreateTimeProgramCommand command) {
        apply(new TimeProgramCreatedEvent(command.getId()));
    }

    @CommandHandler
    public void defineTimeProgram(DefineTimeProgramCommand command) {
        if ((state == State.created) || (state == State.released)){
            apply(new TimeProgramDefinedEvent(id, command.getSwitchCycles()));
        } else {
            throw new IllegalStateException("Time program cannot be defined in state " + state);
        }
    }

    @CommandHandler
    public void releaseTimeProgram(ReleaseTimeProgramCommand command) {
        if (state != State.defined) {
            throw new IllegalStateException("Time program cannot be released in state " + state);
        }

        apply(new TimeProgramReleasedEvent(id, switchingCycles));
    }

    @EventSourcingHandler
    public void on(TimeProgramCreatedEvent event) {
        this.id = event.getId();
        this.state = State.created;
    }

    @EventSourcingHandler
    public void on(TimeProgramDefinedEvent event) {
        switchingCycles = event.getSwitchCycles();
        state = State.defined;
    }

    @EventSourcingHandler
    public void on(TimeProgramReleasedEvent event) {
        state = State.released;
    }

    private enum State {
        created,
        defined,
        released
    }
}
