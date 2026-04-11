package task2;

public class Shape implements Colorable {
    protected String backgroundColor;
    protected String borderColor;

    Shape(){
        borderColor = "Прозрачный";
        backgroundColor = "Прозрачный";
    }

    @Override
    public void setBorderColor(String color) {
        borderColor = color;
    }

    @Override
    public void setBackgroundColor(String color) {
        backgroundColor = color;
    }
}
