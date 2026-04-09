package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Задание 2");
        Product[] productsList = new Product[5];
        productsList[0] = new Product("Apple MacBook Pro 15", "01.01.2013", "Apple", "США", 600, true);
        productsList[1] = new Product("ASUS ROG Zephyrus G14", "02.02.2021", "ASUSTeK Computer Inc.", "Тайвань", 1250, false);
        productsList[2] = new Product(" Lenovo ThinkPad T480", "03.03.2018", "Lenovo", "Китай", 500, true);
        productsList[3] = new Product("Samsung Galaxy Book3 Ultra", "04.04.2023", "Samsung Electronics", "Южная Корея", 2200, false);
        productsList[4] = new Product("Dell Latitude 5420", "05.05.2020", "Dell Technologies", "Вьетнам", 850, true);

        for (Product i: productsList){
            i.printInfo();
            System.out.println();
        }

        System.out.println();
        System.out.println("Задание 3");
        Park parkPobedi = new Park("Парк Победы", 50, true);
        parkPobedi.AddAtraction("Ракушки", "09:00-22:00", 30);
        parkPobedi.AddAtraction("Бум", "09:00-22:00", 50);
        parkPobedi.AddAtraction("Веселые горки", "08:00-22:00", 100);

        Park parkGorkogo = new Park("Парк Горького", 30, true);
        parkGorkogo.AddAtraction("Старт", "09:00-22:00", 20);
        parkGorkogo.AddAtraction("Шаман", "09:00-22:00", 10);
        parkGorkogo.AddAtraction("Байкал", "10:00-22:00", 100);

        Park parkPushkina = new Park("Парк Пушкина", 0, false);

        parkPobedi.printInfo();
        System.out.println();
        parkGorkogo.printInfo();
        System.out.println();
        parkPushkina.printInfo();
    }
}
