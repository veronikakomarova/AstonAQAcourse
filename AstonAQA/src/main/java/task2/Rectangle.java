package task2;

public class Rectangle extends Shape implements AreaCalculatable, PerimeterCalculatable, Printable {
    private int a;
    private int b;

    Rectangle(int a, int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public double getArea() {
        return a * b;
    }

    @Override
    public int[] getSides() {
        int[] sides = new int[]{a, b, a, b};
        return sides;
    }

    @Override
    public void print() {
        System.out.println("Прямоугольник:\n" +
                "периметр " + getPerimeter() +  ";\n" +
                "площадь " + getArea() +  ";\n" +
                "цвет фона " + backgroundColor +  ";\n" +
                "цвет границ " + borderColor +  ";\n");

    }
}
