package de.novity.smarthome.timer.api.program;

import lombok.NonNull;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class DefineTimeProgramCommand {
    @TargetAggregateIdentifier
    private final UUID id;
    private final List<SwitchingCycle> switchingCycles;

    public DefineTimeProgramCommand(@NonNull UUID id, @NonNull List<SwitchingCycle> switchingCycles) {
        if (switchingCycles.isEmpty()) {
            throw new IllegalArgumentException("Switching cycles must not be empty");
        }

        this.id = id;
        this.switchingCycles = Collections.unmodifiableList(switchingCycles);
    }

    public UUID getId() {
        return id;
    }

    public  List<SwitchingCycle> getSwitchCycles() {
        return switchingCycles;
    }
}
