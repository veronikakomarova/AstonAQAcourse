package program1;

public class FactorialCalculator {


    public static void main(String[] args) {
        try {
            System.out.println(FactorialCalculator.factorial(0));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static int factorial(int a) throws NegativeFactorialException {
        if (a < 0) {
            throw new NegativeFactorialException();
        }
        long fact = 1;

        for (int i = 1; i <= a; i++) {
            fact *= i;
        }

        return fact;
    }
}
