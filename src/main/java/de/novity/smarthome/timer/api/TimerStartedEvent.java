package de.novity.smarthome.timer.api;

import lombok.NonNull;

import java.util.UUID;

public class TimerStartedEvent {
    private final UUID id;

    public TimerStartedEvent(@NonNull UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
