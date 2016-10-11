package de.novity.smarthome.timer.api.program;

import lombok.NonNull;

import java.util.UUID;

public class TimeProgramCreatedEvent {
    private final UUID id;

    public TimeProgramCreatedEvent(@NonNull UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
