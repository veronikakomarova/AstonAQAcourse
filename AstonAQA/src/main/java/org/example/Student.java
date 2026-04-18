package org.example;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private String firstName;
    private String lastName;
    private String group;
    private int course;
    private Map<String, Integer> grades;

    Student(String firstName, String lastName,String group, int course, Map<String, Integer> grades){
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

    @Override
    public String toString(){
        return firstName + " " + lastName + " - " + getAverageGrades();
    }
}
