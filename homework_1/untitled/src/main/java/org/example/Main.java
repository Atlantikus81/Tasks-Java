// Первый семинар.
// 1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
// 2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
// 3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
// 4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
//
// Пункты реализовать в методе main

package org.example;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int i = new Random().nextInt(0, 2001);
        System.out.printf("1. Случайное целое число от 0 до 2000: %d \n", i);

        int n = Integer.toBinaryString(i).length();
        System.out.printf("2. Номер старшего значащего бита числа %d: %d \n", i, n);

        int[] m1 = MultiplesNumbers(i, n);
        System.out.println(Arrays.toString(m1));
        int[] m2 = NonMultipleNumbers(i, n);
        System.out.println(Arrays.toString(m2));
    }


    static int[] MultiplesNumbers(int x, int y) {
        int elementsCount = 0;
        for (int l = x; l <= Short.MAX_VALUE; l++)
            if (l % y == 0) elementsCount++;
        System.out.printf("3. Количество чисел крытных %d от %d до %d: %d \n", y, x, Short.MAX_VALUE, elementsCount);
        int[] array = new int[elementsCount];
        int j = 0;
        for (int l = x; l <= Short.MAX_VALUE; l++)
            if (l % y == 0) {
                array[j] = l;
                j++;
            }
        return array;
    }


    static int[] NonMultipleNumbers(int x, int y) {
        int elementsCount = 0;
        for (int l = Short.MIN_VALUE; l <= x; l++)
            if (l % y != 0) elementsCount++;
        System.out.printf("4. Количество чисел некратных %d от %d до %d: %d \n", y, Short.MIN_VALUE, x, elementsCount);
        int[] array = new int[elementsCount];
        int j = 0;
        for (int l = Short.MIN_VALUE; l <= x; l++)
            if (l % y != 0) {
                array[j] = l;
                j++;
            }
        return array;
    }
}
