package org.example;

import java.util.ArrayList;
import java.util.List;

class Park {
    private String name;
    private int minimalPrice;
    private boolean parking;

    private List<Atraction> atractions;

    Park(String name, int minimalPrice, boolean parking){
        this.name = name;
        this.minimalPrice = minimalPrice;
        this.parking = parking;
        atractions = new ArrayList<Atraction>();
    }

    void AddAtraction(String atractionName, String atractionOpeningHours, int atractionPrice){

        if (atractionPrice < minimalPrice){
            return;
        }

        Atraction atraction = new Atraction(atractionName, atractionOpeningHours, atractionPrice);
        atractions.add(atraction);
    }

    public void printInfo(){
        System.out.println("Название парка: " + name + "; Минимальная стоимость атракциона:  " + minimalPrice + "; Наличие парковки: " + (parking ? "Есть" : "Нет"));

        if (!atractions.isEmpty()){
            System.out.println("Атракционы:");
        }
        else {
            System.out.println("Нет атракционов.");
            return;
        }

        for (Atraction atraction : atractions){
            atraction.printInfo();
        }
    }
}

class Atraction {
    private String name;
    private String openingHours;
    private int price;

    Atraction(String name, String openingHours, int price){
        this.name = name;
        this.openingHours = openingHours;
        this.price = price;
    }

    public void printInfo() {
        System.out.println("Название: " + name + "; время работы: " + openingHours + "; стоимость: " + price);
    }
}

