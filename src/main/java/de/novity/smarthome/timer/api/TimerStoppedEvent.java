package de.novity.smarthome.timer.api;

import lombok.NonNull;

import java.util.UUID;

public class TimerStoppedEvent {
    private final UUID id;

    public TimerStoppedEvent(@NonNull UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
