package com.geekbrains.lesson7;

public class HomeWorkApp7 {
    public static void main(String[] args) {

        Cat cat = new Cat("Maks", 15);
        Plate plate = new Plate(100);

        plate.info();
        cat.eat(plate);
        plate.info();

    }
}