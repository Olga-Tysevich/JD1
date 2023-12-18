package org.example.fixed.lesson3operators.figures;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Rectangle extends Shape {
    private int a;
    private int b;

    public Rectangle(int a, int b) {
        if (a > 0 && b > 0) {
            this.a = a;
            this.b = b;
        } else {
            throw new IllegalArgumentException();
        }
    }


    @Override
    public int getDiagonal() {
        return (int) sqrt(pow(a, 2) + pow(b, 2));
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}
