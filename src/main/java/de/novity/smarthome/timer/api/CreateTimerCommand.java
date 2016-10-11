package de.novity.smarthome.timer.api;

import lombok.NonNull;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.UUID;

public class CreateTimerCommand {
    @TargetAggregateIdentifier
    private final UUID id;

    public CreateTimerCommand(@NonNull UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
