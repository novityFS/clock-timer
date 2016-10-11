package de.novity.smarthome.timer.api;

import lombok.NonNull;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.UUID;

public class StopTimerCommand {
    @TargetAggregateIdentifier
    private final UUID id;

    public StopTimerCommand(@NonNull UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
