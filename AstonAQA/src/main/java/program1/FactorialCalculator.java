package program1;

public class FactorialCalculator {


    public static void main(String[] args) {
        try {
            System.out.println(FactorialCalculator.factorial(21));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static long factorial(int a) throws NegativeFactorialException, MaxFactorialException {
        if (a < 0) {
            throw new NegativeFactorialException();
        }
        if (a > 20){
            throw new MaxFactorialException();
        }
        long fact = 1;

        for (int i = 1; i <= a; i++) {
            fact *= i;
        }

        return fact;
    }
}
