package program3;

public class ArithmeticOperations {

    public static void main(String[] args){

        try {
          double result = calculate(5, 8, CalculateOperations.MULTIPLY);
            System.out.println(result);

        }
        catch (UnknownOperationException e){
            System.out.println(e.getMessage());
        }


    }

    public static double calculate(int left, int right, CalculateOperations operation) throws UnknownOperationException {

        if (operation == null){
            throw new UnknownOperationException();
        }

        switch (operation) {
            case PLUS: {
                return left + right;
            }
            case MINUS: {
                return left - right;
            }
            case MULTIPLY: {
                return left * right;
            }
            case DIVIDE: {
                return left / (right * 1.0);
            }
            default: {
                throw new UnknownOperationException();
            }
        }
    }
}

