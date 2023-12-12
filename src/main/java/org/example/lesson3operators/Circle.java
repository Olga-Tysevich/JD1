package org.example.lesson3operators;

public class Circle extends Shape{
    private final int radius;

    public Circle(int radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int getDiagonal() {
        return 2 * radius;
    }

    public int getRadius() {
        return radius;
    }
}
