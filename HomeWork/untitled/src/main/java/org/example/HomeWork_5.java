//Создать множество, ключ и значение строки. Добавить шесть элементов. Вывести в консоль значения.
//Добавить ко всем значениям символ "!".
//Создать второе множество с таким же обобщением.
//Ключи второго множества частично совпадают с ключами первого.
//Объеденить значания во втором множестве и первом, если ключи совпадают. Вывести результат в консоль.

package untitled.src.main.java.org.example;

import java.util.HashMap;
import java.util.Set;

public class HomeWork_5 {

    public static void main(String[] args) {

        HashMap<String, String> map = new HashMap<>();
        map.put("один", "one");
        map.put("два", "two");
        map.put("три", "three");
        map.put("четыре", "four");
        map.put("пять", "five");
        map.put("шесть", "six");
        System.out.println("1. Значения элементов заданного множества:\n" + map.values());
        System.out.println("-".repeat(60));

        for (String key : map.keySet()) {
            map.compute(key, (k, v) -> v + "!");
        }
        System.out.println("2. К значениям элементов множества добавили символ '!':\n" + map.values());

        for (String key : map.keySet()) {
            map.merge(key, "!", String::concat);
        }
        System.out.println("Второй способ:\n" + map.values());

        System.out.println("Третий способ:");
        map.forEach((k, v) -> System.out.print(v + "!"));
        System.out.println();
        System.out.println("-".repeat(60));

        HashMap<String, String> newMap = new HashMap<>();
        newMap.put("четыре", "4");
        newMap.put("пять", "5");
        newMap.put("шесть", "6");
        newMap.put("семь", "7");
        newMap.put("восемь", "8");
        newMap.put("девять", "9");
        newMap.put("десять", "10");

        System.out.println("3. Значения элементов второго множества:");
        Set keys = newMap.keySet();
        for (int i = 0; i < keys.size(); i++) {
            System.out.print(newMap.get(keys.toArray()[i]) + " ");
        }

        HashMap<String, String> resultMap = new HashMap<>();
        for (String key : map.keySet()) {
            if (newMap.containsKey(key)) {
                newMap.merge(key, "-" + map.get(key), String::concat);
            }
        }
        resultMap.putAll(map);
        resultMap.putAll(newMap);
        System.out.println("\n4. Значения элементов объединённых множеств:\n" + resultMap.values());
    }
}
