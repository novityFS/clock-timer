package de.novity.smarthome.timer.api;

import lombok.NonNull;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.UUID;

public class StartTimerCommand {
    @TargetAggregateIdentifier
    private final UUID id;

    public StartTimerCommand(@NonNull UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
