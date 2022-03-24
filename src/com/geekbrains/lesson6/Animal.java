package com.geekbrains.lesson6;

public abstract class Animal {

    protected String name;
    protected static int counterOfAnimal = 0;

    protected Animal(String name){
        this.name = name;
        counterOfAnimal++;
    }

    public String getName() {
        return name;
    }

    protected abstract void run(int distance);
    protected abstract void swim(int distance);
}
