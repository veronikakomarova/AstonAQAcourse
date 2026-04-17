package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StudentManager {

    public static void removeStudent(Set<Student> students){

        students.removeIf(x -> x.getAverageGrades() < 3);
    }

    public static void nextCourse(int course){

        if (Student.getAverageGrades >= 3){
            
        }

    }
}
