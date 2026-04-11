package task2;

public class Circle extends Shape implements AreaCalculatable, PerimeterCalculatable, Printable{
    private int r;

    Circle(int radius){
        r = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(r, 2);
    }

    @Override
    public double getPerimeter(){
        return 2 * r * Math.PI;
    }

    @Override
    public int[] getSides() {
        int[] sides = new int[]{r};
        return sides;
    }

    @Override
    public void print() {
        System.out.println("Круг:\n" +
                "периметр " + getPerimeter() +  ";\n" +
                "площадь " + getArea() +  ";\n" +
                "цвет фона " + backgroundColor +  ";\n" +
                "цвет границ " + borderColor +  ";\n");

    }
}
