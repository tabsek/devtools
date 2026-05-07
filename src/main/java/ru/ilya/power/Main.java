package ru.ilya.power;

import ru.ilya.power.student.Student;
import ru.ilya.power.student.StudentList;

public class Main {
    static void main() {
        StudentList list = new StudentList();
        list.addStudent(new Student("Ivan", "Moscow"));
    }
}
