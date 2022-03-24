package com.geekbrains.lesson6;

public class Cat extends Animal{

    private static int counterOfCats = 0;
    public Cat(String name) {
        super(name);
        counterOfCats++;
    }

    public static int getCounterOfCats() {
        return counterOfCats;
    }

    public void run(int distannce){
        if (distannce >= 200){
            System.out.println("Кот " + this.name + " пробежал 200 м.");
        } else if (distannce >= 0 && distannce < 200){
            System.out.println("Кот " + this.name + " пробежал " + distannce + " м.");
        }
    }

    public void swim(int distannce){
        System.out.println("Кот " + this.name + " не умеет плавать." );
    }
}
