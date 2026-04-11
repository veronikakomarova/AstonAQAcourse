package task2;

import task1.Animal;
import task1.Bowl;
import task1.Cat;
import task1.Dog;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Triangle shape1 = new Triangle(5, 6, 3);
        shape1.setBackgroundColor("Красный");
        shape1.setBorderColor("Черный");

        Rectangle shape2 = new Rectangle(10, 7);
        shape2.setBackgroundColor("Синий");

        Circle shape3 = new Circle(12);
        shape3.setBorderColor("Зеленый");


        shape1.print();
        shape2.print();
        shape3.print();
    }
}