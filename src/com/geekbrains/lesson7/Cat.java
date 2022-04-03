package com.geekbrains.lesson7;

public class Cat {
    private final String name;
    private final int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate plate) {
        if (plate.getFood() >= appetite) {
            plate.decreaseFood(appetite);
            satiety = true;
        } else {
            System.out.println("Не стал есть. Видно дно.");
        }
    }

    @Override
    public String toString() {
        return "Cat {" +
                "name = '" + name + '\'' +
                ", appetite = " + appetite +
                ", satiety = " + satiety +
                '}';
    }
}