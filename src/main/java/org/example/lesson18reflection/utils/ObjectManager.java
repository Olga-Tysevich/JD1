package org.example.lesson18reflection.utils;

import org.example.lesson18reflection.models.Man;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public abstract class ObjectManager {
    public static Man createMan(String name, String surname, int age) {
        Man result = null;
        try {
            Constructor<Man> constructor = Man.class.getConstructor(String.class, String.class, int.class);
            result = constructor.newInstance(name, surname, age);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void changeMan(Man man, String newName, String newSurname, int newAge) {
        Class<?> manClass = man.getClass();
        try {
            Method setName = manClass.getDeclaredMethod("setName", String.class);
            setName.setAccessible(true);
            setName.invoke(man, newName);
            Method setSurname = manClass.getDeclaredMethod("setSurname", String.class);
            setSurname.setAccessible(true);
            setSurname.invoke(man,newSurname);
            Method setAge = man.getClass().getDeclaredMethod("setAge", int.class);
            setAge.setAccessible(true);
            setAge.invoke(man, newAge);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
