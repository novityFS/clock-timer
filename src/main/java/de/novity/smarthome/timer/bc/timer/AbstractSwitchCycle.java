package de.novity.smarthome.timer.bc.timer;

import org.immutables.value.Value;

import java.time.LocalTime;

@Value.Immutable
public abstract class AbstractSwitchCycle {
    public abstract LocalTime getSwitchTime();
    public abstract String getSwitchValue();
}
