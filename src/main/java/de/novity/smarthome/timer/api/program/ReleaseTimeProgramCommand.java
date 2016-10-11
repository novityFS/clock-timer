package de.novity.smarthome.timer.api.program;

import lombok.NonNull;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.UUID;

public class ReleaseTimeProgramCommand {
    @TargetAggregateIdentifier
    private final UUID id;

    public ReleaseTimeProgramCommand(@NonNull UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
