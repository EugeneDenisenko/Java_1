package com.geekbrains.lesson5;

public class HomeWorkApp5 {
    public static void main(String[] args) {

        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Денисенко Евгений", "developer", "evg.den@gmail.com",
                80296404689L, 3000, 31);
        employees[1] = new Employee("Осипов Олег", "developer", "vopisso@mail.ru",
                80296781519L, 3000, 41);
        employees[2] = new Employee("Крук Сергей", "tester", "serg.kruk@gmail.com",
                80294587489L, 2500, 32);
        employees[3] = new Employee("Петрачков Александр", "tester", "petra1967@mail.ru",
                80296541238L, 2000, 54);
        employees[4] = new Employee("Денисенко Алина", "designer", "alinka1952@yandex.ru",
                80291055526L, 1500, 29);

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() > 40) {
                System.out.println("#" + (i + 1) + " " + employees[i]);
            }
        }
    }
}