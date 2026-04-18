package org.example;

import java.util.Set;

public class StudentManager {

    public static void removeStudent(Set<Student> students) {

        students.removeIf(x -> x.getAverageGrades() < 3);
    }

    public static void nextCourse(Student st) {

        if (st.getAverageGrades() >= 3) {
            int nextCrs = st.getCourse() + 1;
            st.setCourse(nextCrs);
        }
    }

    public static void printStudents(Set<Student> students, int course) {
        Student[] studArray = students.toArray(new Student[0]);
        System.out.println("Студенты, которые обучаются на курсе " + course + ":");

        long courseStudentCount = students.stream().filter(s -> s.getCourse() == course).count();

        if (courseStudentCount == 0){
            System.out.println("нет студентов.");
            return;
        }

        for (Student x : studArray) {
            if (course == x.getCourse()) {
                System.out.println(x);
            }

        }

    }

}

