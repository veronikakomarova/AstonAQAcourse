package org.example;

public class Product {
    private String name;
    private String productionDate;
    private String producer;
    private String countryOfOrigin;
    private int price;
    private boolean  bookingStatus;

    Product(String name, String productionDate, String producer, String countryOfOrigin, int price, boolean bookingStatus){
        this.name = name;
        this.productionDate = productionDate;
        this.producer = producer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.bookingStatus = bookingStatus;
    }

    public void printInfo(){
        System.out.println("Название: " + name + ";\n" +
                "Дата производства: " + productionDate + ";\n" +
                "Производитель: " + producer + ";\n" +
                "Страна происхождения: " + countryOfOrigin + ";\n" +
                "Цена: " + price + ";\n" +
                "Состояние бронирования покупателем: " + (bookingStatus ? "Забронировано" : "Свободно"));
    }
}
