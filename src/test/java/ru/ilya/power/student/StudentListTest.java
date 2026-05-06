package ru.ilya.power.student;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StudentListTest {

    @Test
    void addStudentShouldIncreaseSize() {
        StudentList list = new StudentList();
        list.addStudent(new Student("Ivan", "Moscow"));
        assertThat(list.getStudentsFromCity("Moscow")).hasSize(1);
    }

    @Test
    void addStudentShouldIgnoreNull() {
        StudentList list = new StudentList();
        list.addStudent(null);
        assertThat(list.getSize()).isEqualTo(0);
    }

    @Test
    void getStudentsByCityShouldReturnCorrectStudents() {
        StudentList list = new StudentList();
        list.addStudent(new Student("Ivan", "Moscow"));
        list.addStudent(new Student("Pepe", "Kazan"));
        assertThat(list.getStudentsFromCity("Moscow")).hasSize(1);
    }

    @Test
    void getStudentByCityShouldReturnEmptyWhenNoneMatch() {
        StudentList list = new StudentList();
        list.addStudent(new Student("Ivan","Moscow"));
        assertThat(list.getStudentsFromCity("Kazan")).isEmpty();
    }

}
