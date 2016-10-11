package de.novity.smarthome.timer.api.program;

import lombok.NonNull;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.UUID;

public class CreateTimeProgramCommand {
    @TargetAggregateIdentifier
    private final UUID id;

    public CreateTimeProgramCommand(@NonNull UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
