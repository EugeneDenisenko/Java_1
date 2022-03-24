package com.geekbrains.lesson6;

public class HomeWorkApp6 {
    public static void main(String[] args) {

        Cat catBarsik = new Cat("Барсик");
        catBarsik.run(50);
        catBarsik.swim(5);
        System.out.println("-----");

        Cat catMaks = new Cat("Макс");
        catMaks.run(201);
        catMaks.swim(10);
        System.out.println("-----");

        Dog dogVenia = new Dog("Венька");
        dogVenia.run(150);
        dogVenia.swim(15);
        System.out.println("-----");

        System.out.println("Было создано " + Animal.counterOfAnimal + " животных.");
        System.out.println("Было создано " + Dog.getCounterOfDogs() + " собак.");
        System.out.println("Было создано " + Cat.getCounterOfCats() + " котов.");
    }
}
