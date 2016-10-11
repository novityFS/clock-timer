package de.novity.smarthome.timer.api;

import lombok.NonNull;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.UUID;

public class AssignTimeprogramCommand {
    @TargetAggregateIdentifier
    private final UUID id;
    private final UUID timeprogramId;

    public AssignTimeprogramCommand(@NonNull UUID id, @NonNull UUID timeprogramId) {
        this.id = id;
        this.timeprogramId = timeprogramId;
    }

    public UUID getId() {
        return id;
    }

    public UUID getTimeprogramId() {
        return timeprogramId;
    }
}
