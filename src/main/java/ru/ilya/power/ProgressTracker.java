package ru.ilya.power;

public class ProgressTracker {
    public String calculateTotalProgress(Student[] students) {

        if (students == null || students.length == 0) {
            throw new IllegalArgumentException("Некорректное значение массива");
        }

        int totalCompleted = 0;
        int totalTotal = 0;
        int index = 0;

        while (index < students.length) {
            totalTotal += students[index].totalLessons();
            totalCompleted += students[index].comletedLessons();
            index += 1;
        }

        int totalRemaining = totalTotal - totalCompleted;

        return Integer.toString(totalRemaining);
    }
}
