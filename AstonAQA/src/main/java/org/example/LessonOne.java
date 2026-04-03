package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class LessonOne {
    public static void main(String[] args) {
        System.out.println("Задание 1:");
        printThreeWords();

        System.out.println("Задание 2:");
        checkSumSign();

        System.out.println("Задание 3:");
        printColor();

        System.out.println("Задание 4:");
        compareNumbers();

        System.out.println("Задание 5:");
        System.out.println(taskFive(4, 6));

        System.out.println("Задание 6:");
        taskSix(0);

        System.out.println("Задание 7:");
        System.out.println(taskSeven(0));

        System.out.println("Задание 8:");
        taskEight("Hello, World!", 8);

        System.out.println("Задание 9:");
        System.out.println(taskNine(800));
        System.out.println(taskNine(300));
        System.out.println(taskNine(4));
        System.out.println(taskNine(2026));

        System.out.println("Задание 10:");
        taskTen();
        System.out.println();

        System.out.println("Задание 11:");
        taskEleven();
        System.out.println();

        System.out.println("Задание 12:");
        taskTwelve();
        System.out.println();

        System.out.println("Задание 13:");
        taskThirteen(15);

        System.out.println("Задание 14:");
        OutputArray(taskFourteen(8, 3));
    }


    public static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }

    public static void checkSumSign() {
        int a = 2;
        int b = 4;
        if (a + b >= 0) {
            System.out.println("Сумма положительная");

        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {
        int value = 46;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 78;
        int b = 39;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static boolean taskFive(int a, int b) {
        if (a + b >= 10 && a + b <= 20) {
            return true;
        } else {
            return false;
        }

    }

    public static void taskSix(int a) {
        if (a >= 0) {
            System.out.println("Положительное число");
        } else {
            System.out.println("Отрицательное число");
        }
    }

    public static boolean taskSeven(int a) {
        if (a >= 0) {
            return false;
        } else {
            return true;
        }
    }

    public static void taskEight(String str, int a) {
        for (int i = 0; i < a; i++) {
            System.out.println(str);
        }
    }

    public static boolean taskNine(int a) {
        if (a % 400 == 0) {
            return true;
        } else if (a % 100 == 0) {
            return false;
        } else if (a % 4 == 0) {
            return true;
        } else {
            return false;

        }
    }

    public static void taskTen() {
        int[] array = {1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0};
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
        OutputArray(array);
    }

    public static void taskEleven() {
        int[] nums = new int[100];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }

        OutputArray(nums);
    }

    public static void taskTwelve() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] = array[i] * 2;
            }
        }

        OutputArray(array);
    }

    public static void taskThirteen(int n) {
        int[][] array = new int[n][n];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j || i + j == n - 1) {
                    array[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }

    }

    public static int[] taskFourteen(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }
        return array;
    }

    public static void OutputArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}