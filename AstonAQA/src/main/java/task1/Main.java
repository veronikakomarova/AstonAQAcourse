package task1;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Dog doggi = new Dog("Doggi");
        Cat kitti = new Cat("Kitti", 1);

        doggi.run(500);
        doggi.run(600);
        doggi.swim(10);
        doggi.swim(20);
        kitti.run(200);
        kitti.run(300);
        kitti.swim(20);

        Cat[] catsMrr = new Cat[3];
        catsMrr[0] = new Cat("Myrzik", 15);
        catsMrr[1] = new Cat("Boris", 10);
        catsMrr[2] = new Cat("Pushok", 20);

        Bowl bowl = new Bowl(30);

        for (Cat i:catsMrr){
            i.printFullness();
        }

        bowl.printFoodAmount();

        for (Cat i:catsMrr){
            i.eat(bowl);
            i.printFullness();
        }

        bowl.printFoodAmount();
        bowl.addFood(100);
        bowl.printFoodAmount();

        for (Cat i:catsMrr){
            i.eat(bowl);
        }

        bowl.printFoodAmount();


        System.out.println("Общий счетчик животных: " + Animal.getTotalCounter());
        System.out.println("Счетчик собак: " + Dog.getCounter());
        System.out.println("Счетчик котов: " + Cat.getCounter());


    }
}