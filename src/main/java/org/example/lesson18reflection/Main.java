package org.example.lesson18reflection;

import org.example.lesson18reflection.annotation.AcademyInfo;
import org.example.lesson18reflection.utils.ClassManager;
import org.example.lesson18reflection.models.Man;
import org.example.lesson18reflection.utils.ObjectManager;
import org.example.lesson18reflection.utils.Printer;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        /*Создать класс Man с произвольным набором полей и методов (не менее 3).
         * Создать метод, который распечатает иформацию о классе с помощью рефлексии.
         * Вызвать метод с помощью рефлексии из основной программы*/
        ClassManager.printClassInfo(Man.class);
        Man man = ObjectManager.createMan("Bender", "Steel", 18);
        System.out.println("Created man: " + man);
        ObjectManager.changeMan(man, "Harry", "Lewis", 25);
        System.out.println("After change: " + man);


        /*Создайте класс с методом printHelloWorld(). Вызвать метод с помощью рефлексии из основной программы*/
        try {
            Method printHelloWorld = Printer.class.getDeclaredMethod("printHelloWorld");
            printHelloWorld.invoke(Printer.class);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

        /*Создайте собственную аннотацию @AcademyInfo с полем year. Создать метод, помеченный этой аннотацией
        * с заданным year и метод без неею С помощью рефлексии проверить наличие данной аннотации у этих методов из основной программы*/
        List<Method> result = ClassManager.getMethodsWithAnnotation(Printer.class, AcademyInfo.class);
        result.forEach(m -> {
            System.out.println("Method " + m.getName() + " has annotation " + AcademyInfo.class.getSimpleName()
                    + " with year: " + m.getAnnotation(AcademyInfo.class).year());
        });
    }
}
