package program2;

import program1.FactorialCalculator;

public class AreaOfTriangle {


    public static void main(String[] args) {
        System.out.println(areaOfTriangle(5,6,4));
    }


   public static double areaOfTriangle(double a, double b, double c) {
        double p = (a + b + c) / 2;
        double beforeArea = p * (p - a) * (p - b) * (p - c);
        return Math.sqrt(beforeArea);
    }
}
