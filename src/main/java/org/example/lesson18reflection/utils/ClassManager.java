package org.example.lesson18reflection.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class ClassManager {
    public static void printClassInfo(Class<?> clazz) {
        System.out.println("Class name: " + clazz.getSimpleName());

        List<Field> fields = Arrays.stream(clazz.getDeclaredFields()).collect(Collectors.toList());

        fields.stream().peek(f -> f.setAccessible(true))
                .forEach(f -> System.out.println("Field name: " + f.getName() + ", modifier: " + getModifierName(f.getModifiers()) + ", type: " + f.getType()));
        System.out.println("\n");

        List<Constructor<?>> constructors = Arrays.stream(clazz.getConstructors()).collect(Collectors.toList());

        constructors.stream().peek(c -> c.setAccessible(true))
                .forEach(c -> System.out.println("Constructor name: " + c.getName() + ", modifier: " + getModifierName(c.getModifiers())
                        + ", parameters type: " + Arrays.toString(c.getParameterTypes())));
        System.out.println("\n");

        List<Method> methods = Arrays.stream(clazz.getDeclaredMethods()).collect(Collectors.toList());

        methods.stream().peek(m -> m.setAccessible(true))
                .forEach(m -> System.out.println("Method name: " + m.getName() + ", modifier: " + getModifierName(m.getModifiers())
                        + ", parameters types: " + Arrays.toString(m.getParameterTypes()) + ", return type: " + m.getReturnType()));

    }

    private static String getModifierName(int allModifiers) {
        if ((allModifiers & Modifier.PRIVATE) > 0) {
            return "private";
        } else if ((allModifiers & Modifier.PROTECTED) > 0) {
            return "protected";
        } else if ((allModifiers & Modifier.PUBLIC) > 0) {
            return "public";
        } else {
            return "without modifier";
        }
    }

    public static List<Method> getMethodsWithAnnotation(Class<?> clazz, Class<? extends Annotation> annotation) {
        List<Method> methods = Arrays.stream(clazz.getMethods()).collect(Collectors.toList());
        List<Method> result = new ArrayList<>();
        methods.stream().peek(m -> m.setAccessible(true))
                .forEach(m -> {
                    if (m.isAnnotationPresent(annotation)) {
                        result.add(m);
                    }
                });
        return result;
    }
}
