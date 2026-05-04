package ru.ilya.power.student;

import java.util.List;
import java.util.ArrayList;

public class StudentList {
    private List<Student> studentList;

    public StudentList() {
        studentList = new ArrayList<>();
    }

    public void addStudent(Student student) {
        if (student != null) {
            studentList.add(student);
        }
    }

    public List<Student> getStudentsFromCity(String city) {
        return studentList.stream().filter(s -> s.city().equals(city)).toList();
    }

    public int getSize() {
        return studentList.size();
    }
}
