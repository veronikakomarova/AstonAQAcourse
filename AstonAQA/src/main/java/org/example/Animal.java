package org.example;

public abstract class Animal {
    protected String name;
    private static int totalCounter;

    Animal(String name) {
        this.name = name;
        totalCounter++;
    }

    public static int getTotalCounter(){
        return totalCounter;
    }


    /// бег
    public void run(int distance) {

        int maxDistance = getRunMaxDistance();

        if (maxDistance <= 0) {
            System.out.println(name + " не умеет бегать.");
        }
        else if (distance <= maxDistance && distance >= 0) {
            System.out.println(name + " пробежал " + distance + " м.");
        }
        else {
            System.out.println(name + " не может столько пробежать.");
        }
    }

    public void swim(int distance) {
        int maxDistance = getSwimMaxDistance();

        if (maxDistance <= 0) {
            System.out.println(name + " не умеет плавать.");
        }
        else if (distance <= maxDistance && distance >= 0) {
            System.out.println(name + " проплыл " + distance + " м.");
        }
        else {
            System.out.println(name + " не может столько проплыть.");
        }
    }


    protected abstract int getRunMaxDistance();

    protected abstract int getSwimMaxDistance();
}
