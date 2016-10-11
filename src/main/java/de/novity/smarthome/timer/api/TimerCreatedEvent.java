package de.novity.smarthome.timer.api;

import lombok.NonNull;

import java.util.UUID;

public class TimerCreatedEvent {
    private final UUID id;

    public TimerCreatedEvent(@NonNull UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
