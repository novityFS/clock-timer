package de.novity.smarthome.timer.api.program;

import lombok.NonNull;
import lombok.ToString;

import java.time.LocalTime;

@ToString
public class Interval {
    private final LocalTime lowerInstant;
    private final LocalTime higherInstant;

    public Interval(@NonNull LocalTime lowerInstant, @NonNull LocalTime higherInstant) {
        if (lowerInstant.compareTo(higherInstant) >= 0) {
            throw new IllegalArgumentException("Higher instant must be after lower instant");
        }

        this.lowerInstant = lowerInstant;
        this.higherInstant = higherInstant;
    }

    public LocalTime getLowerInstant() {
        return lowerInstant;
    }

    public LocalTime getHigherInstant() {
        return higherInstant;
    }
}
