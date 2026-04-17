package org.example;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private String firstName;
    private String lastName;
    private String group;
    private int course;
    private HashMap<String, Integer> grades;

    Student(String firstName, String lastName,String group, int course, HashMap<String, Integer> grades){
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public double getAverageGrades(){
        int sum = 0;

        for(int value : grades.values()){
            sum += value;
        }

        return sum / (grades.size() * 1.0);
    }

    public void setCourse(int a) {
        course = a;
    }

    public int getCourse(){
        return course;
    }
}
