package task1;

public class Bowl {
    private int foodAmount;

    Bowl(int foodAmount){
        this.foodAmount = foodAmount;
    }

    public void printFoodAmount(){
        System.out.println("В миске " + foodAmount + " еды.");
    }

    public void addFood(int x){
        if (x > 0){
            foodAmount += x;
            System.out.println("В миску дабавили " + x + " еды.");
        }
    }

    public boolean tryEatFrom(int portion){
        if (foodAmount >= portion){
            foodAmount -= portion;
            return true;
        }
        else{
            return false;
        }
    }
}
