package ru.ilya.power;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProgressTest {

    @Test
    void shouldFormatSummary_whenProgressCreated() {
        Progress progress = new Progress("Ilya", 2, 3);

        String result = progress.summary();

        assertThat(result).isEqualTo("Sprint 2 → Ilya: planned 3 h");
    }

    @Test
    void shouldDetectReadiness_whenHoursAboveThreshold() {
        Progress progress = new Progress("Ilya", 2, 20  );

        assertThat(progress.readyForSprint()).isTrue();
    }

    @Test
    void shouldDetectLackOfReadiness_whenHoursBelowThreshold() {
        Progress progress = new Progress("Ilya", 2, 1);

        assertThat(progress.readyForSprint()).isFalse();
    }
}
