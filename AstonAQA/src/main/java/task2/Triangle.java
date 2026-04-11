package task2;

public class Triangle extends Shape implements AreaCalculatable, PerimeterCalculatable, Printable{

    private int a;
    private int b;
    private int c;

    Triangle(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getArea() {
        double polP = getPerimeter()/2.0;
        double s = Math.sqrt(polP * (polP - a ) * (polP - b) * (polP - c));
        return s;
    }

    @Override
    public int[] getSides() {
        int[] arraySides = new int[]{a, b, c};
        return arraySides;
    }

    @Override
    public void print() {
        System.out.println("Треугольник:\n" +
                "периметр " + getPerimeter() +  ";\n" +
                "площадь " + getArea() +  ";\n" +
                "цвет фона " + backgroundColor +  ";\n" +
                "цвет границ " + borderColor +  ";\n");
    }
}
