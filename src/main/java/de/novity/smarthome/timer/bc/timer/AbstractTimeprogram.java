package de.novity.smarthome.timer.bc.timer;

import org.immutables.value.Value;

import java.util.SortedSet;
import java.util.UUID;

@Value.Immutable
public abstract class AbstractTimeprogram {
    public abstract UUID getId();
    public abstract SortedSet<SwitchCycle> getSwitchCycles();
}
