package ru.ilya.power;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProgressTrackerTest {


    @Test
    @DisplayName("Должен корректно вычислить суммарный прогресс, когда передан массив студентов")
    void shouldCalculateTotalProgressWhenMultipleStudents() {
        ProgressTracker tracker = new ProgressTracker();

        Student[] students = {
                new Student("Иван", "Москва", "Backend разработка", 5, 12),
                new Student("Мария", "Санкт-Петербург", "Fullstack", 8, 12),
                new Student("Пётр", "Казань", "Java Backend", 12, 12)
        };

        String result = tracker.calculateTotalProgress(students);

        assertThat(result)
                .contains("11");
    }

    @Test
    @DisplayName("Должен корректно вычислить суммарный прогресс, когда все студенты завершили курс")
    void shouldCalculateTotalProgressWhenStudentsCompletedCourse() {
        ProgressTracker tracker = new ProgressTracker();

        Student[] students = {
                new Student("Иван", "Москва", "Backend разработка", 12, 12),
                new Student("Мария", "Санкт-Петербург", "Fullstack", 12, 12),
                new Student("Пётр", "Казань", "Java Backend", 12, 12)
        };

        String result = tracker.calculateTotalProgress(students);

        assertThat(result)
                .contains("0");
    }
}
