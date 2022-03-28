package com.geekbrains.lesson6;

public class Dog extends Animal{

    private static int counterOfDogs = 0;
    public Dog(String name) {
        super(name);
        counterOfDogs++;
    }

    public static int getCounterOfDogs() {
        return counterOfDogs;
    }

    public void run(int distannce){
        if (distannce >= 500){
            System.out.println("Собака " + this.name + " пробежал 500 м.");
        } else if (distannce >= 0 && distannce < 500){
            System.out.println("Собака " + this.name + " пробежал " + distannce + " м.");
        }
    }

    public void swim(int distannce){
        if (distannce >= 10){
            System.out.println("Собака " + this.name + " проплыл 10 м.");
        } else if (distannce >= 0 && distannce < 10){
            System.out.println("Собака " + this.name + " проплыл " + distannce + " м.");
        }
    }
}
