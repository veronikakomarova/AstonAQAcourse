package org.example;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Set<Student> students = new HashSet<>(Set.of(
                new Student("Пётр", "Петров", "Г-47", 1,Map.of(
                        "Math", 5,
                        "English", 3,
                        "Biology", 3,
                        "Russian", 3
                )),
                new Student("Иван", "Иванов", "Г-47", 1, Map.of(
                        "Math", 2,
                        "English", 2,
                        "Biology", 3,
                        "Russian", 2
                )),
                new Student("Анна", "Васильева", "Г-47",1, Map.of(
                        "Math", 2,
                        "English", 3,
                        "Biology", 4,
                        "Russian", 3
                )),
                new Student("Полина", "Журавлёва", "Г-47",1, Map.of(
                        "Math", 5,
                        "English", 5,
                        "Biology", 5,
                        "Russian", 5
                )),
                new Student("Анастасия", "Ковалёва", "Г-46", 1, Map.of(
                        "Math", 3,
                        "English", 3,
                        "Biology", 3,
                        "Russian", 3
                )),
                new Student("Игорь", "Александров", "Г-46",1, Map.of(
                        "Math", 2,
                        "English", 2,
                        "Biology", 2,
                        "Russian", 3
                )),
                new Student("Екатерина", "Лебедева", "Г-46", 1, Map.of(
                        "Math", 2,
                        "English", 3,
                        "Biology", 3,
                        "Russian", 3
                )),
                new Student("Егор", "Пронин", "Г-46", 1, Map.of(
                        "Math", 5,
                        "English", 5,
                        "Biology", 3,
                        "Russian", 3
                ))

        ));
        StudentManager.printStudents(students,1);
        System.out.println();

        for (Student student : students){
            StudentManager.nextCourse(student);
        }

        StudentManager.printStudents(students,1);
        StudentManager.printStudents(students,2);
        System.out.println();

        StudentManager.removeStudent(students);
        StudentManager.printStudents(students,1);
        StudentManager.printStudents(students,2);
    }

}