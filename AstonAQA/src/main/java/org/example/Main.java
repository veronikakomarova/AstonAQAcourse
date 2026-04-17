package org.example;

import java.util.List;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Set<Student> students = Set.of(
                new Student("Пётр", "Петров", "Г-47", 2, null),
                new Student("Иван", "Иванов", "Г-47", 3, null),
                new Student("Анастасия", "Ковалёва", "Г-46", 1, null),
                new Student("Екатерина", "Лебедева", "Г-46", 1, null)
        );
    }
}