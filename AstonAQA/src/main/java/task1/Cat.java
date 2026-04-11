package task1;

public class Cat extends Animal {

    private static int counter;

    Cat(String name, int appetite) {
        super(name);
        this.appetite = appetite;
        fullness = false;
        counter++;
    }

    public static int getCounter(){
        return counter;
    }


    private int appetite;
    private boolean fullness;

    @Override
    protected int getRunMaxDistance() {
        return 200;
    }

    @Override
    protected int getSwimMaxDistance() {
        return 0;
    }

    void eat(Bowl bowlToEat) {
        if (fullness){
            System.out.println(name + " уже сыт.");
            return;
        }

        boolean success = bowlToEat.tryEatFrom(appetite);

        if (success) {
            fullness = true;
            System.out.println(name + " покушал.");
        }
        else {
            System.out.println(name + " не смог покушать.");
        }



    }

    void printFullness(){
        if (fullness){
            System.out.println(name + " сыт.");
        }
        else {
            System.out.println(name + " голоден.");
        }
    }


}
