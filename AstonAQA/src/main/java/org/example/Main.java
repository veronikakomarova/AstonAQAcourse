package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Задание 1, 2, 3");

        String[][] arr = new String[][]{
                {"5", "1", "333", "5"},
                {"-77", "1", "9", "64"},
                {"3", "hello", "88", "1"},
                {"0", "3", "6", "6"}
        };

        try {
            int sum = sumMatrix(arr);
            System.out.println("Сумма: " + sum);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());

        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage() + " строка: " + e.getRowIndex() + "; столбец: " + e.getColIndex() + ".");

        } catch (Exception e) {
            System.out.println("Непредвиденная ошибка: " + e.getMessage());
        }

        System.out.println();
        System.out.println("Задание 4");
        int[] a = new int[5];

        try {
            System.out.println(a[10]);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOfBoundsException пойман.");
        }

    }

    public static int sumMatrix(String[][] matrix) throws MyArraySizeException, MyArrayDataException {

        if (matrix.length != 4) {
            throw new MyArraySizeException();
        }

        for (int k = 0; k < matrix.length; k++) {
            if (matrix[k].length != 4) {
                throw new MyArraySizeException();
            }
        }

        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                String s = matrix[i][j];
                try {
                    int num = Integer.parseInt(s);
                    sum += num;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(s, i, j, e);
                }
            }
        }
        return sum;
    }
}