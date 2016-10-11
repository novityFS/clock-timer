package de.novity.smarthome.timer.api.program;

import lombok.NonNull;
import lombok.ToString;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@ToString
public class TimeProgramReleasedEvent {
    private final UUID id;

    private final List<SwitchingCycle> switchingCycles;

    public TimeProgramReleasedEvent(@NonNull UUID id, @NonNull List<SwitchingCycle> switchingCycles) {
        if (switchingCycles.isEmpty()) {
            throw new IllegalArgumentException("Switching cycles must not be empty");
        }

        this.id = id;
        this.switchingCycles = Collections.unmodifiableList(switchingCycles);
    }

    public UUID getId() {
        return id;
    }

    public List<SwitchingCycle> getSwitchingCycles() {
        return switchingCycles;
    }
}
