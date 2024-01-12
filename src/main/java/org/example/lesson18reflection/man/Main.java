package org.example.lesson18reflection.man;

public class Main {
    public static void main(String[] args) {
        /*Создать класс Man с произвольным набором полей и методов (не менее 3).
        * Создать метод, который распечатает иформацию о классе с помощью рефлексии.
        * Вызвать метод с помощью рефлексии из основной программы*/
        ClassInfoPrinter.printClassInfo(Man.class);
        Man man = ObjectManager.createMan("Bender", "Steel", 18);
        System.out.println("Created man: " + man);
        ObjectManager.changeMan(man, "Harry", "Lewis", 25);
        System.out.println("After change: " + man);
    }
}
