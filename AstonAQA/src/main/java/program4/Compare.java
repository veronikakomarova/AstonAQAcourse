package program4;

public class Compare {
    public static void main(String[] args) {

        System.out.println(compareResult(4,5));

    }

    public static CompareResult compareResult (int left, int right){

        if (left == right){
            return CompareResult.EQUAL;
        }
        else if (left < right) {
            return CompareResult.LESS;
        }
        else{
            return CompareResult.MORE;
        }


    }


}
