package org.example;

public class Dog extends Animal{

    private static int counter;

    Dog(String name){
        super(name);
        counter++;
    }

    public static int getCounter(){
        return counter;
    }

    ///  получить максимальную дистанцию бега
    @Override
    protected int getRunMaxDistance() {
        return 500;
    }

    @Override
    protected int getSwimMaxDistance() {
        return 10;
    }
}
