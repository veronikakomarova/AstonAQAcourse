package task2;

public interface PerimeterCalculatable {
    int[] getSides();

    default double getPerimeter(){
         int[] sides = getSides();

         int sum = 0;
         for (int side : sides){
             sum += side;
         }
         return sum;
    }
}
