package ru.ilya.power;

public record Student(
        String name,
        String city,
        String goal,
        int comletedLessons,
        int totalLessons
) {
    public Student {
        if (comletedLessons < 0 || totalLessons <= 0 || comletedLessons > totalLessons){
            throw new IllegalArgumentException("Некорректные значенмя прогресса");
        }
    }
}
