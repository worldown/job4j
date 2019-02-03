package ru.job4j.stream.students_list_to_map;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Kosolapov Ilya (d_dexter@mail.ru)
 * @version $ID$
 * @since 0.1
 */
public class SchoolTest {
    private List<Student> students;
    private School school;

    @Before
    public void init() {
        school = new School();
        students = new ArrayList<>();
        students.add(new Student("Jon", 15));
        students.add(new Student("Mike", 20));
        students.add(new Student("Den", 30));
        students.add(new Student("Smith", 80));
        students.add(new Student("Len", 55));
        students.add(new Student("Tom", 75));
        students.add(new Student("Met", 40));
        students.add(new Student("Ben", 88));
        students.add(new Student("Can", 100));
        students.add(new Student("Ann", 12));
        students.add(new Student("Jack", 60));

    }

    @Test
    public void whenGetListAThenListA() {
        Map<String, Student> student = school.
                collect(students, x -> x.getScore() >= 70);
        assertThat(student.size(), is(4));
    }

    @Test
    public void whenGetListBThenListB() {
        Map<String, Student> student = school.
                collect(students, x -> x.getScore() >= 50 && x.getScore() < 70);
        assertThat(student.size(), is(2));
    }

    @Test
    public void whenGetListCThenListC() {
        Map<String, Student> student = school.
                collect(students, x -> x.getScore() < 50);
        assertThat(student.size(), is(5));
    }

    @Test
    public void whenGetListNullThenListNull() {
        Map<String, Student> student = school.
                collect(students, x -> x.getScore() < 12);
        assertThat(student.size(), is(0));
    }
}
