package com.geekbrains.lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void addFood(int food) {
        this.food += food;
        System.out.println("Добавили " + food + " еды.\n");
    }

    public void decreaseFood(int n) {
        if (food >= n) {
            food -= n;
        }
    }

    public void info() {
        System.out.println("plate: " + food);
    }
}