package ru.ilya.power;

public class ProgressDemo {
    static void main() {
        Progress progress = new Progress(
                "Ilya",
                2,
                3
        );

        System.out.println(progress.summary());
        if (progress.readyForSprint()){
            System.out.println("Status: sprint ready");
        } else {
            System.out.println("Status: backlog first");
        }

        System.out.println("Current branch: feature/DVT-3");
    }
}