package org.example.lesson5arrays;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        /*Создайте переменную для массива из 10 элементов. Заполните его произвольными значениями целочисленного типа и выведите последний элемент
        массива на экран*/
        int[] array = new int[10];
        fillArray(array);
        System.out.println(array[array.length - 1]);

        /*Создайте переменную для массива из 10 элементов (Другим способом). Заполните его произвольными значениями целочисленного типа
        и выведите на экран элементы в четных позициях*/
        int[] array2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        fillArray(array2);
        for (int i = 0; i < array2.length; i++) {
            if (i % 2 == 0) {
                System.out.println("Position: " + i + ", value: " + array2[i]);
            }
        }

        /*Создайте переменную для массива из 10 элементов. Заполните его произвольными значениями целочисленного типа.
        Найдите максимальный элемент и выведите его индекс*/
        int[] array3 = new int[10];
        fillArray(array3);
        int maxElement = array3[0];
        int maxElementPosition = 0;
        for (int i = 0; i < array3.length; i++) {
            System.out.print(array3[i] + " ");
            if (maxElement < array3[i]) {
                maxElement = array3[i];
                maxElementPosition = i;
            }
        }
        System.out.println("Max element: " + maxElement + ", position: " + maxElementPosition);

        /*Создайте переменную для массива из 10 элементов. Заполните его произвольными значениями целочисленного типа.
        Определите сумму элементов массива, расположенных между мин и макс значениями. Если их несколько, то необходимо
        взять максимальное значение разницы индексов между максимальным и минимальным значениями*/
        int[] array4 = new int[10];
        fillArray(array4);
        int minEl = array4[0];
        int minPos = 0;
        int maxEl = array4[0];
        int maxPos = 0;
        for (int i = 0; i < array4.length; i++) {
            System.out.print(array4[i] + " ");
            if (maxEl < array4[i]) {
                maxEl = array4[i];
                maxPos = i;
            }
            if (minEl > array4[i]) {
                minEl = array4[i];
                minPos = i;
            }
            if (maxEl == array4[i]) {
                maxPos = Math.abs(maxPos - minPos) < (i - minPos) ? i : maxPos;
            } else if (minEl == array4[i]) {
                minPos = Math.abs(maxPos - minPos) < (maxPos - i) ? i : minPos;
            }
        }
        int sumOfNumbers = 0;
        for (int i = Math.min(minPos, maxPos) + 1; i < Math.max(minPos, maxPos); i++) {
            sumOfNumbers += array4[i];
        }
        System.out.println("\nMin pos: " + minPos + ", max pos: " + maxPos + ", sum: " + sumOfNumbers);

        /*Создайте переменную для массива из 10 элементов. Заполните его произвольными значениями целочисленного типа.
        Выведите на экран, переверните и снова выведите на экран (новый массив не создавать)*/
        int[] array5 = new int[10];
        fillArray(array5);
        Arrays.stream(array5).forEach(e -> System.out.print(e + " "));
        for (int i = 0; i < array5.length / 2; i++) {
            int temp = array5[i];
            array5[i] = array5[array5.length - i - 1];
            array5[array5.length - i - 1] = temp;
        }
        System.out.println();
        Arrays.stream(array5).forEach(e -> System.out.print(e + " "));

        /*Создать двухмерный квадратный массив и заполнить его бабочкой*/
        int[][] twoDArray = new int[5][5];
        int currentZeroPosition = 0;
        for (int i = 0; i < twoDArray.length; i++) {
            if (i == 0 || i == twoDArray.length - 1) {
                Arrays.fill(twoDArray[i], 1);
            } else {
                for (int j = 0; j < twoDArray[i].length; j++) {
                    if (j > currentZeroPosition && j < twoDArray[i].length - 1 - currentZeroPosition) {
                        twoDArray[i][j] = 1;
                    }
                }
                if (i < twoDArray.length / 2) {
                    ++currentZeroPosition;
                } else {
                    --currentZeroPosition;
                }
            }
        }
        System.out.println();
        for (int[] ints : twoDArray) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(101);
        }
    }
}
