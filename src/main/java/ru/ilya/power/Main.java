package ru.ilya.power;

public class Main {
    static void main() {
        ProgressTracker tracker = new ProgressTracker();

        Student[] students = {
                new Student("Иван", "Москва", "Backend разработка", 5, 12),
                new Student("Мария", "Санкт-Петербург", "Fullstack", 8,12),
                new Student("Пётр", "Казань", "Java Backend", 12, 12)
        };

        String progress = tracker.calculateTotalProgress(students);
        System.out.println(progress);
    }
}
