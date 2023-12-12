package org.example.lesson4cycles;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Main {
    public static void main(String[] args) {
        // Вычислить факториал целых чисел от 0 до 10 с помощью цикла while
        int i1 = 0;
        while (i1 < 11) {
            int factorial = calculateFactorial(i1);
            System.out.println("Factorial " + i1 + " = " + factorial);
            i1++;
        }

        /* Вычислить произведение чисел от 1 до 25 с помощью цикла while*/
        BigInteger productOfNumbers = BigInteger.ONE;
        BigInteger increment = BigInteger.ONE;
        int counter = 1;
        while (counter <= 25) {
            productOfNumbers = productOfNumbers.multiply(increment);
            increment = increment.add(BigInteger.ONE);
            counter++;
        }
        System.out.println("Product of number: " + productOfNumbers);

        /* Посчитать сумму цифр числа 7893823445 с помощью цикла do while*/
        long number = 7893823445L;
        int sumOfDigits = 0;
        do {
            sumOfDigits += number % 10;
            number /= 10;
        } while (number != 0);

        System.out.println("Sum of digits of a number 7893823445 = " + sumOfDigits);

        /* Найти среди чисел от 50 до 70 второе простое число и завершить цикл*/
        boolean isSimple = true;
        int simpleNumber = 0;
        int counterOfSimpleNumbers = 0;
        for (int i = 50; i <= 70; i++) {
            isSimple = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isSimple = false;
                    break;
                }
            }
            if (isSimple) {
                simpleNumber = i;
                counterOfSimpleNumbers++;
                if (counterOfSimpleNumbers == 2) break;
            }
        }
        System.out.println("Second simple number: " + simpleNumber);


        /* Для целых чисел, которые делятся на 7 в диапазоне от 1 до 100, вывести на экран строку "Hope!"*/
        for (int i = 1; i < 101; i++) {
            if (i % 7 == 0) {
                System.out.println(i + " Hope!");
            }
        }

        /* Задать произвольное целое число и вывести его в бухгалтерском формате, то есть, начиная справа, каждые три позиции отделяются пробелом.
         * Например 20023143 - 20 023 143*/
        int intNumber = 20023143;
        StringBuilder result = new StringBuilder();
        do {
            String currentNumber = intNumber % 1000 < 100 && intNumber / 1000 != 0? "0" + intNumber % 1000 : String.valueOf(intNumber % 1000);
            result.insert(0, currentNumber + " ");
            intNumber /= 1000;
        } while (intNumber != 0);
        System.out.println(result);

        intNumber = 20023143;
        DecimalFormat formatter = new DecimalFormat();
        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
        symbols.setGroupingSeparator(' ');
        formatter.setDecimalFormatSymbols(symbols);
        System.out.println(formatter.format(intNumber));
    }

    public static int calculateFactorial(int number) {
        int factorial = 1;
        int i = 1;
        while (i <= number) {
            factorial *= i++;
        }
        return factorial;
    }
}
