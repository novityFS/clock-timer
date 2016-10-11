package de.novity.smarthome.timer.api.program;

import lombok.NonNull;
import lombok.ToString;

@ToString
public class SwitchingCycle {
    private final Interval interval;
    private final String value;

    public SwitchingCycle(@NonNull Interval interval, @NonNull String value) {
        if (value.isEmpty()) {
            throw new IllegalArgumentException("Value must not be empty");
        }

        this.interval = interval;
        this.value = value;
    }

    public Interval getInterval() {
        return interval;
    }

    public String getValue() {
        return value;
    }
}
