package com.geekbrains.lesson7;

public class HomeWorkApp7 {
    public static void main(String[] args) {

        Plate plate = new Plate(50);
        Cat[] cats = new Cat[5];
        cats[0] = new Cat("Maks", 15);
        cats[1] = new Cat("Barsik", 65);
        cats[2] = new Cat("Tom", 30);
        cats[3] = new Cat("Javik", 25);
        cats[4] = new Cat("Pushok", 55);

        plate.info();
        for (Cat cat : cats) {
            cat.eat(plate);
            System.out.println(cat.toString());
            System.out.println();
            if (plate.getFood() < 15) {
                plate.addFood(50);
            }
        }
    }
}