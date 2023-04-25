// 1. Реализовать алгоритм обратной сортировки списков компаратором.
// 2. Пусть дан произвольный список целых чисел, удалить из него чётные числа.
// 3. Задан целочисленный список ArrayList.
//    Найти минимальное, максимальное и среднее из этого списка.
// 4. Дано два целочисленных списка,
//    объеденить их, не допуская элементы второго списка уже встречающиеся в первом.
// 5. Создать ArrayList<Integer> и добавить нулевым элементом ноль 10000 раз.
// 6. Повторить пятый пункт, но с LinkedList.
// 7. Сравнить время работы пятого и шестого пунктов.

package untitled.src.main.java.org.example;

import java.util.*;

public class HomeWork_3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("1. Обратная сортировка списка компаратором.");
        System.out.print("Введите количество элементов списка: ");
        int elementsCount = in.nextInt();
        ArrayList<Integer> myList = new ArrayList<>();
        for (int i = 0; i < elementsCount; i++) {
            myList.add(new Random().nextInt(20));
        }
        System.out.println(myList);
//        myList.sort(Comparator.reverseOrder());
        myList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(myList);
        System.out.println("-".repeat(70));

        System.out.println("2. Удаление чётных чисел из списка.");
        Iterator<Integer> iterator = myList.iterator();
        while (iterator.hasNext()) {
            int n = iterator.next();
            if (n % 2 == 0) iterator.remove();
        }
        System.out.println(myList);
        System.out.println("-".repeat(70));

        System.out.println("3. Нахождение минимального, максимального и среднего из списка.");
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        double sum = 0;
        for (int i : myList) {
            if (i < minValue) minValue = i;
            if (i > maxValue) maxValue = i;
            sum += i;
        }
        double average = sum / myList.size();
        System.out.printf("Минимальное значение: %d\n" +
                "Максимальное значение: %d\n" +
                "Среднее арифметическое: %.2f\n", minValue, maxValue, average);
        System.out.println("-".repeat(70));

        System.out.println("4. Объединение двух списков.");
        System.out.print("Введите количество элементов нового списка: ");
        int newElementsCount = in.nextInt();
        ArrayList<Integer> newList = new ArrayList<>();
        for (int i = 0; i < newElementsCount; i++) {
            newList.add(new Random().nextInt(20));
        }
        System.out.println("Новый список: " + newList);
        newList.removeAll(myList);
        System.out.println("Элементы нового списка, не встречающиеся в первом: " + newList);
        myList.addAll(newList);
        System.out.println("Итоговый список: " + myList);
        System.out.println("-".repeat(70));

        System.out.println("5. Добавление в ArrayList<Integer> нулевым элементом нуля 100000 раз.");
        long begin1 = System.currentTimeMillis();
        ArrayList<Integer> zeros1 = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            zeros1.add(0, 0);
        }
        long end1 = System.currentTimeMillis();
        double time1 = end1 - begin1;
        System.out.println("Время работы метода ArrayList: " + time1);
        System.out.println("-".repeat(70));

        System.out.println("6. Повторение пятого пункта, но с LinkedList.");
        long begin2 = System.currentTimeMillis();
        LinkedList<Integer> zeros2 = new LinkedList<>();
        for (int i = 0; i < 100000; i++) {
            zeros2.add(0, 0);
        }
        long end2 = System.currentTimeMillis();
        double time2 = end2 - begin2;
        System.out.println("Время работы метода LinkedList: " + time2);
        System.out.println("-".repeat(70));

        System.out.println("7. Сравнение времени работы пятого и шестого пунктов.");
        double result = time1 / time2;
        System.out.printf("LinkedList в %.2f раз(а) быстрее, чем ArrayList.\n", result);
        System.out.println("-".repeat(70));
        in.close();
    }
}
